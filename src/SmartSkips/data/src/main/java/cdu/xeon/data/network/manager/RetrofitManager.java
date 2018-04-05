package cdu.xeon.data.network.manager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cdu.xeon.data.App;
import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.network.service.SmartSkipServer;
import cdu.xeon.data.utils.NetUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class RetrofitManager {
    public static final String BASE_SKIP_URL   = "private url1";
    public static final String BASE_DRIVER_URL    = "private url2";

    public static final int    CACHE_STALE_SHORT = 1;

    public static final int    CACHE_STALE_LONG  = 60 * 60 * 24 * 7;

    public static final String CACHE_CONTROL_AGE = "Cache-Control: public, max-age=";


    public static final String CACHE_CONTROL_CACHE   = "only-if-cached, max-stale=" + CACHE_STALE_LONG;

    public static final String CACHE_CONTROL_NETWORK = "max-age=0";
    private static OkHttpClient mOkHttpClient;
    private final SmartSkipServer mSSService;

    public static RetrofitManager builder() {
        return new RetrofitManager();
    }

    private RetrofitManager() {

        initOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SKIP_URL)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(new CustomFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mSSService = retrofit.create(SmartSkipServer.class);
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {


                    Cache cache = new Cache(new File(App.getContext().getCacheDir(), "HttpCache"),
                            1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }


    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetUtil.isNetworkConnected()) {
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheControl).removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_LONG).removeHeader("Pragma").build();
            }
        }
    };

    public Observable<List<Skip>> geSkips() {
        return mSSService.getSkips();
    }

    public Observable<List<Driver>> getDrivers() {
        return mSSService.getDrivers();
    }

    public Observable<Landfill> getLandfill() {
        return mSSService.getLandfill();
    }

    public Observable<Skip> getSkipById(int id) {
        return mSSService.getSkipDetailById(id);
    }

    public Observable<List<Operator>> getOperatorList() {
        return mSSService.getOperatorList();
    }



}
