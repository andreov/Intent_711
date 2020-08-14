package com.example.intent_711;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button mBtnSync;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnSync=findViewById(R.id.btnSync);
        mBtnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                Calendar cal = Calendar.getInstance();

                //int millisecond = cal.get(Calendar.MILLISECOND);
                int second = cal.get(Calendar.SECOND);
                int minute = cal.get(Calendar.MINUTE);
                //12 hour format
                //int hour = cal.get(Calendar.HOUR);
                //24 hour format
                int hourofday = cal.get(Calendar.HOUR_OF_DAY);
                //Toast.makeText(MainActivity.this, hourofday+":"+minute+":"+second, Toast.LENGTH_LONG).show();

                if (hourofday>=6 && hourofday<14)
                    intent.setData(Uri.parse("http://morning"));
                if (hourofday>=14 && hourofday<15)
                    intent.setData(Uri.parse("http://afternoon"));
                if (hourofday>=15 && hourofday<24)
                    intent.setData(Uri.parse("http://evening"));
                if (hourofday>=0 && hourofday<6)
                    intent.setData(Uri.parse("http://evening"));
                // следующее условие

                startActivity(intent);
            }
        });
    }
}