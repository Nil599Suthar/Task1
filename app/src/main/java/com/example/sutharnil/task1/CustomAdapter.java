package com.example.sutharnil.task1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Spacecraft>  spacecrafts;
    LayoutInflater layoutInflater;
    Spacecraft spacecraft;


    public CustomAdapter(Context c,ArrayList<Spacecraft> spacecrafts){
        this.c=c;
        this.spacecrafts=spacecrafts;
    }
    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null){
            layoutInflater =(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }if (convertView ==null){

            convertView =layoutInflater.inflate(R.layout.student_info_row,parent,false);

        }
        MyViewHolder myViewHolder =new MyViewHolder(convertView);
        myViewHolder.name.setText(spacecrafts.get(position).getName());
        myViewHolder.enroll.setText(spacecrafts.get(position).getEnroll());
        myViewHolder.address.setText(spacecrafts.get(position).getAddress());
        myViewHolder.gender.setText(spacecrafts.get(position).getGender());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, spacecrafts.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.setMyLongClickLisneter(new MyLongClickLisneter() {
            @Override
            public void onItemLongClick() {
                spacecraft =(Spacecraft) getItem(position);
            }
        });
        return convertView;
    }

    public  int getSelectedItemid(){
        return  spacecraft.getId();
    }

    public  String getSelecteditemNAme(){
        return spacecraft.getName();
    }
}
