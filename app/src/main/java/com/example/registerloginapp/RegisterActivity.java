package com.example.registerloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Button register, cancel;
        EditText user, pass, date, country, number, email_add;
        RadioButton male, female, other;
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        date = findViewById(R.id.date);
        country = findViewById(R.id.country);
        number = findViewById(R.id.number);
        email_add = findViewById(R.id.emailadd);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        other = findViewById(R.id.Other);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData("user", user.getText().toString());
                saveData("pass", pass.getText().toString());
                saveData("date", date.getText().toString());
                saveData("country", country.getText().toString());
                saveData("number", number.getText().toString());
                saveData("email_add", email_add.getText().toString());
                    // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();
                    // Check which radio button was clicked
                    switch(view.getId()) {
                        case R.id.Male:
                            if (checked)
                                saveData("gender", male.toString());
                                break;
                        case R.id.Female:
                            if (checked)
                                saveData("gender", female.toString());
                                break;
                        case R.id.Other:
                            if (checked)
                                saveData("gender", other.toString());
                                break;
                    }
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveData(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}