package com.nhathuy.daggerexmaple.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nhathuy.daggerexmaple.BaseApplicationApp;
import com.nhathuy.daggerexmaple.R;
import com.nhathuy.daggerexmaple.databinding.ActivityLoginBinding;
import com.nhathuy.daggerexmaple.model.User;
import com.nhathuy.daggerexmaple.viewmodel.AuthViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Inject
    AuthViewModel authViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((BaseApplicationApp) getApplication()).getAppComponent().inject(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=binding.loginEmail.getText().toString();
                String password=binding.loginPass.getText().toString();
                User user=authViewModel.login(email,password);
                if (user!=null){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.register.setOnClickListener(v-> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));
    }
}