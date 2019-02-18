package com.example.sutharnil.task1;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class Database extends AppCompatActivity {
    private FloatingActionButton floatingActionButton;
    ListView listView;
    EditText sname,senroll,saddress,sgender;
    Button save,reload;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();
    CustomAdapter adapter;
    Boolean forupdate= true;
    RadioButton male,female;
    String s,s1,s2,s3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        listView =(ListView)findViewById(R.id.recyclerviewStudent);
        adapter=new CustomAdapter(this,spacecrafts);
        this.getSpacecraft();

        //listView.setAdapter(adapter);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton2);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDailog(false);
            }
        });
    }

    private  void displayDailog(Boolean forupdate) {

        AlertDialog.Builder builder = new AlertDialog.Builder(Database.this);
        builder.setTitle("Fillup Details");
        builder.setCancelable(true);
        final View view = getLayoutInflater().inflate(R.layout.database_dailog_layout, null);
        sname = (EditText) view.findViewById(R.id.s_name);
        senroll = (EditText) view.findViewById(R.id.s_enroll);
        saddress = (EditText) view.findViewById(R.id.s_address);
        final RadioGroup gender = (RadioGroup) view.findViewById(R.id.rg_gender);
        male = (RadioButton) view.findViewById(R.id.rb_male);
        female = (RadioButton) view.findViewById(R.id.rb_female);
        Button ok = (Button) view.findViewById(R.id.btnSave);
        Button reload = (Button) view.findViewById(R.id.btnretrieve);


        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        if (!forupdate) {
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (male.isChecked()) {

                        s = male.getText().toString();
                        s1 = sname.getText().toString();
                        s2 = senroll.getText().toString();
                        s3 = saddress.getText().toString();
                        // Toast.makeText(Recyclerwithdatabase.this, ""+s, Toast.LENGTH_SHORT).show();
                        save(s1,s2,s3,s);

                    } else if (female.isChecked()) {
                        s = female.getText().toString();
                        s1 = sname.getText().toString();
                        s2 = senroll.getText().toString();
                        s3 = saddress.getText().toString();

                        save(s1, s2, s3, s);
                    }

                }
            });

            reload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSpacecraft();
                }
            });
        }else {

            sname.setText(adapter.getSelecteditemNAme());
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (male.isChecked()) {

                        s = male.getText().toString();
                        s1 = sname.getText().toString();
                        s2 = senroll.getText().toString();
                        s3 = saddress.getText().toString();
                        // Toast.makeText(Recyclerwithdatabase.this, ""+s, Toast.LENGTH_SHORT).show();

                    } else if (female.isChecked()) {
                        s = female.getText().toString();
                        s1 = sname.getText().toString();
                        s2 = senroll.getText().toString();
                        s3 = saddress.getText().toString();
                    }
                    update(s1,s2,s3,s);

                }
            });
            reload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                getSpacecraft();
                }
            });
        }


    }
//save
    private   void save(String name,String enroll,String adress,String gender){

        DBAdapter dbAdapter=new DBAdapter(this);
        dbAdapter.OpenDB();
        boolean saved =dbAdapter.add(name,enroll,adress,gender);
        if (saved){
            sname.setText("");
            getSpacecraft();
        }else {
            Toast.makeText(this, "Unable to save", Toast.LENGTH_SHORT).show();
        }
    }
//reload

     private  void getSpacecraft(){
        spacecrafts.clear();
        DBAdapter dbAdapter =new DBAdapter(this);
        dbAdapter.OpenDB();
         Cursor c =dbAdapter.retrieve();
         Spacecraft spacecraft=null;

         while (c.moveToNext()){
             int id = c.getInt(0);

             String name =c.getString(1);
             String enroll =c.getString(2);
             String address =c.getColumnName(3);
             String gender =c.getColumnName(4);

             spacecraft =new Spacecraft();
             spacecraft.setId(id);
             spacecraft.setName(name);
             spacecraft.setEnroll(enroll);
             spacecraft.setAddress(address);
             spacecraft.setGender(gender);

             spacecrafts.add(spacecraft);

         }
         dbAdapter.CloseDB();
         listView.setAdapter(adapter);
     }
//update

    private  void  update(String name,String enroll,String address,String gendet){

        int id =adapter.getSelectedItemid();

        DBAdapter dbAdapter =new DBAdapter(this);

        dbAdapter.OpenDB();
        boolean updated =dbAdapter.update(name,enroll,address,gendet,id);
        dbAdapter.CloseDB();
        if (updated){
            sname.setText(name);
            senroll.setText(enroll);
            saddress.setText(address);
            sgender.setText(gendet);

            getSpacecraft();
        }else {
            Toast.makeText(this, "Unable to Updtae", Toast.LENGTH_SHORT).show();
        }

    }

//delete

        private  void  delete(){

        int id =adapter.getSelectedItemid();

        DBAdapter dbAdapter =new DBAdapter(this);

        dbAdapter.OpenDB();
        boolean deleted =dbAdapter.delete(id);
        dbAdapter.CloseDB();

        if (deleted){
            getSpacecraft();
        }
        else {
            Toast.makeText(this, "unable to delete", Toast.LENGTH_SHORT).show();
        }
        }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        CharSequence title=item.getTitle();
        if (title == "New"){
            displayDailog(!forupdate);

        }else if (title =="Edit"){
            displayDailog(!forupdate);
        }else if (title=="Delete"){
            delete();
        }
        return super.onContextItemSelected(item);
    }
}
