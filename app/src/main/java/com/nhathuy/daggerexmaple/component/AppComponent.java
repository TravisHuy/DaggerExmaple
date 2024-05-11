package com.nhathuy.daggerexmaple.component;

import com.nhathuy.daggerexmaple.BaseApplicationApp;
import com.nhathuy.daggerexmaple.module.AppModule;
import com.nhathuy.daggerexmaple.module.RoomModule;
import com.nhathuy.daggerexmaple.viewmodel.ViewModelFactory;
import com.nhathuy.daggerexmaple.viewmodel.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RoomModule.class, ViewModelModule.class})
public interface AppComponent {
    void inject(BaseApplicationApp applicationApp);
    ViewModelFactory viewModelFactory();
}