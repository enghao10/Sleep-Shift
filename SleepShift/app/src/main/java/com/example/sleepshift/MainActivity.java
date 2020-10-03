package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button day1;
    Button day2;
    Button day3;
    Button day4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE , hh:mm:ss a");
                                String dateTime = simpleDateFormat.format(calendar.getTime());
                                textView.setText(dateTime);

                                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss a");
                                String currentTime = simpleDateFormat1.format(calendar.getTime());

                                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                                    NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                                    NotificationManager manager = getSystemService(NotificationManager.class);
                                    manager.createNotificationChannel(channel);
                                }

                                if(currentTime.equals("08:00:00 AM") || currentTime.equals("01:00:00 PM") || currentTime.equals("07:00:00 PM")) {
                                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
                                    builder.setContentTitle("Time to have a meal!");
                                    builder.setContentText("Have a nice day :)");
                                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                                    builder.setAutoCancel(true);

                                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                                    managerCompat.notify(1, builder.build());
                                }
                            }
                        });
                    }
                }
                catch(Exception e){
                    textView.setText(R.string.app_name);
                }
            }
        };
        thread.start();

        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MealDay1.class));
            }
        });
        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MealDay2.class));
            }
        });
        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MealDay3.class));
            }
        });
        day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MealDay4.class));
            }
        });
    }
}