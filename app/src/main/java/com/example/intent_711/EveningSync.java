package com.example.intent_711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.Toast;

import java.util.TimeZone;

public class EveningSync extends AppCompatActivity {
    private TextClock mTextClock;
    private Button mBtnEvening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening_sync);
        mTextClock = findViewById(R.id.text_clock);
        TimeZone tz = TimeZone.getDefault();
        mTextClock.setTimeZone(tz.getID());
        //Toast.makeText(EveningSync.this,tz.getID(), Toast.LENGTH_LONG).show();
        mTextClock.setFormat24Hour("HH:mm:ss");

        mBtnEvening=findViewById(R.id.btnEvening);
        mBtnEvening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://evening/"));
                startActivity(browserIntent);
            }
        });
    }
}