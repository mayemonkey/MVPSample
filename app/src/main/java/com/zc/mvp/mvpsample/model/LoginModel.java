package com.zc.mvp.mvpsample.model;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * LoginModel
 */
public interface LoginModel {

    Observable<ResponseBody> login(String username, String password);

}
