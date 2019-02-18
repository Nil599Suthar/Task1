package com.example.sutharnil.task1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String Database_Name = "Student_info";
    public static final String Table_Name = "Student";
    public static final String Col_1 = "Id";
    public static final String Col_2 = "S_Name";
    public static final String Col_3 = "S_Enroll";
    public static final String Col_4 = "S_Address";
    public static final String Col_5 = "S_Gender";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE " + Table_Name + " (Id INTEGER PRIMARY KEY AUTOINCREMENT ," + "S_Name ," + "S_Enroll ," + "S_Address ," + "S_Gender " + ")";
        db.execSQL(createtable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Table_Name);
        onCreate(db);

    }

    public long insertNote(String name, String enroll, String address, String gender) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Col_2, name);
        values.put(Col_3, enroll);
        values.put(Col_4, address);
        values.put(Col_5, gender);

        // insert row
        long id = db.insert(Table_Name, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public Student_info getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Table_Name,
                new String[]{Col_1,Col_2,Col_3,Col_4,Col_5},
                Col_1 + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Student_info note = new Student_info(
                cursor.getInt(cursor.getColumnIndex(Col_1)),
                cursor.getString(cursor.getColumnIndex(Col_2)),
                cursor.getString(cursor.getColumnIndex(Col_3)),
                cursor.getString(cursor.getColumnIndex(Col_4)),
                cursor.getString(cursor.getColumnIndex(Col_5)));


                // close the db connection
        cursor.close();

        return note;
    }

    public List<Student_info> getAllNotes() {
        List<Student_info> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + Table_Name ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student_info note = new Student_info();
                note.setID(cursor.getInt(cursor.getColumnIndex(Col_1)));
                note.setS_name(cursor.getString(cursor.getColumnIndex(Col_2)));
                note.setS_address(cursor.getString(cursor.getColumnIndex(Col_4)));
                note.setS_enroll(cursor.getString(cursor.getColumnIndex(Col_3)));
                note.setS_gender(cursor.getString(cursor.getColumnIndex(Col_5)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Table_Name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Student_info note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Col_2, note.getS_name());
        values.put(Col_3, note.getS_enroll());
        values.put(Col_4, note.getS_address());
       // values.put(Col_5, note.getS_gender());

        // updating row
        return db.update(Table_Name, values, Col_1 + " = ?",
                new String[]{String.valueOf(note.getID())});
    }

    public void deleteNote(Student_info note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Name, Col_1 + " = ?",
                new String[]{String.valueOf(note.getID())});
        db.close();
    }
}
