package com.example.sutharnil.task1;

import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Collaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collaps);
//
//        ConstraintLayout constraint =(ConstraintLayout)findViewById(R.id.root1);
//        ConstraintSet constraintSet= new ConstraintSet();
//        constraintSet.clone(Collaps.this,R.layout.activity_collaps_2page);
//     //   setContentView(R.layout.activity_collaps);
//        constraintSet.applyTo(constraint);

        Button A1=(Button)findViewById(R.id.A1);
        Button A2=(Button)findViewById(R.id.A2);
        Button A3=(Button)findViewById(R.id.A3);
        Button A4=(Button)findViewById(R.id.A4);
        Button A5=(Button)findViewById(R.id.A5);

        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Collaps.this);
                builder.setTitle("AlertDailog Box");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Yes Click", Toast.LENGTH_SHORT).show();
                      //  dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "No Click", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Ok Click", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Collaps.this);
                builder.setTitle("AlertDailog Box with List Items");
                builder.setCancelable(false);
                String[] animals={"Horse","Cow","Sheep","Goat"};
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Yes Click", Toast.LENGTH_SHORT).show();
                        //  dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "No Click", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                builder.setItems(animals, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Toast.makeText(Collaps.this, "Horse", Toast.LENGTH_SHORT).show();

                                break;
                            case 1:
                                Toast.makeText(Collaps.this, "Cow", Toast.LENGTH_SHORT).show();

                                break;
                                case 3:
                                    Toast.makeText(Collaps.this, "Sheep", Toast.LENGTH_SHORT).show();

                                    break;
                                case 4:
                                    Toast.makeText(Collaps.this, "Goat", Toast.LENGTH_SHORT).show();

                                    break;
                        }
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });

        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Collaps.this);
                builder.setTitle("AlertDailog Box with Radio Button Items");
                builder.setCancelable(false);
                String[] animals={"Horse","Cow","Sheep","Goat"};
                int checkedItem =3;
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Yes Click", Toast.LENGTH_SHORT).show();
                        //  dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "No Click", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                builder.setSingleChoiceItems(animals, checkedItem,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                Toast.makeText(Collaps.this, "Horse", Toast.LENGTH_SHORT).show();

                                break;
                            case 1:
                                Toast.makeText(Collaps.this, "Cow", Toast.LENGTH_SHORT).show();

                                break;
                            case 3:
                                Toast.makeText(Collaps.this, "Sheep", Toast.LENGTH_SHORT).show();

                                break;
                            case 4:
                                Toast.makeText(Collaps.this, "Goat", Toast.LENGTH_SHORT).show();

                                break;
                        }
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });

        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Collaps.this);
                builder.setTitle("AlertDailog Box with CheckBox List Items");
                builder.setCancelable(false);
                String[] animals={"Horse","Cow","Sheep","Goat"};
                boolean[] checked={true,false,false,true,false};
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Yes Click", Toast.LENGTH_SHORT).show();
                        //  dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "No Click", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });

                builder.setMultiChoiceItems(animals,checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,boolean ischaked) {
                        switch (which){
                            case 0:
                                Toast.makeText(Collaps.this, "Horse", Toast.LENGTH_SHORT).show();

                                break;
                            case 1:
                                Toast.makeText(Collaps.this, "Cow", Toast.LENGTH_SHORT).show();

                                break;
                            case 3:
                                Toast.makeText(Collaps.this, "Sheep", Toast.LENGTH_SHORT).show();

                                break;
                            case 4:
                                Toast.makeText(Collaps.this, "Goat", Toast.LENGTH_SHORT).show();

                                break;
                        }
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });

        A5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(Collaps.this);
                builder.setTitle("AlertDailog Box");
                builder.setCancelable(false);
                final View view=getLayoutInflater().inflate(R.layout.activity_collaps_2page,null);
                builder.setView(view);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText=(EditText)view.findViewById(R.id.et1);

                        Toast.makeText(Collaps.this, "Text :- "+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Collaps.this, "Yes Click", Toast.LENGTH_SHORT).show();
                        //  dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "No Click", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();

                    }
                });
                builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Collaps.this, "Ok Click", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
}
