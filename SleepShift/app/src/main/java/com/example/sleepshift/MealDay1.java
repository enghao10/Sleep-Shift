package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MealDay1 extends AppCompatActivity {

    TextView textView3;
    TextView textView4;
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_day1);

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        String mealA="Meal A\n\nEggs Scrambled w/Bacon, Hash Browns, Sausage\nToast\nMargarine\nJelly, Assorted\nApple Juice\nCoffee/Tea/Cocoa";
        String mealB="Meal B\n\nChicken, over-fried\nMacaroni and Cheese\nCorn, whole kernel\nPeaches\nAlmonds\nPineapple-Grape Juice";
        String mealC="Meal C\n\nBeef Fajita\nSpanish Rice\nTortilla Chips\nPicante Sauce\nChili con Queso\nTortilla\nLemon Bar\nApple Cider";

        textView3.setText(mealA);
        textView4.setText(mealB);
        textView5.setText(mealC);
    }
}