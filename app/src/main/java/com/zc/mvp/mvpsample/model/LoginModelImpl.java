package com.zc.mvp.mvpsample.model;

import com.zc.mvp.mvpsample.network.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * LoginModelImpl
 */
public class LoginModelImpl implements LoginModel {
    @Override
    public Observable<ResponseBody> login(String username, String password) {

        //登录数据设置
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        return RetrofitUtil.loginServer().login(map);
    }
}
