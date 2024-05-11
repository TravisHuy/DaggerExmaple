package com.nhathuy.daggerexmaple.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);
}
