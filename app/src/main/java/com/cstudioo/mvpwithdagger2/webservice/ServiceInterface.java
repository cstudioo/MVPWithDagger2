package com.cstudioo.mvpwithdagger2.webservice;


import com.cstudioo.mvpwithdagger2.webservice.model.request.Login;
import com.cstudioo.mvpwithdagger2.webservice.model.response.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * This interface will describe service methods.
 */

public interface ServiceInterface {

    static final String LOGIN = "login";

    @POST(LOGIN)
    Call<ResponseLogin> login(@Body Login loginCall);

}
