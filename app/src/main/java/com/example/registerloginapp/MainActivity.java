package com.example.registerloginapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView invalid, debug;
        EditText loginUser, loginPass;
        Button register, login;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        invalid = findViewById(R.id.invalid);
        loginUser = findViewById(R.id.username);
        loginPass = findViewById(R.id.password);
        //Register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
        //Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sUser = loginUser.getText().toString();
                String sPass = loginPass.getText().toString();
                String user = loadData("user");
                String pass = loadData("pass");
                if (user.equals(sUser) && pass.equals(sPass)) {
                    Intent success = new Intent(MainActivity.this, SuccessActivity.class);
                    startActivity(success);
                } else {
                    invalid.setText("Invalid username or password!");
                }
            }
        });
    }

    private String loadData(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}