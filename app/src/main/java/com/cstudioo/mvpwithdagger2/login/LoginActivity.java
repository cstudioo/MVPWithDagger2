package com.cstudioo.mvpwithdagger2.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cstudioo.mvpwithdagger2.MyApplication;
import com.cstudioo.mvpwithdagger2.R;
import com.cstudioo.mvpwithdagger2.home.HomeActivity;
import com.cstudioo.mvpwithdagger2.login.component.DaggerLoginComponent;
import com.cstudioo.mvpwithdagger2.login.module.LoginModule;
import com.cstudioo.mvpwithdagger2.util.Constant;
import com.cstudioo.mvpwithdagger2.util.Utils;
import com.cstudioo.mvpwithdagger2.webservice.model.response.ResponseLogin;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{

    private EditText etEmail;
    private EditText etPassword;

    private Button btnLogin;

    private ProgressDialog mProgressDialog;

    @Inject
    LoginPresenterImpl mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DaggerLoginComponent.builder()
                .appComponent(((MyApplication) getApplicationContext())
                .getAppComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        etEmail = (EditText) findViewById(R.id.activity_login_et_email);
        etPassword = (EditText) findViewById(R.id.activity_login_et_password);
        btnLogin = (Button) findViewById(R.id.activity_login_btn_login);

        mProgressDialog = new ProgressDialog(LoginActivity.this);

        btnLogin.setOnClickListener(this);

//        mLoginPresenter.login("robber@cstudioo.com", "cstudioo@123456");

    }

    @Override
    public void showLoading() {
        mProgressDialog.setTitle(null);
        mProgressDialog.setMessage(getResources().getString(R.string.activity_login_loading_msg));
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    @Override
    public void setEmailError(int errRes) {
        if (etEmail != null) {
            etEmail.setError(getResources().getString(errRes));
        }
    }

    @Override
    public void setPasswordError(int errRes) {
        if (etPassword != null) {
            etPassword.setError(getResources().getString(errRes));
        }
    }

    @Override
    public void loginSuccess(ResponseLogin responseLogin) {
        Log.e("loginSuccess", "Email : " + responseLogin.getEmail());
        Log.e("loginSuccess", "User name : " + responseLogin.getNickname());
        Log.e("loginSuccess", "User ID : " + responseLogin.getId());

        Intent openHomeScreen = new Intent(LoginActivity.this, HomeActivity.class);
        openHomeScreen.putExtra(Constant.PASS_TO_HOME_USER, responseLogin.getNickname());
        openHomeScreen.putExtra(Constant.PASS_TO_HOME_ID, responseLogin.getId());
        openHomeScreen.putExtra(Constant.PASS_TO_HOME_EMAIL, responseLogin.getEmail());
        startActivity(openHomeScreen);
        finish();
    }

    @Override
    public void loginFailure(int errMsg) {
        Toast.makeText(this, getResources().getString(errMsg), Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure(String errMsg) {
        Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btn_login:

                if (etEmail != null && etPassword != null) {

                    if (Utils.isNetworkAvailable(LoginActivity.this)) {
                        mLoginPresenter.login(etEmail.getText().toString(),
                                etPassword.getText().toString());
                    } else {
                        Utils.displayCommonAlertDialog(LoginActivity.this, LoginActivity.this.getResources().getString(R.string.connection_issue_msg));
                    }
                }
                break;
        }
    }
}
