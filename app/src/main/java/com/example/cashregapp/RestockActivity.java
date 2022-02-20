package com.example.cashregapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class RestockActivity extends AppCompatActivity {
    private static final String Tag="MainActivity";
    private Product product;
    private ProductManager productManager;

    EditText qtyEdit;
    Button okButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        setTitle("Assignment_2");

            //get variables
            okButton = (Button)findViewById(R.id.okBtn);
            cancelButton = findViewById(R.id.cancelBtn);

            //create product list
            ArrayList<Product> productList = new ArrayList<>();

            // Product
            product = new Product();

            //set the product list view
            ProductList Adaptor = new ProductList(this,R.layout.product_list,productList, product);
            ListView listView =(ListView) findViewById(R.id.restockList);
            listView.setAdapter(Adaptor);

        //event when click buy buttons
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                AlertDialog.Builder builder;

            } });

        //event when click buy buttons
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                AlertDialog.Builder builder;

            } });

    }
}