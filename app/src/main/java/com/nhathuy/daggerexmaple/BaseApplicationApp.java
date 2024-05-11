package com.nhathuy.daggerexmaple;

import android.app.Application;

import com.nhathuy.daggerexmaple.component.AppComponent;
import com.nhathuy.daggerexmaple.component.DaggerAppComponent;
import com.nhathuy.daggerexmaple.module.AppModule;
import com.nhathuy.daggerexmaple.module.RoomModule;
import com.nhathuy.daggerexmaple.viewmodel.ViewModelModule;

public class BaseApplicationApp extends Application{
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
//
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))

                .build();

    }
    //cung cấp appcompent để truy cập từ activity và fragment

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
