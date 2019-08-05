package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginCafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cafe);
    }

    public void signup(View view) {
        Intent intent = new Intent(LoginCafe.this, RegisterCafe.class);
        startActivity(intent);
    }
}
