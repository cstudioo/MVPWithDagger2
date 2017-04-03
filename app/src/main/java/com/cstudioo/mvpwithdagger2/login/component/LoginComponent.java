package com.cstudioo.mvpwithdagger2.login.component;

import com.cstudioo.mvpwithdagger2.data.component.AppComponent;
import com.cstudioo.mvpwithdagger2.login.LoginActivity;
import com.cstudioo.mvpwithdagger2.login.module.LoginModule;
import com.cstudioo.mvpwithdagger2.util.ActivityScope;

import dagger.Component;

/**
 * Created by cstudioo on 10/02/17.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
}
