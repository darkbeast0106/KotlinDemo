package com.darkbeast0106.kotlindemo_14s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnJava, btnJava2Kotlin, btnKotlin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnJava.setOnClickListener(v -> {
            Intent intent = new Intent(this,JavaActivity.class);
            startActivity(intent);
            finish();
        });
        btnJava2Kotlin.setOnClickListener(v -> {
            Intent intent = new Intent(this,Java2KotlinActivity.class);
            startActivity(intent);
            finish();
        });
        btnKotlin.setOnClickListener(v -> {
            Intent intent = new Intent(this,KotlinActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void init() {
        btnJava = findViewById(R.id.btnJava);
        btnJava2Kotlin = findViewById(R.id.btnJava2Kotlin);
        btnKotlin = findViewById(R.id.btnKotlin);
    }
}