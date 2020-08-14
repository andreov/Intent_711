package com.example.intent_711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MornigSync extends AppCompatActivity {
    private TextView mtextTimeMorning;
    private Button mBtnMorning;
    private TextClock mTextClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mornig_sync);
        //mtextTimeMorning=findViewById(R.id.textTimeMorning);
        mBtnMorning = findViewById(R.id.btnMorning);
        mTextClock = findViewById(R.id.text_clock);
        TimeZone tz = TimeZone.getDefault();
        mTextClock.setTimeZone(tz.getID());
        //Toast.makeText(EveningSync.this,tz.getID(), Toast.LENGTH_LONG).show();
        mTextClock.setFormat24Hour("HH:mm:ss");

        mBtnMorning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://morning/"));
                startActivity(browserIntent);
            }
        });
    }
}