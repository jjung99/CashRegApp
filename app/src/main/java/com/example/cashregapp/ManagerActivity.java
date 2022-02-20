package com.example.cashregapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerActivity extends AppCompatActivity {

    Button restockButton;
    Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        setTitle("Assignment_2");

        restockButton=findViewById(R.id.restockBtn);
        historyButton=findViewById(R.id.historyBtn);

        Intent currentIntent = getIntent();

        //event when click restock buttons
        restockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                Intent intent = new Intent(ManagerActivity.this, RestockActivity.class);
                intent.putExtra("productList", currentIntent.getSerializableExtra("productList"));
                startActivity(intent);
            }
        });

        //event when click history buttons
        historyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                Intent intent = new Intent(ManagerActivity.this, HistoryActivity.class);
                intent.putExtra("historyList", currentIntent.getSerializableExtra("historyList"));
                startActivity(intent);
            }
        });
    }
}