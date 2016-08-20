package com.zc.mvp.mvpsample.presenter;

import com.zc.mvp.mvpsample.model.LoginModel;
import com.zc.mvp.mvpsample.model.LoginModelImpl;
import com.zc.mvp.mvpsample.view.LoginView;

import okhttp3.ResponseBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2016/8/20.
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginModel = new LoginModelImpl();
        this.loginView = loginView;
    }

    @Override
    public void loginCheck(String username, String password) {
        loginView.progressVisible(true);

        loginModel.login(username, password).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.progressVisible(false);
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        loginView.progressVisible(false);
                    }
                });
    }

    @Override
    public void destroyView() {
        loginView = null;
    }

}
