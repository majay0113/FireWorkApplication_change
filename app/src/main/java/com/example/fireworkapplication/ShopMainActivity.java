package com.example.fireworkapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopMainActivity extends AppCompatActivity {
    private TextView foodNames,inputFodd;
    private ImageView img;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_main);

        foodNames = findViewById(R.id.food_name);
        img = findViewById(R.id.food_imge);
        Intent intent= getIntent();
        String foodName = intent.getExtras().getString("Food Name");
        int image = intent.getExtras().getInt("Food Picture");

        foodNames.setText(foodName);
        img.setImageResource(image);

        EditText editText = (EditText) findViewById(R.id.the_food_total_mount);
        String message = editText.getText().toString();

    }
}