package com.example.pos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class Splashscreen extends AppCompatActivity {
    private int time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(Splashscreen.this, Register2Cafe.class);
                startActivity(home);
                finish();
            }
        }, time);
    }

    public void next(View view) {
        Intent intent = new Intent(Splashscreen.this, Register2Cafe.class);
        startActivity(intent);
    }
}
