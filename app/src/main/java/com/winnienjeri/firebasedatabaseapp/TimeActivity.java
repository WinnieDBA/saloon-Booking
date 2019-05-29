package com.winnienjeri.firebasedatabaseapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class TimeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    Button btn_pick;
    TextView Result_tv;
    int day,month,year,hour,minute;
    int day_x,month_x,year_x,hour_x,minute_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);




        btn_pick = findViewById(R.id.btn_click);
        Result_tv = findViewById(R.id.tv_result);
        btn_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year =c.get(Calendar.YEAR);
                month =c.get(Calendar.MONTH);
                day =c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog  = new DatePickerDialog(TimeActivity.this,TimeActivity.this,year,month,day);
                datePickerDialog.show();



            }
        });







    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year_x =i;
        month_x = i1+1;
        day_x =i2;
        Calendar c =Calendar.getInstance();
        hour =c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(TimeActivity.this,TimeActivity.this,
                 hour,minute,true);
        timePickerDialog.show();


    }

    @Override
    public void onTimeSet(TimePicker view, int i, int i1) {
        hour_x=i;
        minute_x=i1;
        Result_tv.setText("year::"+year_x+"\n"+
                "month::"+month_x+"\n"+
                "day::"+day_x+"\n"+
                "hour::"+hour_x+"\n"+
                "minute::"+minute_x);


    }
}
