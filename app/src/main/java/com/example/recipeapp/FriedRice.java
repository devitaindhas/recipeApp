package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FriedRice extends AppCompatActivity {
    ImageButton btn_tambah,btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fried_rice);

        btn_tambah=findViewById(R.id.btn_add);
        btn_back=findViewById(R.id.back);

        String string = getString(R.string.friedRice);


        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(FriedRice.this, Add.class));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriedRice.this, Home.class));
            }
        });

        TextView fried = (TextView) findViewById(R.id.rice); fried.setMovementMethod(new ScrollingMovementMethod());
    }
}

