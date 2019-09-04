package com.example.loginlogout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView scorel;
    Button button;
    Button button1;
    int score = 0;
    RadioButton radioButton;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioGroup radioGroup;
    ques quesset=null;
    int j=0;
    int optionsel;
    int cate;
    String check;
    DatabaseReference databaseReference;
    SharedPreferences shared;
    userinform userinfo=new userinform();

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userdatabasehelper userdatabasehelper=new userdatabasehelper(getApplicationContext());
        userdatabasehelper.createq1();


        radioGroup=findViewById(R.id.radio);
        scorel =findViewById(R.id.scor);
        textView=findViewById(R.id.textView3);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioButton2=findViewById(R.id.radioButton3);
        button1=findViewById(R.id.button5);
        button=findViewById(R.id.button);
        //final String check;
        shared=getSharedPreferences("loginkey",0);
        check=shared.getString("username","");


        cate=shared.getInt("key",11);
        quesset=userdatabasehelper.setques(j,cate);
        textView.setText(quesset.getQname());
        radioButton.setText(quesset.getOp1());
        radioButton1.setText(quesset.getOp2());
        radioButton2.setText(quesset.getOp3());
        radioButton.setSelected(false);
        radioButton1.setSelected(false);
        radioButton2.setSelected(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = shared.edit();
                Intent intent=new Intent(MainActivity.this,login.class);
                editor.remove("Username").commit();
                editor.remove("Password").commit();
                editor.remove("login").commit();
                editor.apply();
                startActivity(intent);
                finish();


            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsel=1;
            }
        });
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsel=2;
            }

        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsel=3;
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v1) {
                                           if (optionsel == quesset.getAns())//((quesset.getAns()==1&&radioButton.isSelected())||(quesset.getAns()==2&&radioButton1.isSelected())||(quesset.getAns()==3&&radioButton2.isSelected()))
                                           {
                                               score = score + 30;
                                               scorel.setText("" + score);
                                               Toast.makeText(getApplicationContext(), "ans correct !! " + score, Toast.LENGTH_LONG).show();

                                           } else {
                                               score = score - 5;
                                               scorel.setText("" + score);
                                               //scorel.setText(score);
                                               Toast.makeText(getApplicationContext(), "answer incorrect !!" + score, Toast.LENGTH_LONG).show();

                                           }
                                           //score=scores;
                                           j = j + 1;
                                           userdatabasehelper userdatabasehelper = new userdatabasehelper(getApplicationContext());
                                           optionsel = 0;
                                               if (j < 3) {
                                                   quesset = userdatabasehelper.setques(j,cate);
                                                   textView.setText(quesset.getQname());
                                                   radioButton.setText(quesset.getOp1());
                                                   radioButton1.setText(quesset.getOp2());
                                                   radioButton2.setText(quesset.getOp3());
                                                   radioButton.setSelected(false);
                                                   radioButton1.setSelected(false);
                                                   radioButton2.setSelected(false);
                                               } else {
                                                   shared=getSharedPreferences("loginkey",0);
                                                   check=shared.getString("Username","");


                                                   cate=shared.getInt("key",11);
                                                  // userdatabasehelper.setHighScore("cricket", check, score);
                                                   databaseReference= FirebaseDatabase.getInstance().getReference("users").child(check);
                                                   databaseReference.addValueEventListener(new ValueEventListener() {
                                                       //shared=getSharedPreferences("loginkey",0);

                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                            userinfo= dataSnapshot.getValue(userinform.class);

                                                               if(userinfo.getScore1()<score&&cate==0){
                                                                    //Toast.makeText(getApplicationContext(), userinfo.getScore1().toString(), Toast.LENGTH_LONG).show();
                                                                    userinfo.setScore1(score);
                                                               }
                                                               else if(userinfo.getScore2()<score&&cate==1){
                                                                   userinfo.setScore2(score);
                                                               }
                                                               else if(userinfo.getScore3()<score&&cate==2){
                                                                   userinfo.setScore3(score);
                                                               }
                                                               databaseReference.setValue(userinfo);

                                                           }


                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError databaseError) {

                                                       }
                                                   });
                                                   Intent intent = new Intent(MainActivity.this, quizend.class);
                                                   startActivity(intent);
                                                   finish();

                                               }

                                       }
                                   }
        );
    }
}
