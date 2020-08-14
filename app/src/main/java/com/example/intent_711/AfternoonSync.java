package com.example.intent_711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;

import java.util.TimeZone;

public class AfternoonSync extends AppCompatActivity {

    private TextClock mTextClock;
    private Button mBtnAfter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afternoon_sync);
        mTextClock = findViewById(R.id.text_clockAf);
        TimeZone tz = TimeZone.getDefault();
        mTextClock.setTimeZone(tz.getID());
        //Toast.makeText(EveningSync.this,tz.getID(), Toast.LENGTH_LONG).show();
        mTextClock.setFormat24Hour("HH:mm:ss");

        mBtnAfter=findViewById(R.id.btnAfter);
        mBtnAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://afternoon/"));
                startActivity(browserIntent);
            }
        });
    }
}