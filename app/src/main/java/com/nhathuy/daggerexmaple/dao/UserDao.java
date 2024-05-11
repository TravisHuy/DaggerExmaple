package com.nhathuy.daggerexmaple.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.nhathuy.daggerexmaple.model.User;

@Dao
public interface UserDao {
    @Query("select * from users where email= :email and password= :password")
    User login(String email,String password);
    @Insert
    void register(User user);
}
