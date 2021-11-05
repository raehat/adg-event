package com.example.adg_event;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewModel> {
    @NonNull
    ArrayList<ItemModel> list;
    Context context;

    public ItemAdapter(@NonNull ArrayList<ItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public ItemViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_card_view, parent, false);
        return new ItemViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewModel holder, int position) {
        holder.textViewGroceryName.setText(list.get(position).getGroceryName());
        holder.textViewGroceryPrice.setText(String.format("%d",list.get(position).getGroceryPrice()));
    }

    @Override
    public int getItemCount() {
        return (null != list?list.size():0);
    }

    public void notifyData(ArrayList<ItemModel> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.list = myList;
        notifyDataSetChanged();
    }
}
