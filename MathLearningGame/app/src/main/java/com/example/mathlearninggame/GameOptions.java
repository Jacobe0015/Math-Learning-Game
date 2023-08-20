package com.example.mathlearninggame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameOptions extends AppCompatActivity {

    Button makeWish, noMistake, timeTrial;
    String type;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Button makeWish = findViewById(R.id.makeWish);
        Button noMistake = findViewById(R.id.noMistake);
        Button takeChance = findViewById(R.id.takeChances);
        Button timeTrial = findViewById(R.id.timeTrial);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            type = extras.getString("type");
        }

        if (type.equals("add")){
            makeWish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_add = new Intent(GameOptions.this, MainActivity2.class);
                    intent_add.putExtra("type", "wishAdd");
                    startActivity(intent_add);
                }
            });

            noMistake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_add = new Intent(GameOptions.this, MainActivity2.class);
                    intent_add.putExtra("type", "mistakeAdd");
                    startActivity(intent_add);
                }
            });
        }
        if (type.equals("mul")){
            makeWish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_mul = new Intent(GameOptions.this, MainActivity2.class);
                    intent_mul.putExtra("type", "wishMul");
                    startActivity(intent_mul);
                }
            });

            noMistake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_mul = new Intent(GameOptions.this, MainActivity2.class);
                    intent_mul.putExtra("type", "mistakeMul");
                    startActivity(intent_mul);
                }
            });
        }

        if(type.equals("mix")){
            takeChance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_mix = new Intent(GameOptions.this, MainActivity2.class);
                    intent_mix.putExtra("type", "mixChance");
                    startActivity(intent_mix);
                }
            });

            timeTrial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_time = new Intent(GameOptions.this, MainActivity2.class);
                    intent_time.putExtra("type", "mixTimeTrial");
                    startActivity(intent_time);
                }
            });


        }
    }
}
