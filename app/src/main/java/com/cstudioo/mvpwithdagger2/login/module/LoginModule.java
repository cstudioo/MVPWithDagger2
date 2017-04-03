package com.cstudioo.mvpwithdagger2.login.module;


import com.cstudioo.mvpwithdagger2.login.ILoginInteractor;
import com.cstudioo.mvpwithdagger2.login.ILoginView;
import com.cstudioo.mvpwithdagger2.login.LoginInteractorImpl;
import com.cstudioo.mvpwithdagger2.util.ActivityScope;
import com.cstudioo.mvpwithdagger2.webservice.ServiceWrapper;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cstudioo on 10/02/17.
 */


@Module
public class LoginModule {

    private ILoginView mILoginView;

    public LoginModule(ILoginView view) {
        mILoginView = view;
    }

    @ActivityScope
    @Provides
    public ILoginView provideILoginView() {
        return mILoginView;
    }

    @ActivityScope
    @Provides
    public ILoginInteractor provideILoginInteractor() {
        return new LoginInteractorImpl(new ServiceWrapper(null));
    }

}
