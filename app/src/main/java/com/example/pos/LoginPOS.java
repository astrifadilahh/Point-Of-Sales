package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginPOS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pos);
    }

    public void signup(View view) {
        Intent intent = new Intent(LoginPOS.this, RegisterPOS.class);
        startActivity(intent);
    }
}
