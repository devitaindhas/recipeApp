package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeDrink extends AppCompatActivity {

    ImageButton btn_menu1,btn_menu3,btn_tambah;
    Button btn_latte,btn_blue,btn_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drink);

        btn_menu1=findViewById(R.id.home1);
        btn_menu3=findViewById(R.id.home3);
        btn_tambah=findViewById(R.id.btn_add);
        btn_latte=findViewById(R.id.btn_drink1);
        btn_blue=findViewById(R.id.btn_drink2);
        btn_red=findViewById(R.id.btn_drink3);

        //------------BUTTON MINUMAN-----------
        btn_latte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeDrink.this, Coffee.class));
            }
        });
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeDrink.this, blue.class));
            }
        });
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeDrink.this, Red.class));
            }
        });

        //------------BUTTON MENU IKON-----------
        btn_menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeDrink.this, Home.class));
            }
        });
        btn_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeDrink.this, HomeCake.class));
            }
        });

        //------------BUTTON ATAS-----------
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(HomeDrink.this, Add.class));
            }
        });
    }
}
