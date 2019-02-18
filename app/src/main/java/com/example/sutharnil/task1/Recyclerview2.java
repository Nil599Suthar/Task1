package com.example.sutharnil.task1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recyclerview2 extends AppCompatActivity  {

    private List<Actor> actorList=new ArrayList<>();
        int flag1 =1;
    private ActorAdapter adapter,adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview2);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview2);

        adapter=new ActorAdapter(actorList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
       // recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        adapter.setOnitemclick(new ActorAdapter.Onitemclick() {
            @Override
            public void onitemclick(int position) {
                Actor actor=actorList.get(position);

                Toast.makeText(Recyclerview2.this, "Selected :-"+actor.getActor_name() , Toast.LENGTH_SHORT).show();


            }
        });

        adapter.setOnitem1click(new ActorAdapter.Onitem1click() {
            @Override
            public void onitem1click(int position) {
                Actor actor=actorList.get(position);

                Toast.makeText(Recyclerview2.this, "Selected :-"+actor.getGenre() , Toast.LENGTH_SHORT).show();

            }
        });

        adapter.setOnitem2click(new ActorAdapter.Onitem2click() {
            @Override
            public void onitem2click(int position) {
                Actor actor=actorList.get(position);

                Toast.makeText(Recyclerview2.this, "Selected :-" + actor.getImage_id() + " "+actor.getActor_name() , Toast.LENGTH_SHORT).show();

            }
        });


      int[] imageid=new int[]{R.drawable.salamankhan,R.drawable.srk,R.drawable.anil,R.drawable.amithabh,R.drawable.amir,R.drawable.ajay,R.drawable.salamankhan,R.drawable.srk,R.drawable.anil,R.drawable.amithabh,R.drawable.salamankhan,R.drawable.srk,R.drawable.anil,R.drawable.amithabh,R.drawable.amir,R.drawable.ajay,R.drawable.salamankhan,R.drawable.srk,R.drawable.anil,R.drawable.amithabh} ;
        String[] a={"Salman Khan","","Sahrukh Khan","","Anil Kapoor","","Amitabh Bachchan","","Amir Khan","","Ajay Devgn","","Salman Khan","","Sahrukh Khan","","Anil Kapoor","","Amitabh Bachchan",""};
        for (int i=0;i<20;i++){

                Actor actor=new Actor(""+a[i],"Drama",imageid[i],"100","120");
                actorList.add(actor);

        }

        adapter.notifyDataSetChanged();

    }

}

