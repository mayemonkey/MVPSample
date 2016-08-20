package com.zc.mvp.mvpsample.network.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2016/8/20.
 */
public interface LoginServer {
    @FormUrlEncoded
    @POST("login")
    Observable<ResponseBody> login(@FieldMap Map<String, String> map);
}
