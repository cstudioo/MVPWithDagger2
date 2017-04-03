package com.cstudioo.mvpwithdagger2.data.module;

import com.cstudioo.mvpwithdagger2.webservice.ServiceWrapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceWrapperModule {

    public ServiceWrapperModule(){ }
    @Singleton
    @Provides
    ServiceWrapper provideServiceWrapper() {
        return new ServiceWrapper(null);
    }

}