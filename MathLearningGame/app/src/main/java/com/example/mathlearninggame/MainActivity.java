package com.example.mathlearninggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_add, button_sub, button_div, button_mul, button_mix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Addition
        button_add = findViewById(R.id.button_sum);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_add = new Intent(MainActivity.this, GameOptions.class);
                intent_add.putExtra("type", "add");
                startActivity(intent_add);
            }
        });

        //Subtraction
        button_sub = findViewById(R.id.button_difference);
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_sub = new Intent(MainActivity.this, GameOptions.class);
                intent_sub.putExtra("type","sub");
                startActivity(intent_sub);
            }
        });

        //Multiplication
        button_mul = findViewById(R.id.button_product);
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_div = new Intent(MainActivity.this, GameOptions.class);
                intent_div.putExtra("type", "mul");
                startActivity(intent_div);
            }
        });

        //Division
        button_div = findViewById(R.id.button_quotient);
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_div = new Intent(MainActivity.this, MainActivity2.class);
                intent_div.putExtra("type", "div");
                startActivity(intent_div);
            }
        });

        //Mix Questions
        button_mix = findViewById(R.id.button_all);
        button_mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_mix = new Intent(MainActivity.this, GameOptions.class);
                intent_mix.putExtra("type", "mix");
                startActivity(intent_mix);
            }
        });
    }
}