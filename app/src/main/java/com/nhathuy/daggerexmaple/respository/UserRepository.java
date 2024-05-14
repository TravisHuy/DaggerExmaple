package com.nhathuy.daggerexmaple.respository;

import androidx.lifecycle.LiveData;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.model.User;

import javax.inject.Inject;

public class UserRepository {
    private UserDao userDao;

    @Inject
    public UserRepository(UserDao userDao){
        this.userDao=userDao;
    }

    public User login(String email,String password){
        return userDao.login(email,password).getValue();
    }
    public void register(User user){
        userDao.register(user);
    }
}
