package com.cstudioo.mvpwithdagger2;

import android.app.Application;
import android.content.Context;

import com.cstudioo.mvpwithdagger2.data.component.AppComponent;
import com.cstudioo.mvpwithdagger2.data.component.DaggerAppComponent;
import com.cstudioo.mvpwithdagger2.data.module.AppModule;
import com.cstudioo.mvpwithdagger2.data.module.ServiceWrapperModule;


/**
 * Created by cstudioo on 11/02/17.
 */

public class MyApplication extends Application{

    private AppComponent appComponent;

    private static MyApplication instance;

    @Override

    public void onCreate() {
        super.onCreate();
//        MultiDex.install(this);
        instance = this;
        initAppComponents();
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initAppComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule((Application)instance))
                .serviceWrapperModule(new ServiceWrapperModule())
                .build();
    }

}
