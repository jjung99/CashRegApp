package com.example.cashregapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<History> histories;
    History history;

    //for buttons and Text view for constraint layout
    private Context hContext;
    private int hResource;
    private Product hProduct;
    TextView historyName;
    TextView historyQty;
    TextView historyPrice;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setTitle("Assignment_2");
        history = new History();
        Intent currentIntent = getIntent();

       // Bundle bundle=getIntent().getExtras();
       // bundle.getStringArrayList("historyList");

        Bundle bundle= getIntent().getExtras();

        Log.d("bundle",bundle.toString());
        //set the product list view
     //   ProductManager hAdaptor = new ProductManager(this,R.layout.history,histories, history, historyName, historyPrice, historyQty, date);
    //    ListView hListView =(ListView) findViewById(R.id.historyList);
    //    hListView.setAdapter(hAdaptor);


        histories= (ArrayList<History>)getIntent().getSerializableExtra("historyList");
        Log.d("test",histories.toString());
        System.out.println(histories.toString());

    }
}