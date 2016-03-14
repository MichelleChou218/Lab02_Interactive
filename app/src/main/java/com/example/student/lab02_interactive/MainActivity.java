package com.example.student.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int mQuantity = 0;
    int mPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        displayTotalPrice();
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

    private void displayTotalPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        String message = myString + (mQuantity == 0? "\nFree" : "\nThank you!");
        priceTextView.setText(message);
    }

    private void resetPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }

    public void increment(View view) {
        ++mQuantity;
        displayQuantity();
        resetPrice();
    }

    private int getQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void decrement(View view) {

        if (mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetPrice();
        }


    }
}
