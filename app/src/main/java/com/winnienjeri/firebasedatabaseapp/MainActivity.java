package com.winnienjeri.firebasedatabaseapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    EditText name,email,number;
    Button save,view;
    ProgressDialog dialog;
    Calendar myCalendar;
    EditText edittext;
    String siku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCalendar  = Calendar.getInstance();
        edittext =  (EditText) findViewById(R.id.Birthday);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String uDate = preferences.getString("tarehe","Noma");
                Toast.makeText(MainActivity.this, uDate, Toast.LENGTH_SHORT).show();


            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        name = findViewById(R.id.editname);
        email =findViewById(R.id.edtemail);
        number= findViewById(R.id.edtphone);
        save = findViewById(R.id.btnsave);
        view= findViewById(R.id.btnview);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Saving");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jina = name.getText().toString();
                String arafa = email.getText().toString();
                String simu = number.getText().toString();
                if (jina.isEmpty()||arafa.isEmpty()||simu.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fill All Inputs", Toast.LENGTH_SHORT).show();
                }
                else {
                    long time = System.currentTimeMillis();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Watu/"+time);
                    Item x = new Item(jina,arafa,simu,String.valueOf(time));
                    dialog.show();
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                                name.setText("");
                                email.setText("");
                                number.setText("");
                            }else {
                                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
                            }



                        }
                    });
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);


            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
        siku = edittext.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("tarehe",siku);
        editor.commit();


    }
}












