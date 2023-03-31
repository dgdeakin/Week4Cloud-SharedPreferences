package com.application.week4cloud_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.application.week4cloud_sharedpreferences.databinding.ActivityLoginBinding;
import com.application.week4cloud_sharedpreferences.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {


    SharedPreferences sp1, sp2;
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);

        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sp1 = getSharedPreferences("MY_PREF", MODE_PRIVATE);
        sp2 = getSharedPreferences("MY_PREF_LOGIN", MODE_PRIVATE);

        String userName = sp2.getString("username", "");
        int score = sp1.getInt("count", 0);


        binding.welcomeTextView.setText("Welcome "+ userName + "\n Your Score is: "+String.valueOf(score));

    }
}