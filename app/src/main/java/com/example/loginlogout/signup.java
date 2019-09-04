package com.example.loginlogout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
         Button button;
        final EditText uname;
        final EditText name;
        final EditText pass;
        button=findViewById(R.id.button4);
        uname=findViewById(R.id.editTextuname);
        name=findViewById(R.id.editTextname);
        pass=findViewById(R.id.editText2pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 userdatabasehelper userdatabasehelper=new userdatabasehelper(getApplicationContext());
                userinform  userinform=new userinform();
                userinform.setName(name.getText().toString());
                userinform.setUname(uname.getText().toString());
                userinform.setPassword(pass.getText().toString());
                userinform.setScore1(0);
                userinform.setScore2(0);
                userinform.setScore3(0);
                if(userdatabasehelper.serachusername(userinform.getUname())==1) {
                    userdatabasehelper.insertdata(userinform);
                    Toast.makeText(getApplicationContext(), "Account created successfully !!", Toast.LENGTH_LONG).show();
                    databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userinform.getUname());

                    databaseReference.setValue(userinform);
                    Intent intent=new Intent(signup.this,login.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Username already taken!!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
