package com.nhathuy.daggerexmaple.module;

import android.content.Context;

import androidx.room.Room;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.database.UserDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    private Context context;
    public DatabaseModule(Context context){
        this.context=context;
    }
    @Singleton
    @Provides
    public UserDatabase provideUserDatabase(Context context){
        return Room.databaseBuilder(context,UserDatabase.class,"app-database").build();
    }
    @Provides
    public UserDao provideUserDao(UserDatabase database){
        return database.userDao();
    }
}
