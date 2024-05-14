package com.nhathuy.daggerexmaple.module;

import android.app.Application;

import androidx.room.Room;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.database.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    UserDatabase provideUserDatabase(Application application){
        return Room.databaseBuilder(application,UserDatabase.class,"user_database").build();
    }
    @Provides
    @Singleton
    UserDao provideUserDao(UserDatabase userDatabase){
        return userDatabase.userDao();
    }
}
