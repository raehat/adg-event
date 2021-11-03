package com.example.adg_event;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewModel extends RecyclerView.ViewHolder {
    TextView textViewGroceryName, textViewGroceryPrice;
    public ItemViewModel(@NonNull View itemView) {
        super(itemView);
        textViewGroceryName = itemView.findViewById(R.id.grocery_name);
        textViewGroceryPrice = itemView.findViewById(R.id.grocery_price);
    }
}
