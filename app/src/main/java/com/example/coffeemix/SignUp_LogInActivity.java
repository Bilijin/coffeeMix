package com.example.coffeemix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp_LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__log_in);

        Button first = findViewById(R.id.choose_signup);
        Button second = findViewById(R.id.choose_login);
    }

    public void openSignUp(View view) {
        Intent openSignup = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(openSignup);
    }

    public void openLogin(View vIew) {
        Intent openLogin = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(openLogin);
    }
}