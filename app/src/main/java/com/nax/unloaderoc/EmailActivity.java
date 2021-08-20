package com.nax.unloaderoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {

    private EditText email;
    private Button next, skip;
    private boolean emailFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        email = findViewById(R.id.email);
        next = findViewById(R.id.next_btn);
        skip = findViewById(R.id.skip_btn);

        SharedPreferences sp = getSharedPreferences("myFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = email.getText().toString().trim();
                if (!addr.equals("")) {
                    emailFlag = true;
                    editor.putBoolean("emailFlag", emailFlag);
                    editor.putString("emailID", addr);
                    editor.commit();
                    Intent intent = new Intent(EmailActivity.this, InputActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Either provide an email ID or press the skip button", Toast.LENGTH_SHORT).show();
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailFlag = false;
                editor.putBoolean("emailFlag", emailFlag);
                editor.commit();
                Intent intent = new Intent(EmailActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
    }
}