package com.nhathuy.daggerexmaple.component;

import android.app.Application;

import com.nhathuy.daggerexmaple.BaseApplicationApp;
import com.nhathuy.daggerexmaple.module.ActivityModule;
import com.nhathuy.daggerexmaple.module.AppModule;
import com.nhathuy.daggerexmaple.ui.LoginActivity;
import com.nhathuy.daggerexmaple.ui.RegisterActivity;
import com.nhathuy.daggerexmaple.viewmodel.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = { AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,AppModule.class, ViewModelModule.class, ActivityModule.class})
public interface AppComponent extends AndroidInjector<BaseApplicationApp> {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
}