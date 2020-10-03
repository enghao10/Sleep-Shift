package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MealDay4 extends AppCompatActivity {

    TextView textView12;
    TextView textView13;
    TextView textView14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_day4);

        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        String mealA="Meal A\n\nCereal, hot\nCinnamon Roll\nMilk\nGrape Juice\nCoffee/Tea/Cocoa";
        String mealB="Meal B\n\nQuiche Lorraine\nSeasoned Rye Krisp\nFresh Orange\nCookies, Butter";
        String mealC="Meal C\n\nSoup, won ton\nChicken Teriyaki\nChinese Vegetables, stir-fry\nEggs Rools\nHot Chinese Mustard\nSweet n Sour Sauce\nVanilla Ice Cream\nCookies, fortune\nTea";

        textView12.setText(mealA);
        textView13.setText(mealB);
        textView14.setText(mealC);
    }
}