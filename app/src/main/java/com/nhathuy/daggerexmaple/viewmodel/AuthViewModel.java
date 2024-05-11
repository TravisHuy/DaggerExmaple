package com.nhathuy.daggerexmaple.viewmodel;

import androidx.lifecycle.ViewModel;

import com.nhathuy.daggerexmaple.dao.UserDao;
import com.nhathuy.daggerexmaple.model.User;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {
    private UserDao userDao;

    @Inject
    public AuthViewModel(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String email,String password){
        return userDao.login(email,password);
    }
    public void register(User user){
        userDao.register(user);
    }
}
