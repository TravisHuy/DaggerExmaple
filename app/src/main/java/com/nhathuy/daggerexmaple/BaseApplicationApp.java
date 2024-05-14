package com.nhathuy.daggerexmaple;

import android.app.Application;

import com.nhathuy.daggerexmaple.component.AppComponent;
import com.nhathuy.daggerexmaple.component.DaggerAppComponent;
//import com.nhathuy.daggerexmaple.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
//import com.nhathuy.daggerexmaple.component.DaggerAppComponent;


public class BaseApplicationApp extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

}
