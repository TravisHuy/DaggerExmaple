package com.nhathuy.daggerexmaple.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.model.User;

@Database(entities = {User.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
