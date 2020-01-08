package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeCake extends AppCompatActivity {
    ImageButton btn_menu1,btn_menu2,btn_tambah;
    Button btn_cake,btn_berry,btn_caramel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cake);

        btn_menu1=findViewById(R.id.home1);
        btn_menu2=findViewById(R.id.home2);
        btn_tambah=findViewById(R.id.btn_add);
        btn_cake=findViewById(R.id.btn_cake1);
        btn_berry=findViewById(R.id.btn_cake2);
        btn_caramel=findViewById(R.id.btn_cake3);

        //----------MENU CAKE------------
        btn_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeCake.this, CupCake.class));
            }
        });
        btn_berry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeCake.this, Berry.class));
            }
        });
        btn_caramel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeCake.this, Caramel.class));
            }
        });

        //----------MENU IKON------------
        btn_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeCake.this, Home.class));
            }
        });
        btn_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeCake.this, HomeDrink.class));
            }
        });

        //----------HEADER------------
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(HomeCake.this, Add.class));
            }
        });

    }
}
