package com.cstudioo.mvpwithdagger2.login;


import com.cstudioo.mvpwithdagger2.R;
import com.cstudioo.mvpwithdagger2.webservice.model.response.ResponseLogin;

import javax.inject.Inject;

/**
 * Created by 3223 on 06/01/17.
 */

public class LoginPresenterImpl implements ILoginPresenter {


    ILoginView mILoginView;
    ILoginInteractor mILoginInteractor;

    @Inject
    public LoginPresenterImpl(ILoginView loginView, ILoginInteractor loginInteractor) {
        this.mILoginView = loginView;
        this.mILoginInteractor = loginInteractor;
    }


    @Override
    public void login(String username, String password) {
        mILoginView.showLoading();
        mILoginInteractor.login(username, password, new ILoginInteractor.IValidationErrorListener() {
            @Override
            public void emailError(int msg) {
                mILoginView.hideLoading();
                mILoginView.setEmailError(msg);
            }

            @Override
            public void passwordError(int msg) {
                mILoginView.hideLoading();
                mILoginView.setPasswordError(msg);
            }

        }, new ILoginInteractor.IOnLoginFinishedListener() {
            @Override
            public void getUserData(ResponseLogin user) {
                mILoginView.hideLoading();
                if (user != null) {
                    mILoginView.loginSuccess(user);
                } else {
                    mILoginView.loginFailure(R.string.activity_login_fail_msg);
                }
            }

            @Override
            public void errorMsg(String msg) {
                mILoginView.hideLoading();
                mILoginView.loginFailure(msg);
            }
        });
    }
}
