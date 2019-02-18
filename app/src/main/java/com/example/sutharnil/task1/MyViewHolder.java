package com.example.sutharnil.task1;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

public class MyViewHolder implements View.OnLongClickListener ,View.OnCreateContextMenuListener {

    TextView name,address,enroll,gender;
    MyLongClickLisneter myLongClickLisneter;
    public  MyViewHolder(View v){

        name =(TextView) v.findViewById(R.id.name);
        enroll =(TextView)v.findViewById(R.id.enroll);
        address=(TextView)v.findViewById(R.id.address);
        gender=(TextView)v.findViewById(R.id.gender);

        v.setOnLongClickListener(this);
        v.setOnCreateContextMenuListener(this);

    }

    @Override
    public boolean onLongClick(View v) {
       this.myLongClickLisneter.onItemLongClick();
        return false;
    }

    public  void  setMyLongClickLisneter(MyLongClickLisneter longClickLisneter){
        this.myLongClickLisneter =longClickLisneter;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Action");
        menu.add(0,0,0,"New");
        menu.add(0,1,0,"Edit");
        menu.add(0,2,0,"Delete");
    }
}
