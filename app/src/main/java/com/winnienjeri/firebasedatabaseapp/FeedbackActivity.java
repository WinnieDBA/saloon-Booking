package com.winnienjeri.firebasedatabaseapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    Button calling,messanging,mailing,social,mpesa,home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setContentView(R.layout.activity_feedback);
        home =findViewById(R.id.btnhome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeedbackActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        });

        calling= findViewById(R.id.btncall);
        messanging  =findViewById(R.id.btnsms);
        mailing = findViewById(R.id.btnemail);

        social = findViewById(R.id.btnsocial);

        mpesa = findViewById(R.id.btnmpesa);


        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent piga = new Intent(Intent.ACTION_CALL);
                piga.setData(Uri.parse("tel:0712345679"));

                startActivity(piga);
            }
        });
        messanging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri tumaSms = Uri.parse("tel:0712345678");
                Intent sms = new Intent(Intent.ACTION_VIEW,tumaSms);
                sms.putExtra("sms_body","I would like");
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });
        mailing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendmail =new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","tangerinesalon@gmail.com",null));
                sendmail.putExtra(Intent.EXTRA_SUBJECT,"");
                sendmail.putExtra(Intent.EXTRA_TEXT,"");
                startActivity(Intent.createChooser(sendmail,"You are sending an email"));
            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent();
                share.setAction(Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Download app on www.tangerine.com");
                share.setType("text/plain");
                startActivity(share);
            }
        });

        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pesa = getApplication().getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if (pesa != null){
                    startActivity(pesa);
                }else {
                    Toast.makeText(FeedbackActivity.this, "No STK Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
