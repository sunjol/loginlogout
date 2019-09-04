package com.example.loginlogout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class catsel extends AppCompatActivity {
SharedPreferences preferences;
Button cricket;
Button football;
Button politics;
int key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catsel);
//        SharedPreferences.Editor editor = preferences.edit();
        cricket=findViewById(R.id.cricket);
        football=findViewById(R.id.football);
        politics=findViewById(R.id.politics);
        preferences=getSharedPreferences("loginkey",0);
        key=preferences.getInt("key",11);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("key",0);
                editor.apply();
                Intent intent=new Intent(catsel.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("key",1);
                editor.apply();
                Intent intent=new Intent(catsel.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        politics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();

                editor.putInt("key",2);
                editor.apply();
                Intent intent=new Intent(catsel.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
