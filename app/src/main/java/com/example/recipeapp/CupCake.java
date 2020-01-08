package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class CupCake extends AppCompatActivity {
    ImageButton btn_tambah,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cup_cake);

        btn_tambah=findViewById(R.id.btn_add);
        btn_back=findViewById(R.id.back);

        String string = getString(R.string.cake);


        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(CupCake.this, Add.class));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CupCake.this, HomeCake.class));
            }
        });
        TextView choco = (TextView) findViewById(R.id.cupcakes); choco.setMovementMethod(new ScrollingMovementMethod());
    }
}
