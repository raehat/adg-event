package com.example.adg_event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddnewActivity extends AppCompatActivity {
    private Button back,add;
    private EditText name,cost;
    private String name1,cost1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnew);

        back = findViewById(R.id.backbtn);
        name = findViewById(R.id.nameoftheexpense);
        cost = findViewById(R.id.cost_edt);
        add = findViewById(R.id.addexpensebtn);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name.getText().toString();
                cost1 = cost.getText().toString();

                if(name1.equals("") && cost1.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter the Name and the Expense",Toast.LENGTH_LONG).show();
                }
                else if(name1.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter the Name of the expense",Toast.LENGTH_LONG).show();
                }
                else if(cost1.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please Enter the cost",Toast.LENGTH_LONG).show();
                }
                else {

                    SharedPreferences sharedPreferences = getSharedPreferences("sharedpref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("name", name1);
                    editor.putInt("cost", Integer.parseInt(cost1));
                    editor.apply();

                    finish();
                }
            }
        });
    }
}