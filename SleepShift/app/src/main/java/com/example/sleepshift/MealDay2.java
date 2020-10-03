package com.example.sleepshift;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MealDay2 extends AppCompatActivity {

    TextView textView6;
    TextView textView7;
    TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_day2);

        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        String mealA="Meal A\n\nCereal, cold\nYogurt, fruit\nBiscuit\nMargarine\nJelly, assorted\nMilk\nCranberry Juice\nCoffee/Tea/Cocoa";
        String mealB="Meal B\n\nSoup, cream of broccoli\nBeef Patty\nCheese Slice\nSandwich Bun\nPretzels\nCried Apples\nVanilla Pudding\nChocolate Instant Breakfast";
        String mealC="Meal C\n\nFish, saut ed\nTartar Sauce\nLemon Juice\nPasta Salad\nGreen Beans\nBread\nMargarine\nAngel Food Cake\nStrawberries\nOrange-Pineapple Drink";

        textView6.setText(mealA);
        textView7.setText(mealB);
        textView8.setText(mealC);
    }
}