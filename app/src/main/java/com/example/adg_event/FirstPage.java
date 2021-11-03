package com.example.adg_event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

public class FirstPage extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageViewPlusSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        recyclerView = findViewById(R.id.recycler_view_items);
        imageViewPlusSign = findViewById(R.id.image_plus_sign);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}