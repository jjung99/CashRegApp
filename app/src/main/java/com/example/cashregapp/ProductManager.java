package com.example.cashregapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class ProductManager<convertView> extends ArrayAdapter<History> {

    private Context hContext;
    private int hResource;
    private History hProduct;
    TextView historyName;
    TextView historyQty;
    TextView historyPrice;
    Date date;
    TextView detailName;
    TextView detailPrice;

    ArrayList<History> historyList = new ArrayList(0);

    public void addHistory(History h) {
        historyList.add(h);
    }

    public ProductManager(HistoryActivity historyActivity, int history, ArrayList<History> histories, History history1, TextView historyName, TextView historyPrice, TextView historyQty, Date date) {
        super(historyActivity, history, histories);
        hContext = historyActivity;
        hResource = history;
        hProduct = history1;
        this.historyName = historyName;
        this.historyQty = historyQty;
        this.historyPrice = historyPrice;
        this.date = date;
    }

    public ProductManager(HistoryActivity historyActivity, int history, ArrayList<History> histories, History history1, TextView detailName, TextView detailPrice, Date date) {
        super(historyActivity, history, histories);
        hContext = historyActivity;
        hResource = history;
        hProduct = history1;
        this.detailName = detailName;
        this.detailPrice = detailPrice;
        this.date = date;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //create history object with the value from getter
        History history = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(hContext);
        convertView = inflater.inflate(hResource, parent, false);
        LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.history);

        //create text view
        TextView historyName = (TextView) convertView.findViewById(R.id.historyName);
        TextView historyQty = (TextView) convertView.findViewById(R.id.historyQty);
        TextView historyPrice = (TextView) convertView.findViewById(R.id.historyPrice);

    //    TextView datailName = (TextView) convertView.findViewById(R.id.datailName);
    //    TextView datailPrice = (TextView) convertView.findViewById(R.id.datailPrice);
        TextView historyDate = (TextView) convertView.findViewById(R.id.detailTime);


        //set product variable
        historyName.setText(history.gethName());
        historyPrice.setText(history.gethPrice());
        historyQty.setText(history.gethTotalQty());
        historyDate.setText(history.gethTime()+"");


        layout.setOnClickListener(view -> {
            hProduct.sethName(history.gethName());
            hProduct.sethPrice(history.gethPrice());
            hProduct.sethTime(history.gethTime());
       //     selectedName.setText(product.getpName());
            //    numberPicker.setMaxValue(product.getpTotalQty());
        });

        return convertView;
    }
}

