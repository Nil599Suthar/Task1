package com.example.sutharnil.task1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Recyclerwithdatabase extends AppCompatActivity {

    private List<Student_info> student_infoList=new ArrayList<>();
    String s,s1,s2,s3,s4,s5,s6,s7 ;
   private DatabaseHelper databaseHelper;
    private  StudentAdapter studentAdapter;
    RecyclerView recyclerView;
    private  EditText S_name1,S_address1,S_enroll1,posi,S_name2,S_enroll2,S_address2;
    private RadioButton male,female,male2,female2;
    private  TextView delete,edit,Name,Enroll,Address,Gender;
    int ar;
    String arrr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerwithdatabase);

        Name=(TextView)findViewById(R.id.name);
        Address=(TextView)findViewById(R.id.address);
        Enroll=(TextView)findViewById(R.id.enroll);
        Gender=(TextView)findViewById(R.id.gender);


        databaseHelper =new DatabaseHelper(this);
        student_infoList.addAll(databaseHelper.getAllNotes());

         recyclerView=(RecyclerView)findViewById(R.id.recyclerview3);

        FloatingActionButton fabbutton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        studentAdapter =new StudentAdapter(this,student_infoList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentAdapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, final int position) {

            }

            @Override
            public void onLongClick(View view, int position) {
                showActionsDialog(position);
            }
        }));
        fabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNoteDialog(false, null, -1);
            }
        });


        SnapHelper startSnapHelper = new StartSnapHelper();
        startSnapHelper.attachToRecyclerView(recyclerView);

        studentAdapter.notifyDataSetChanged();


    }

    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose One");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showupdateDialog(true, student_infoList.get(position), position);
                } else {
                    deleteNote(position);
                }
            }
        });
        builder.show();
    }

    private void showNoteDialog(final boolean shouldUpdate, final Student_info note, final int position){

        AlertDialog.Builder builder=new AlertDialog.Builder(Recyclerwithdatabase.this);
        builder.setTitle("Fillup Details");
        builder.setCancelable(false);
        final View view=getLayoutInflater().inflate(R.layout.student_info,null);
        S_name1 =(EditText)view.findViewById(R.id.s_name);
        S_enroll1 =(EditText)view.findViewById(R.id.s_enroll);
        S_address1 =(EditText)view.findViewById(R.id.s_address);
        final RadioGroup gender =(RadioGroup)view.findViewById(R.id.rg_gender);
        male =(RadioButton)view.findViewById(R.id.rb_male);
        female =(RadioButton)view.findViewById(R.id.rb_female);
        Button ok = (Button)view.findViewById(R.id.submit);


        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        alertDialog.show();


            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (male.isChecked()) {

                        s = male.getText().toString();
                        s1 = S_name1.getText().toString();
                        s2 = S_address1.getText().toString();
                        s3 = S_enroll1.getText().toString();

                        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()){
                            Toast.makeText(Recyclerwithdatabase.this, "Feel up data", Toast.LENGTH_SHORT).show();
                        }else {
                            createNote(s1, s2, s3, s);
                            alertDialog.cancel();

                        }
                        // Toast.makeText(Recyclerwithdatabase.this, ""+s, Toast.LENGTH_SHORT).show();

                    } else if (female.isChecked()) {
                        s = female.getText().toString();
                        s1 = S_name1.getText().toString();
                        s2 = S_address1.getText().toString();
                        s3 = S_enroll1.getText().toString();
                        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()){
                            Toast.makeText(Recyclerwithdatabase.this, "Feel up data", Toast.LENGTH_SHORT).show();
                        }else {
                            createNote(s1, s2, s3, s);

                            alertDialog.cancel();

                        }

                    }else{
                        Toast.makeText(Recyclerwithdatabase.this, "Feel Up All Data", Toast.LENGTH_SHORT).show();
                    }


                }
            });



        }

    private void showupdateDialog(boolean b, Student_info student_info, final int position) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Recyclerwithdatabase.this);
        builder.setTitle("Fillup Details");
        builder.setCancelable(true);
        final View view=getLayoutInflater().inflate(R.layout.student_info3,null);
        S_name2 =(EditText)view.findViewById(R.id.s_name1);
        S_enroll2 =(EditText)view.findViewById(R.id.s_enroll1);
        S_address2 =(EditText)view.findViewById(R.id.s_address1);

        Button ok = (Button)view.findViewById(R.id.submit);


        builder.setView(view);
        final AlertDialog alertDialog =builder.create();
        alertDialog.show();

       S_name2.setText(student_info.getS_name());
       S_enroll2.setText(student_info.getS_enroll());
       S_address2.setText(student_info.getS_address());

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                s1 = S_name2.getText().toString();
                s3 = S_address2.getText().toString();
                s2 = S_enroll2.getText().toString();

                if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                    Toast.makeText(Recyclerwithdatabase.this, "Feel up data", Toast.LENGTH_SHORT).show();
                } else {
                    updateNote(s1, s2, s3, position);

                    alertDialog.cancel();

                }
                // Toast.makeText(Recyclerwithdatabase.this, ""+s, Toast.LENGTH_SHORT).show();
            }

        });
}


    private void createNote(String name,String enroll ,String address,String gender) {
        // inserting note in db and getting
        // newly inserted note id
        long id = databaseHelper.insertNote(name,enroll,address,gender);

        // get the newly inserted note from db
        Student_info n = databaseHelper.getNote(id);

        if (n != null) {
            // adding new note to array list at 0 position
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
            student_infoList.add(0, n);

            // refreshing the list
            studentAdapter.notifyDataSetChanged();


        }
    }


    private void updateNote(String name,String enroll,String address, int position) {
        Student_info n = student_infoList.get(position);
        // updating note text
        n.setS_name(name);
        n.setS_enroll(enroll);
        n.setS_address(address);
      //  n.setS_gender(gender);
        // updating note in db
        databaseHelper.updateNote(n);

        // refreshing the list
        student_infoList.set(position, n);
        studentAdapter.notifyItemChanged(position);
        Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();

      //  toggleEmptyNotes();
    }

    /**
     * Deleting note from SQLite and removing the
     * item from the list by its position
     */
    private void deleteNote(int position) {
        // deleting the note from db
        databaseHelper.deleteNote(student_infoList.get(position));

        // removing the note from the list
        student_infoList.remove(position);
        studentAdapter.notifyItemRemoved(position);
        Toast.makeText(this, "Data Removed", Toast.LENGTH_SHORT).show();

     //   toggleEmptyNotes();
    }
}

