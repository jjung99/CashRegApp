package com.example.cashregapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String Tag="MainActivity";
    private Product product;
    private ProductManager productManager;

    ArrayList<History> historyList = new ArrayList<>();
    ArrayList<Product> productList = new ArrayList<>();

    //for buttons and Text view for constraint layout
    TextView tvSelected;
    TextView tvTotal;
    TextView tvTotalQty;
    TextView tvQty;
    NumberPicker qtyPicker;
    Button buyButton;
    Button managerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Assignment_2");
        setContentView(R.layout.activity_main);
        Log.d(Tag,"OnCreate: App started");

        //get variables
        tvSelected=findViewById(R.id.selectedName);
        tvQty = findViewById(R.id.selectedQty);
        tvTotalQty=findViewById(R.id.productTotalQty);
        tvTotal = findViewById(R.id.totalPrice);
        qtyPicker = findViewById(R.id.numberPicker);
        buyButton = (Button)findViewById(R.id.buyBtn);
        managerButton = findViewById(R.id.managerBtn);

        //create product objects
        Product Pantie = new Product("Pantie","20.44",10);
        Product Shoes = new Product("Shoes","10.44",100);
        Product Hats = new Product("Hats","5.9",30);

        //create product list and add product objects
        productList.add(Pantie);
        productList.add(Shoes);
        productList.add(Hats);

        // selected Product
        product = new Product();

        //set the product list view
        ProductList pAdaptor = new ProductList(this,R.layout.product_list,productList, product, tvSelected, tvQty, qtyPicker);
        ListView pListView =(ListView) findViewById(R.id.productListView);
        pListView.setAdapter(pAdaptor);

        //when quantity is selected
        qtyPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                tvQty.setText(i1+"");
                product.setpTotalQty(numberPicker.getValue());
                double total = numberPicker.getValue()* Double.parseDouble(product.getpPrice());
                tvTotal.setText(total+"");

            }
        });

        //event when click buy buttons
        buyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                AlertDialog.Builder builder;

                if(String.valueOf(tvQty.getText())=="0"){
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_LONG).show();
                }else{
                   // Log.d(Tag, "this is "+String.valueOf(tvQty.getText()));

                    //successful alert
                    builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Thank You for your purchase!");
                    builder.setMessage("Your purchase is " + tvQty.getText()
                            + " " + tvSelected.getText() + " for " + tvTotal.getText());

                    builder.setCancelable(true);
                    builder.setNegativeButton("OK",null);
                    builder.show();


                   // SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
                   // String time = sdf.format(new Date());
                    for( Product product : productList) {
                        if(product.getpName().equals((tvSelected.getText().toString()))) {
                           product.setpTotalQty(product.getpTotalQty() - Integer.parseInt(tvQty.getText()+""));
                        }
                    }

                    //add product history
                    History history = new History(tvSelected.getText()+"",tvTotal.getText()+"", Integer.parseInt(tvQty.getText()+""), new Date());
                    historyList.add(history);

                    //reset text views
                    tvSelected.setText("Product Type");
                    tvQty.setText("0");
                    qtyPicker.setMaxValue(0);
                    tvTotal.setText(String.valueOf(0));
                }
            }
        });

        //event when click manager buttons
        managerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View btnView) {
                Intent intent = new Intent(MainActivity.this, ManagerActivity.class);
                intent.putExtra("historyList", historyList);
             //   intent.putExtra("productList", productList);
                startActivity(intent);
            }
        });
    }

}