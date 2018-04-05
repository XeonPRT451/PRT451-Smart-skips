package cdu.xeon.data.network.service;

import java.util.List;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.network.manager.RetrofitManager;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface SmartSkipServer {

    @Headers(RetrofitManager.CACHE_CONTROL_AGE + RetrofitManager.CACHE_STALE_SHORT)
    @GET("data/skipsList.action")
    Observable<List<Skip>> getSkips();


    @Headers(RetrofitManager.CACHE_CONTROL_AGE + RetrofitManager.CACHE_STALE_SHORT)
    @GET("data/driversList.action")
    Observable<List<Driver>> getDrivers();


    @Headers(RetrofitManager.CACHE_CONTROL_AGE + RetrofitManager.CACHE_STALE_SHORT)
    @GET("landfill/getLandfill.action")
    Observable<Landfill> getLandfill();

    @Headers(RetrofitManager.CACHE_CONTROL_AGE + RetrofitManager.CACHE_STALE_SHORT)
    @GET("data/getSkipById.action")
    Observable<Skip> getSkipDetailById(@Query("id") int id);


    @Headers(RetrofitManager.CACHE_CONTROL_AGE + RetrofitManager.CACHE_STALE_SHORT)
    @GET("data/operatorslist.action")
    Observable<List<Operator>> getOperatorList();


}
