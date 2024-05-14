package com.nhathuy.daggerexmaple.module;

import com.nhathuy.daggerexmaple.ui.LoginActivity;
import com.nhathuy.daggerexmaple.ui.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract LoginActivity contributeLoginActivityInjector();

    @ContributesAndroidInjector
    abstract RegisterActivity contributeRegisterActivityInjector();
}
