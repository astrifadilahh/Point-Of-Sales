package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterCafe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cafe);
    }

    public void signin(View view) {
        Intent intent = new Intent(RegisterCafe.this, LoginCafe.class);
        startActivity(intent);
    }
}
