package com.zc.mvp.mvpsample.presenter;

/**
 * Created by admin on 2016/8/20.
 */
public interface LoginPresenter {

    void loginCheck(String username, String password);

    void destroyView();

}
