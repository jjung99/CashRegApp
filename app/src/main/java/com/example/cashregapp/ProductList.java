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

import java.util.ArrayList;
import java.util.List;

public class ProductList<convertView> extends ArrayAdapter<Product> {
    private static final String TAG = "ProductListAdaptor";

    private Context pContext;
    private int pResource;
    private Product pProduct;
    TextView selectedName;
    TextView selectedQty;
    NumberPicker numberPicker;

    ArrayList<Product> product = new ArrayList(0);
    public void addProduct(Product p){
        product.add(p);
    }

    public ProductList(Context context, int resource, ArrayList<Product> obj, Product product, TextView selectedName, TextView selectedQty,  NumberPicker numberPicker){
        super(context,resource,obj);
        pContext=context;
        pResource=resource;
        pProduct=product;
        this.selectedName=selectedName;
        this.selectedQty=selectedQty;
        this.numberPicker=numberPicker;
    }

    public ProductList(Context context, int resource, ArrayList<Product> obj, Product product){
        super(context,resource,obj);
        pContext=context;
        pResource=resource;
        pProduct=product;
        this.selectedName=selectedName;
        this.selectedQty=selectedQty;
        this.numberPicker=numberPicker;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

         //create product object with the value from getter
         Product product = getItem(position);

        LayoutInflater inflater=LayoutInflater.from(pContext);
        convertView = inflater.inflate(pResource,parent, false);
        LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.pList);

        //create text view
        TextView pViewName = (TextView) convertView.findViewById(R.id.productName);
        TextView pViewPrice = (TextView) convertView.findViewById(R.id.productPrice);
        TextView pViewTotalQty = (TextView) convertView.findViewById(R.id.productTotalQty);

        //set product variable
        pViewName.setText(product.getpName());
        pViewPrice.setText(product.getpPrice());
        pViewTotalQty.setText(product.getpTotalQty()+"");

        layout.setOnClickListener(view -> {
            pProduct.setpName(product.getpName());
            pProduct.setpPrice(product.getpPrice());
            selectedName.setText(product.getpName());
            numberPicker.setMaxValue(product.getpTotalQty());
        });
        return convertView;
    }



}
