package com.nhathuy.daggerexmaple.module;

import com.nhathuy.daggerexmaple.ui.LoginActivity;
import com.nhathuy.daggerexmaple.ui.RegisterActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DatabaseModule.class})
public interface AppComponent {
    void inject(LoginActivity loginActivity);
    void inject(RegisterActivity registerActivity);
}
