package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MealDay3 extends AppCompatActivity {

    TextView textView9;
    TextView textView10;
    TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_day3);

        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        String mealA="Meal A\n\nFrench Toast\nCanadian Bacon\nMargarine\nSyrup\nOrange Juice\nCoffee/Tea/Cocoa";
        String mealB="Meal B\n\nCheese Manicotti w/Tomato Sauce\nGarlic Bread\nBerry Medley\nCookie, shortbread\nLemonade";
        String mealC="Meal C\n\nTurkey Breast, sliced\nMashed Sweet Potato\nAsparagus Tips\nCornbread\nMargarine\nPumpkin Pie\nCheery Drink";

        textView9.setText(mealA);
        textView10.setText(mealB);
        textView11.setText(mealC);
    }
}