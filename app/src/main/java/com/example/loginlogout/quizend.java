package com.example.loginlogout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizend extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizend);
        button=findViewById(R.id.highscore);
        button1=findViewById(R.id.signout);
        button2=findViewById(R.id.takeagain);

        shared=getSharedPreferences("loginkey",0);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = shared.edit();
                Intent intent=new Intent(quizend.this,login.class);
                editor.remove("Username").commit();
                editor.remove("Password").commit();
                editor.remove("login").commit();
                editor.apply();
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(quizend.this,catsel.class);
                startActivity(intent);
                finish();
            }
        });

    }


}
