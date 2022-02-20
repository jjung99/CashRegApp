package com.example.cashregapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HistoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        setTitle("Assignment_2");

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

        }

    }
}