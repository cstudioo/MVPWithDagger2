package com.cstudioo.mvpwithdagger2.login;


import com.cstudioo.mvpwithdagger2.webservice.model.response.ResponseLogin;

/**
 * Created by 3223 on 05/01/17.
 */

public interface ILoginInteractor {

    void login(String userName, String passWord,
               IValidationErrorListener validationErrorListener,
               IOnLoginFinishedListener loginFinishedListener);

    interface IOnLoginFinishedListener {

        void getUserData(ResponseLogin user);

        void errorMsg(String msg);
    }

    interface IValidationErrorListener {

        void emailError(int msg);

        void passwordError(int msg);
    }
}
