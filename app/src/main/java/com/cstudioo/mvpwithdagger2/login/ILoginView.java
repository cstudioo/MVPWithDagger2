package com.cstudioo.mvpwithdagger2.login;


import com.cstudioo.mvpwithdagger2.webservice.model.response.ResponseLogin;

/**
 * Created by 3223 on 05/01/17.
 */

public interface ILoginView {

    void showLoading();

    void hideLoading();

    void setEmailError(int errRes);

    void setPasswordError(int errRes);

    void loginSuccess(ResponseLogin user);

    void loginFailure(int errMsg);

    void loginFailure(String errMsg);
}
