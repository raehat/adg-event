package com.example.adg_event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class FirstPage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView imageViewPlusSign;
    private ArrayList<ItemModel> list;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", "");
        editor.putInt("cost", 0);
        editor.apply();

        recyclerView = findViewById(R.id.recycler_view_items);
        imageViewPlusSign = findViewById(R.id.image_plus_sign);

        if(list == null)
        {
            list = new ArrayList<>();
        }

        imageViewPlusSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPage.this,AddnewActivity.class);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        try{
            adapter = new ItemAdapter(list, getApplicationContext());
            recyclerView.setAdapter(adapter);
        }
        catch(NullPointerException e)
        {
            System.out.println("Error : " + e.getLocalizedMessage().toString());
        }
    }

    private void additem(String name, int cost) {
        try {
            list.add(new ItemModel(name, cost));
            System.out.println("Hello " + list.size());
            try{
                adapter.notifyItemInserted(list.size() - 1);
                adapter.notifyData(list);
            }
            catch (NullPointerException e)
                {
                    adapter = new ItemAdapter(list, getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error : " + e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("sharedpref",MODE_PRIVATE);
        if(!sharedPreferences.getString("name","").equals("") && sharedPreferences.getInt("cost",0) != 0) {
            additem(sharedPreferences.getString("name",""),sharedPreferences.getInt("cost",0));
        }
    }
}