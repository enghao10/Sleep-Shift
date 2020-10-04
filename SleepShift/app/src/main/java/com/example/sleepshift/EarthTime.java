package com.example.sleepshift;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.ParseException;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class EarthTime extends AppCompatActivity {

    //to make our alarm manager
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;
    int choose_whale_sound;
    ImageButton soundOn;
    ImageButton soundOff;
    MediaPlayer advideSong;
    TextView textView;
    TextView time;
    int age;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_time);

        this.context = this;
        textView = findViewById(R.id.textView1);
        time = findViewById(R.id.time);

        MediaPlayer adviseSong = MediaPlayer.create(EarthTime.this, R.raw.advise);

        // initialize our alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialize our text update box
        update_text = (TextView) findViewById(R.id.update_text);

        ImageButton soundOff = (ImageButton)findViewById(R.id.soundOff);
        ImageButton soundOn = (ImageButton)findViewById(R.id.soundOn);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(getFilesDir() + File.separator + "MyFile.txt")));
                                    dataStored data = new dataStored();
                                    data.setDate(bufferedReader.readLine());
                                    data.setTime(bufferedReader.readLine());
                                    data.setAge(65);
                                    age = data.getAge();
                                    bufferedReader.close();
                                }
                                catch (IOException e) {
                                    Log.d("IOException", e.getMessage());
                                }

                                //Find the current date
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                String dateTime = simpleDateFormat.format(calendar.getTime());
                                textView.setText(dateTime);

                                //Find the current time
                                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss a");
                                String currentTime = simpleDateFormat1.format(calendar.getTime());
                                time.setText(currentTime);

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
                                    NotificationManager manager = getSystemService(NotificationManager.class);
                                    manager.createNotificationChannel(channel);
                                }

                                age = 65;

                                if(age >= 65){
                                    if(currentTime.equals("11:00:00 PM")){
                                        NotificationCompat.Builder builder = new NotificationCompat.Builder(EarthTime.this, "My Notification");
                                        builder.setContentTitle("Time to sleep!");
                                        builder.setContentText("Good night");
                                        builder.setSmallIcon(R.drawable.ic_launcher_background);builder.setAutoCancel(true);
                                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(EarthTime.this);
                                        managerCompat.notify(1, builder.build());
                                        getSound();
                                    }
                                }
                                else if(age >= 26 && age <= 64){
                                    if(currentTime.equals("11:00:00 PM")){
                                        NotificationCompat.Builder builder = new NotificationCompat.Builder(EarthTime.this, "My Notification");
                                        builder.setContentTitle("Time to sleep!");
                                        builder.setContentText("Good night");
                                        builder.setSmallIcon(R.drawable.ic_launcher_background);
                                        builder.setAutoCancel(true);
                                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(EarthTime.this);
                                        managerCompat.notify(1, builder.build());
                                        getSound();
                                    }
                                }
                                else if(age >= 18 && age <= 25){
                                    if(currentTime.equals("10:00:00 PM")){
                                        NotificationCompat.Builder builder = new NotificationCompat.Builder(EarthTime.this, "My Notification");
                                        builder.setContentTitle("Time to sleep!");
                                        builder.setContentText("Good night");
                                        builder.setSmallIcon(R.drawable.ic_launcher_background);
                                        builder.setAutoCancel(true);
                                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(EarthTime.this);
                                        managerCompat.notify(1, builder.build());
                                        getSound();
                                    }
                                }
                                else if(age >= 14 && age <= 17){
                                    if(currentTime.equals("10:00:00 PM")){
                                        NotificationCompat.Builder builder = new NotificationCompat.Builder(EarthTime.this, "My Notification");
                                        builder.setContentTitle("Time to sleep!");
                                        builder.setContentText("Good night");
                                        builder.setSmallIcon(R.drawable.ic_launcher_background);
                                        builder.setAutoCancel(true);
                                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(EarthTime.this);
                                        managerCompat.notify(1, builder.build());
                                        getSound();
                                    }
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

        soundOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(advideSong == null) {
                    advideSong = MediaPlayer.create(EarthTime.this, R.raw.advise);
                    advideSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                        @Override
                        public void onCompletion(MediaPlayer mp){
                            advideSong.stop();
                        }
                    });
                }

                advideSong.start();
            }
        });

        soundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(advideSong!=null){
                    advideSong.release();
                    advideSong = null;
                    //alarm message
                }
            }
        });
    }
    public void getSound(){
        if(advideSong == null) {
            advideSong = MediaPlayer.create(EarthTime.this, R.raw.advise);
            advideSong.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                @Override
                public void onCompletion(MediaPlayer mp){
                    advideSong.stop();
                }
            });
        }

        advideSong.start();
    }

    private void set_alarm_text(String output) {
        update_text.setText(output);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback

    }
}