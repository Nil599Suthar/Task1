package com.example.sutharnil.task1;

public class Constants {

    public static final String Database_Name ="Student_Details";
    public static final String Table_Name ="Student_Table";
    public static final String Col_1 ="Id";
    public static final String Col_2 ="S_Name";
    public static final String Col_3 ="S_Enroll";
    public static final String Col_4 ="S_Address";
    public static final String Col_5 ="S_Gender";

    static  final String CREATE_TB ="CREATE TABLE Student_Table(Id INTEGER PRIMARY KEY AUTOINCREMENT ," +"S_Name VARCHAR NOT NULL ,"+ "S_Enroll VARCHAR NOT NULL,"+ "S_Address VARCHAR NOT NULL,"+ "S_Gender VARCHAR NOT NULL)";

    static  final  int DB_VERSION =1;

    static  final  String DROP_TB ="DROP TABLE IF EXISIS "+Table_Name;
}
