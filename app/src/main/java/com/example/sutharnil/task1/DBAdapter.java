package com.example.sutharnil.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {

    Context context;
    SQLiteDatabase db;
    DBHelper helper;

    public  DBAdapter (Context c){
        this.context=c;
        helper=new DBHelper(c);
    }

    public void OpenDB(){
        try {
            db =helper.getWritableDatabase();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public  void CloseDB(){

        try {
            helper.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
//insert
    public  boolean  add(String name ,String enroll, String address ,String gender){

        try {
            ContentValues contentValues =new ContentValues();
            contentValues.put(Constants.Col_2,name);
            contentValues.put(Constants.Col_3,enroll);
            contentValues.put(Constants.Col_4,address);
            contentValues.put(Constants.Col_5,gender);

            long result = db.insert(Constants.Table_Name,Constants.Col_1,contentValues);

            if (result>0){
                return  true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
//reload
   public Cursor retrieve(){

        String[] columns={Constants.Col_1,Constants.Col_2,Constants.Col_3,Constants.Col_4,Constants.Col_5};

        Cursor c=db.query(Constants.Table_Name,columns,null,null,null,null,null);

        return c;

   }

  //update
   public  boolean update(String sname,String senroll ,String saddress,String sgender,int id){

        try {

            ContentValues contentValues =new ContentValues();
            contentValues.put(Constants.Col_2,sname);
            contentValues.put(Constants.Col_3,senroll);
            contentValues.put(Constants.Col_4,saddress);
            contentValues.put(Constants.Col_5,sgender);
            int result =db.update(Constants.Table_Name,contentValues,Constants.Col_1+" =?",new String[]{String.valueOf(id)});
            if (result>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
   }

//delete

    public  boolean delete(int id){

        try {

            int result =db.delete(Constants.Table_Name,Constants.Col_1+" =?",new String[]{String.valueOf(id)});
            if (result>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

