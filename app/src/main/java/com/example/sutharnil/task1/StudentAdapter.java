package com.example.sutharnil.task1;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private  DatabaseHelper databaseHelper;
    private List<Student_info> student_infoList;
    private  StudentAdapter studentAdapter;
    private  Context c;
    private Student_info student_info;




    public StudentAdapter(Context c, List<Student_info> student_infoList) {
        this.c=c;
        this.student_infoList=student_infoList;
    }




    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final StudentAdapter.ViewHolder holder, final int position) {

        student_info = student_infoList.get(position);

        holder.name.setText(student_info.getS_name());
        holder.address.setText(student_info.getS_address());
        holder.enroll.setText(student_info.getS_enroll());
        holder.gender.setText(student_info.getS_gender());

//            holder.setMyLongClickLisneter(new MyLongClickLisneter() {
//                @Override
//                public void onItemLongClick() {
//
//                 //   Toast.makeText(c, " "+student_info.getS_name(), Toast.LENGTH_SHORT).show();
//
//                }
//
//
//            });

    }

    private Object getItem(int position) {
        return student_infoList.get(position);
    }

    @Override
    public int getItemCount() {
        return student_infoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener  {
        public TextView name,address,enroll,gender;
        MyLongClickLisneter myLongClickLisneter;

        public ViewHolder(final View itemView) {
            super(itemView);

            name=(TextView) itemView.findViewById(R.id.name);
            address= (TextView)itemView.findViewById(R.id.address);
            enroll=(TextView) itemView.findViewById(R.id.enroll);
            gender=(TextView) itemView.findViewById(R.id.gender);

           itemView.setOnLongClickListener(this);
         //  itemView.setOnCreateContextMenuListener(this);


        }
        @Override
        public boolean onLongClick(View v) {
            this.myLongClickLisneter.onItemLongClick();
            return false;
        }

        public  void  setMyLongClickLisneter(MyLongClickLisneter longClickLisneter){
            this.myLongClickLisneter =longClickLisneter;
        }


//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//           // menu.setHeaderTitle("Action");
//
//            menu.add(0,1,0,"Edit");
//            menu.add(0,2,0,"Delete");
//        }
    }



}
