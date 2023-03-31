package com.application.week4cloud_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.application.week4cloud_sharedpreferences.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {



    ActivityLoginBinding binding;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        sharedPreferences = getSharedPreferences("MY_PREF_LOGIN", MODE_PRIVATE);

        String userNameFromShared = sharedPreferences.getString("username", "");
        String passWordFromShared = sharedPreferences.getString("password", "");


        if(!userNameFromShared.isEmpty()){
            binding.editTextTextPersonName.setText(userNameFromShared);
            binding.editTextTextPassword.setText(passWordFromShared);
        }


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(binding.checkBox.isChecked()){

                    String userName = binding.editTextTextPersonName.getText().toString();
                    String passWord = binding.editTextTextPassword.getText().toString();

                    editor.putString("username", userName);
                    editor.putString("password", passWord);


                    editor.apply();

                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);



                }
            }
        });
    }
}