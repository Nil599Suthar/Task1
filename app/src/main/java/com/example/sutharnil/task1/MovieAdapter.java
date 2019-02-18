package com.example.sutharnil.task1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movieList;
    private Onitemclick mlistener;
    private Context ctx;
    private  String string ="Selected :- ";

    public interface  Onitemclick{
            void  onitemclick(int position);
        }
        public void setOnitemclick(Onitemclick listener){
            mlistener=listener;
        }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title,year,genre;
        public CheckBox checkBox;

        public MyViewHolder(View view, final Onitemclick listener)
        {
            super(view);
            title=(TextView)view.findViewById(R.id.title);
            year=(TextView)view.findViewById(R.id.year);
            genre=(TextView)view.findViewById(R.id.genre);
            checkBox=(CheckBox) view.findViewById(R.id.checkBox);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getAdapterPosition();
                    listener.onitemclick(position);
                }
            });
        }


        @Override
        public void onClick(View v) {

        }
    }
    public MovieAdapter(List<Movie>movieList){
        this.movieList=movieList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row,parent,false);
        return new MyViewHolder(itemview,mlistener);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Movie movie=movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.genre.setText(movie.getGenre());
        holder.checkBox.setChecked(movieList.get(position).isSelected());
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos=(Integer)holder.checkBox.getTag();
                
                if (movieList.get(pos).isSelected()){
                    movieList.get(pos).setSelected(false);
                }else {
                    movieList.get(pos).setSelected(true);

                        string +="\n\n "+movieList.get(pos).getTitle();
                    Toast.makeText(v.getContext(),""+string,Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

}
