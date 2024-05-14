package com.nhathuy.daggerexmaple.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nhathuy.daggerexmaple.model.User;
import com.nhathuy.daggerexmaple.respository.UserRepository;

import javax.inject.Inject;

public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;

    @Inject
    public UserViewModel(UserRepository repository){
        this.userRepository=repository;
    }

    public LiveData<User> login(String email,String password){
        MutableLiveData<User> userLiveData = new MutableLiveData<>();
        User user = userRepository.login(email, password);
        userLiveData.setValue(user);
        return userLiveData;
    }
    public void register(User user){
        userRepository.register(user);
    }
}
