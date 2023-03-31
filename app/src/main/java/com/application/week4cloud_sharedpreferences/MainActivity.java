package com.application.week4cloud_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.application.week4cloud_sharedpreferences.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int mCount = 0;
    int mColor;
    TextView countTextView;
    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);

        int colorFromShared = sharedPreferences.getInt("color", 0);
        int countFromShared = sharedPreferences.getInt("count", 0);

//        Log.v("Values 1 Color", String.valueOf(colorFromShared));

        Log.v("Values", String.valueOf(mCount));

        if(countFromShared > 0){
            binding.textView.setText(String.valueOf(countFromShared));
            binding.constraintLayout.setBackgroundColor(colorFromShared);
        }


        binding.changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                mColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
                binding.constraintLayout.setBackgroundColor(mColor);
            }
        });


        binding.increaseCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount += 1;
//                Log.v("Check COUNT", String.valueOf(count));
                binding.textView.setText(String.valueOf(mCount));

                if(mCount == 2){

                    Log.v("PAUSED", "PAUSED");
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("color", mColor);
                    editor.putInt("count", mCount);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);



                }
            }
        });


        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textView.setText("0");
                binding.constraintLayout.setBackgroundColor(Color.WHITE);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                editor.apply();


            }
        });



    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}