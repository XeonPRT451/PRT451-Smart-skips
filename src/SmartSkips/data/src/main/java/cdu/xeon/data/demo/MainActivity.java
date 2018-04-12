package cdu.xeon.data.demo;


import android.app.Activity;

import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.network.manager.RetrofitManager;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {
    private static int  skipId=1;




    private void loadSkipById() {
        RetrofitManager.builder().
                getSkipById(this.skipId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // showProgress();
                    }
                }).map(new Func1<Skip, Skip>() {
            @Override
            public Skip call(Skip skip) {

                return skip;
            }
        }).subscribe(new Action1<Skip>() {
            @Override
            public void call(Skip skip) {
               //call
            }
        },new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                // handle error;
            }
        });
    }


}
