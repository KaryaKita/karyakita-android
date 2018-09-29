package com.karyakita.karyakita_android_new.activity.customer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.karyakita.karyakita_android_new.R;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class PesanCustomActivity extends AppCompatActivity {

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan_custom_activity);

        String[] options = Calendar.
        spinner = (Spinner) findViewById(R.id.Calendar);
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < options.length; i++){
            list.add(options[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,list);

        spinner.setAdapter(adapter);
    }
}
