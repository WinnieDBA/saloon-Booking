package com.winnienjeri.firebasedatabaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {
    private  EditText name;
    private EditText password;
    private TextView info;
    private  Button log;
    private  int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        name  = (EditText) findViewById(R.id.edtjina);
        password = (EditText)findViewById(R.id.edtsecurity);
        info =(TextView) findViewById(R.id.tvremaining);
        log = (Button) findViewById(R.id.btnlog);

        info.setText("No of attempts remaining: 5");


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });



    }
    private void validate(String userName,String userPassword){
        if (userName.equals("Admin") && userPassword.equals("1234")){
    Intent intent = new Intent(AdminActivity.this,UsersActivity.class);
    startActivity(intent);
        }else {
            counter--;

            info.setText("No of attempts remaining" + String.valueOf(counter));


            if (counter == 0){
                log.setEnabled(false);
            }
        }
    }
}
