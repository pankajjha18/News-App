package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class splashActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        auth=FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (user!=null)
                {
                    intent =new Intent(splashActivity.this,MainActivity.class);
                }
                else
                {
                    intent =new Intent(splashActivity.this, Signup.class);
                }
                startActivity(intent);
                finish();

            }
        }, 3000);
    }
}