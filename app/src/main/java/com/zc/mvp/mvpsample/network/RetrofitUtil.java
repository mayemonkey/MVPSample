package com.zc.mvp.mvpsample.network;

import com.zc.mvp.mvpsample.network.api.LoginServer;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/8/20.
 */
public class RetrofitUtil {

    private static LoginServer loginServer;

    /**
     * 获取Retrofit中Login部分API
     *
     * @return
     */
    public static LoginServer loginServer() {
        if (loginServer == null) {
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl("http://121.120.15.16/").
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                    build();

            loginServer = retrofit.create(LoginServer.class);

        }
        return loginServer;
    }
}
