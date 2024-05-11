package com.nhathuy.daggerexmaple;

import android.app.Application;

import com.nhathuy.daggerexmaple.module.AppComponent;
import com.nhathuy.daggerexmaple.module.DatabaseModule;

public class BaseApplicationApp extends Application{
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .databaseModule(new DatabaseModule(this))
                .build();

    }
    //cung cấp appcompent để truy cập từ activity và fragment

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
