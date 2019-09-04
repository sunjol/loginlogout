package com.example.loginlogout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SharedPreferences shared;
    String check;
    String username;
    String password;
    String user;
    String pass;
    Button button;
    Button button1;

    EditText textView;
    EditText textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        shared=getSharedPreferences("loginkey",0);
        check=shared.getString("login","");
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView2);
        button=findViewById(R.id.button2);
        button1=findViewById(R.id.button3);

        if(check.equals("true")){
            Intent intent=new Intent(login.this,catsel.class);
            startActivity(intent);
            finish();
        }
        else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user = textView.getText().toString();
                    pass = textView1.getText().toString();
                    userdatabasehelper userdatabasehelper=new userdatabasehelper(getApplicationContext());
                    if (userdatabasehelper.searchuser(user,pass)==2) {
                        Intent intent=new Intent(login.this,catsel.class);
                        SharedPreferences.Editor editor = shared.edit();
                        editor.putString("Username", user);
                        editor.putString("login", "true");
                        editor.putString("Password", pass);
                        editor.putInt("key",11);
                        editor.apply();
                        startActivity(intent);
                        finish();

                    }else if(userdatabasehelper.searchuser(user,pass)==1){
                        Toast.makeText(getApplicationContext(), "password is wrong !!", Toast.LENGTH_LONG).show();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "user dosent exist !!", Toast.LENGTH_LONG).show();

                    }
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1=new Intent(login.this,signup.class);
                    startActivity(intent1);
                    finish();
                }
            });
        }

    }
}
