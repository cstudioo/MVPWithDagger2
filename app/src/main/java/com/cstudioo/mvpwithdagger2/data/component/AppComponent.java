package com.cstudioo.mvpwithdagger2.data.component;

import android.app.Application;

import com.cstudioo.mvpwithdagger2.data.module.AppModule;
import com.cstudioo.mvpwithdagger2.data.module.ServiceWrapperModule;
import com.cstudioo.mvpwithdagger2.webservice.ServiceWrapper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ServiceWrapperModule.class})
public interface AppComponent {
    Application application();
    ServiceWrapper serviceWrapper();
}