package com.nhathuy.daggerexmaple.module;

import android.app.Application;

import androidx.room.Room;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.database.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private final UserDatabase database;

    public RoomModule(Application application){
        this.database= Room.databaseBuilder(application,UserDatabase.class,"user-database").build();
    }

    @Provides
    @Singleton
    public UserDatabase provideUserDatabase(){
        return database;
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(){
        return database.userDao();
    }
}
