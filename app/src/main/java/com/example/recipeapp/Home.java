package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    Button btn_spaghetti,btn_fried,btn_salmon;
    ImageButton btn_menu2,btn_menu3,btn_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_spaghetti=findViewById(R.id.btn_food1);
        btn_fried=findViewById(R.id.btn_food2);
        btn_salmon=findViewById(R.id.btn_food3);
        btn_menu2=findViewById(R.id.home2);
        btn_menu3=findViewById(R.id.home3);
        btn_tambah=findViewById(R.id.btn_add);

        //------------BUTTON MAKANAN-----------
        btn_spaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Spaghetti.class));
            }
        });
        btn_fried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, FriedRice.class));
            }
        });
        btn_salmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Salmon.class));
            }
        });

        //------------BUTTON MENU IKON-----------
        btn_menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, HomeDrink.class));
            }
        });
        btn_menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, HomeCake.class));
            }
        });

        //------------BUTTON ATAS-----------
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               startActivity(new Intent(Home.this, Add.class));
            }
        });
    }
}
