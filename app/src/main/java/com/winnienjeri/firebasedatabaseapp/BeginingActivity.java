package com.winnienjeri.firebasedatabaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginingActivity extends AppCompatActivity {
    Button book,feedback,login,services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begining);
        book =findViewById(R.id.Btnbook);
        feedback =findViewById(R.id.btnfeedback);
        login = findViewById(R.id.Btnadmin);
        services=findViewById(R.id.btnservices);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,FeedbackActivity.class);
                startActivity(intent);
                finish();

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,AdminActivity.class);
                startActivity(intent);
                finish();

            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeginingActivity.this,MaintabActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
