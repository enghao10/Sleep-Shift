package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MediaPlayer sleepsong;
    TextView textView;
    TextView time;
    Button day1;
    Button day2;
    Button day3;
    Button day4;
    Button sleep;
    Button pause;
    Button earth;
    int dayInSpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        time = findViewById(R.id.time);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);
        sleep = findViewById(R.id.sleep);
        pause = findViewById(R.id.pause);
        earth = findViewById(R.id.earth);
        sleepsong= MediaPlayer.create(MainActivity.this,R.raw.song);
        dayInSpace = 7;

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Find the current date
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                String dateTime = simpleDateFormat.format(calendar.getTime());
                                textView.setText(dateTime);

                                //Find the current time
                                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss a");
                                String currentTime = simpleDateFormat1.format(calendar.getTime());
                                time.setText(currentTime);

                                //Find duration of current date and first day
                                TextView test=findViewById(R.id.diff);
                                Date date1,date2;
                                String dateStr1 = "29/09/2020";
                                String dateStr2 = dateTime;
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                try{
                                    date1 = sdf.parse(dateStr1);
                                    date2 = sdf.parse(dateStr2);
                                    long diff = date2.getTime() - date1.getTime();
                                    long totalDay = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                                    test.setText ("Days: " + totalDay);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                        NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                                        NotificationManager manager = getSystemService(NotificationManager.class);
                                        manager.createNotificationChannel(channel);
                                    }

                                    //Exercise Time
                                    if(totalDay==0 || totalDay==1 || (totalDay>4+dayInSpace && totalDay<=10+dayInSpace)){
                                        if (currentTime.equals("05:00:00 PM")) {
                                            NotificationExercise();
                                        }
                                    }

                                    if(totalDay==2){
                                        if (currentTime.equals("08:00:00 PM")) {
                                            NotificationExercise();
                                        }
                                    }

                                    if(totalDay==3){
                                        if (currentTime.equals("10:00:00 PM")) {
                                            NotificationExercise();
                                        }
                                    }

                                    if(totalDay>=5 && totalDay<=4+dayInSpace){
                                        if (currentTime.equals("03:00:00 AM")) {
                                            NotificationExercise();
                                        }
                                    }

                                    //Eating time (After half hour wake up-breakfast, After five hours wake up-lunch, Before four hours sleep-dinner)
                                    if(totalDay==0 || totalDay==1){
                                        if (currentTime.equals("07:30:00 AM") || currentTime.equals("12:00:00 PM") || currentTime.equals("07:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    if(totalDay==2){
                                        if (currentTime.equals("08:30:00 AM") || currentTime.equals("01:00:00 PM") || currentTime.equals("10:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    if(totalDay==3){
                                        if (currentTime.equals("10:30:00 AM") || currentTime.equals("03:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    if(totalDay==4){
                                        if (currentTime.equals("12:00:00 AM") || currentTime.equals("12:30:00 PM") || currentTime.equals("05:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    if(totalDay>=5 && totalDay<=4+dayInSpace){
                                        if (currentTime.equals("05:00:00 AM") || currentTime.equals("03:30:00 PM") || currentTime.equals("08:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    if(totalDay>4+dayInSpace && totalDay<=10+dayInSpace){
                                        if (currentTime.equals("08:30:00 AM") || currentTime.equals("01:00:00 PM") || currentTime.equals("7:00:00 PM")) {
                                            NotificationMeal();
                                        }
                                    }

                                    //Take Melatonin time
                                    if(totalDay>=5 && totalDay<5+dayInSpace){
                                        if (currentTime.equals("09:00:00 AM")) {
                                            NotificationTakeMelatonin();
                                        }
                                    }

                                    if(totalDay>=4+dayInSpace && totalDay<=6+dayInSpace){
                                        if (currentTime.equals("11:00:00 PM")) {
                                            NotificationTakeMelatonin();
                                        }
                                    }

                                    //Nap time
                                    if(totalDay>=4 && totalDay<4+dayInSpace){
                                        if (currentTime.equals("06:00:00 PM")) {
                                            NotificationNap();
                                        }
                                    }

                                    if(totalDay>=4 && totalDay<4+dayInSpace){
                                        if (currentTime.equals("08:00:00 PM")) {
                                            NotificationNap();
                                        }
                                    }

                                    //Sleep Time
                                    if(totalDay==0){
                                        if (currentTime.equals("12:00:00 AM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    if(totalDay==0 || totalDay==1){
                                        if (currentTime.equals("11:00:00 PM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    if(totalDay==3){
                                        if (currentTime.equals("02:00:00 AM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    if(totalDay==4){
                                        if (currentTime.equals("04:00:00 AM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    if(totalDay>=5 && totalDay<5+dayInSpace){
                                        if (currentTime.equals("09:00:00 AM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    if(totalDay>=4+dayInSpace && totalDay<=10+dayInSpace){
                                        if (currentTime.equals("11:00:00 PM")) {
                                            NotificationSleep();
                                        }
                                    }

                                    //Wake Up Time
                                    if(totalDay==0 || totalDay==1){
                                        if (currentTime.equals("07:00:00 AM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                    if(totalDay==2){
                                        if (currentTime.equals("08:00:00 AM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                    if(totalDay==3){
                                        if (currentTime.equals("10:00:00 AM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                    if(totalDay==4){
                                        if (currentTime.equals("12:00:00 PM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                    if(totalDay>=5 && totalDay<5+dayInSpace){
                                        if (currentTime.equals("03:00:00 PM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                    if(totalDay>=5+dayInSpace && totalDay<=10+dayInSpace){
                                        if (currentTime.equals("08:00:00 AM")) {
                                            NotificationWakeUp();
                                        }
                                    }

                                }catch(ParseException e){
                                    Log.d("error","error");
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

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sleepsong == null) {
                    sleepsong = MediaPlayer.create(MainActivity.this, R.raw.song);
                    sleepsong.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                        @Override
                        public void onCompletion(MediaPlayer mp){
                            sleepsong.stop();
                        }
                    });
                }

                sleepsong.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sleepsong!=null){
                    sleepsong.release();
                    sleepsong = null;
                    //alarm message
                }
            }
        });

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
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EarthTime.class));
            }
        });
    }

    public void NotificationMeal(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to have a meal!");
        builder.setContentText("Have a nice day :)");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());
    }

    public void NotificationSleep(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to sleep!");
        builder.setContentText("Good Night!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());
    }

    public void NotificationWakeUp(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to wake up!");
        builder.setContentText("Good Morning!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());
    }

    public void NotificationExercise(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to exercise!");
        builder.setContentText("Hang in there!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());
    }

    public void NotificationTakeMelatonin(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to take melatonin!");
        builder.setContentText("Good Night!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(2, builder.build());
    }

    public void NotificationNap(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Time to take a nap!");
        builder.setContentText("Take a rest!");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(3, builder.build());
    }
}