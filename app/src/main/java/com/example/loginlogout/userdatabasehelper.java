package com.example.loginlogout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class userdatabasehelper extends SQLiteOpenHelper {
    SQLiteDatabase database;
    ArrayList<ques> quesList1;
    ques ques1;
    ques ques2;
    ques ques3;
    ques ques4;

    private static final String databasename="Quiz.db";
    private static final String userinfo="userinfo";
    public userdatabasehelper(Context context) {
        super(context, databasename, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table userinfo(username text,name text,pass text);" );
    db.execSQL("create table ques1(qno int,question text,op1 text,op2 text,op3 text,ans int);");
    db.execSQL("create table ques2(qno int,question text,op1 text,op2 text,op3 text,ans int);");
    db.execSQL("create table ques3(qno int,question text,op1 text,op2 text,op3 text,ans int);");
    db.execSQL("create table score(uname text,scor int,cat text);");

        quesList1=new ArrayList<>();
    //ques1("Who is team Inida's Current captain","M.S.Dhoni","Virat Kohli","Rohit Sharma",2);
    //quesList1.add(new ques("Which team won the 2019 IPL","Chennai Super Kings","Sunrisers Hyderabad","Mumbai Indians",3));
    //quesList1.add(new ques("Who is team Inida's wicket keeper for west indies tour","M.S.Dhoni","K L Rahul","Rishabh Pant",3));
    //quesList1.add(new ques("Who is team England's Current odi captain","Eoin Morgan","Joe Root","Ben Stokes",1));
    database=db;


        // database.insert("ques1",null,quesList1);
    }
    public void createq1(){
        database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("qno",1);
        values.put("question","Who is team Inida's Current captain");
        values.put("op1","M.S.Dhoni");
        values.put("op2","Virat Kohli");
        values.put("op3","Rohit Sharma");
        values.put("ans",2);
        database.insert("ques1",null,values);
        values.put("qno",2);
        values.put("question","Who won IPL 2019");
        values.put("op1","Chennai Super Kings");
        values.put("op2","Sunrisers Hyderabad");
        values.put("op3","Mumbai Indians");
        values.put("ans",3);
        database.insert("ques1",null,values);
        values.put("qno",3);
        values.put("question","Who is team Inida's wicket keeper for west indies tour");
        values.put("op1","Rishabh Pant");
        values.put("op2","M S Dhoni");
        values.put("op3","K L Rahul");
        values.put("ans",1);
        database.insert("ques1",null,values);
        values.put("qno",1);
        values.put("question","Who won FIFA most number of times");
        values.put("op1","Brazil");
        values.put("op2","Argentina");
        values.put("op3","Italy");
        values.put("ans",1);
        database.insert("ques2",null,values);
        values.put("qno",2);
        values.put("question","What is El Clasico");
        values.put("op1","Manchester United vs Manchester city");
        values.put("op2","Argentina vs Portugal");
        values.put("op3","Real Madrid vs F.C.Barcelona");
        values.put("ans",3);
        database.insert("ques2",null,values);
        values.put("qno",1);
        values.put("question","Who won FIFA 18");
        values.put("op1","Brazil");
        values.put("op2","Italy");
        values.put("op3","Coratia");
        values.put("ans",2);
        database.insert("ques2",null,values);
        values.put("qno",1);
        values.put("question","Which is the ruling party in India");
        values.put("op1","BJP");
        values.put("op2","INC");
        values.put("op3","AAP");
        values.put("ans",1);
        database.insert("ques3",null,values);
        values.put("qno",2);
        values.put("question","Who is the prime minister of India");
        values.put("op1","Rahul Gandhi");
        values.put("op2","Narendra Modi");
        values.put("op3","Arvind Kejriwal");
        values.put("ans",2);
        database.insert("ques3",null,values);
        values.put("qno",1);
        values.put("question","How many parties are there in U.S.A.");
        values.put("op1","1");
        values.put("op2","0");
        values.put("op3","2");
        values.put("ans",3);
        database.insert("ques3",null,values);
        database.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+userinfo+";");
        this.onCreate(database);
    }
    public void insertdata(userinform userinform){
     database=this.getWritableDatabase();
     ContentValues values=new ContentValues();
     ContentValues values1=new ContentValues();
        values.put("username",userinform.getUname());
        values.put("name",userinform.getName());
        values.put("pass",userinform.getPassword());
        database.insert("userinfo",null,values);
        values1.put("uname",userinform.getUname());
        values1.put("scor",0);
        values1.put("cat","cricket");
        database.insert("score",null,values1);
        values1.put("uname",userinform.getUname());
        values1.put("scor",0);
        values1.put("cat","football");
        database.insert("score",null,values1);
        values1.put("uname",userinform.getUname());
        values1.put("scor",0);
        values1.put("cat","politics");
        database.insert("score",null,values1);
        database.close();

    }
    public int searchuser(String Uname, String pass) {
        database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select username,pass from userinfo; ", null);

        if (cursor.moveToFirst()) {
            do {
                if (cursor.getString(0).equals(Uname)) {
                    if (cursor.getString(1).equals(pass)) {
                        database.close();
                        return 2;
                    } else {
                        database.close();
                        return 1;
                    }

                }
            } while (cursor.moveToNext());

            if (cursor.isLast() == true) {
                database.close();
                return 0;
            }
        }
    return 0;}
    public int serachusername(String userinfo){
        database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select username from userinfo;",null);
        if(cursor.moveToFirst()){
            do{
                if(cursor.getString(0).equals(userinfo)){
                    return 0;
                }
            }while(cursor.moveToNext());
            return 1;
        }
        return 1;
    }

    public ques setques(int qn,int check){
        String table = null;
        if(check==0){
            table="ques1";
        }
        else if(check==1){
            table="ques2";
        }
        else {
            table="ques3";
        }
        ques ques;
        ques=new ques();
        database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select qno,question,op1,op2,op3,ans from "+table+";",null);
        cursor.moveToPosition(qn);
        ques.setQno(qn);
        ques.setQname(cursor.getString(1));
        ques.setOp1(cursor.getString(2));
        ques.setOp2(cursor.getString(3));
        ques.setOp3(cursor.getString(4));
        ques.setAns(cursor.getInt(5));

        return ques;
    }
    public void setHighScore(String category,String username,int score){
        database=getWritableDatabase();
        Cursor cursor=database.rawQuery("select uname,scor,cat from score;",null);
        if(cursor.moveToFirst()){
            do {
               if(cursor.getString(0).equals(username)){
                   if(cursor.getString(2).equals(category)){
                       if(cursor.getInt(1)<score){
                           database.rawQuery("update score set scor = "+score+" where uname = "+username+" and cat = "+category+";",null);
                       }
                   }
               }
            }while(cursor.moveToNext());
            }


        database.close();
    }
    public ArrayList<high> show_highscore(){
        ArrayList<high> list;
        String string;
        String string1;
        int num;
        database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select uname,scor,cat from score order by scor desc;",null);
        list = new ArrayList<>();
        int i=0;
            do {
                cursor.moveToPosition(i);
                i++;
                string=cursor.getString(0);
                string1=cursor.getString(2);
                num=cursor.getInt(1);
                list.add(new high(string,num,string1));
            } while (i < 10);

            return list;

    }

}





