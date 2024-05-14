package com.nhathuy.daggerexmaple.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhathuy.daggerexmaple.BaseApplicationApp;
import com.nhathuy.daggerexmaple.databinding.ActivityRegisterBinding;
import com.nhathuy.daggerexmaple.model.User;
import com.nhathuy.daggerexmaple.viewmodel.UserViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private UserViewModel userViewModel;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AndroidInjection.inject(this);
        userViewModel = new ViewModelProvider(this, viewModelFactory).get(UserViewModel.class);

        binding.login.setOnClickListener(v-> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));


        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=binding.registerName.getText().toString().trim();
                String email=binding.registerEmail.getText().toString().trim();
                String password=binding.registerPass.getText().toString().trim();

                if(password.length()<6||password.isEmpty()){
                    binding.registerName.setError("Password must be greater than 5 character");
                }
                if (username.length()<6||password.isEmpty()){
                    binding.registerName.setError("User name must be greater than 5 character");
                }
                if(email.isEmpty()){
                    binding.registerEmail.setError("Email not empty");
                }
                User user= new User();
                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(password);
                userViewModel.register(user);
            }
        });
    }
}