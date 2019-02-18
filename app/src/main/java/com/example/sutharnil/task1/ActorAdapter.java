package com.example.sutharnil.task1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private List<Actor> actorList;
    private clicklsn clicklsn;
    private ActorAdapter.Onitemclick mlistener;
    private Onitem1click mlistener1;
    private Onitem2click mlistener2;
    private final static int FADE_DURATION = 500; //FADE_DURATION in milliseconds

    //1
    public interface Onitemclick {
        void onitemclick(int position);
    }

    public void setOnitemclick(ActorAdapter.Onitemclick listener) {
        mlistener = listener;
    }

    //2
    public interface Onitem1click {
        void onitem1click(int position);
    }

    public void setOnitem1click(ActorAdapter.Onitem1click listener) {
        mlistener1 = listener;
    }

    //3
    public interface Onitem2click {
        void onitem2click(int position);
    }

    public void setOnitem2click(ActorAdapter.Onitem2click listener) {
        mlistener2 = listener;
    }

    public ActorAdapter(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public interface clicklsn {
        void onViewClick(String name);
    }

    @Override
    public int getItemViewType(int position) {
        // Actor item = actorList.get(position);
        if (position % 2 == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_ONE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_row_1, parent, false);
            return new MyViewHolder1(view, mlistener, mlistener1, mlistener2);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_row_2, parent, false);
            return new MyViewHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:
                initMyViewHolder1((MyViewHolder1) holder, position);
                break;
            case TYPE_TWO:
                initMyViewHolder2((MyViewHolder2) holder, position);
                break;
            default:
                break;
        }
        setScaleAnimation(holder.itemView);
    }

    private void initMyViewHolder1(MyViewHolder1 holder, int pos) {
        Actor actor = actorList.get(pos);
        holder.actor_name.setText(actor.getActor_name());
        holder.actor_genre.setText(actor.getGenre());
        holder.actor_image.setImageResource(actor.getImage_id());
    }

    private void initMyViewHolder2(MyViewHolder2 holder, int pos) {
        Actor actor = actorList.get(pos);
        holder.actor_h.setText(actor.getHeight());
        holder.actor_w.setText(actor.getWeight());
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView actor_name, actor_genre;
        public ImageView actor_image;

        public MyViewHolder1(View itemView, Onitemclick mlistener, Onitem1click mlistener1, Onitem2click mlistener2) {
            super(itemView);
            actor_name = itemView.findViewById(R.id.actor_name);
            actor_genre = itemView.findViewById(R.id.actor_genre);
            actor_image = itemView.findViewById(R.id.actor_image);


            //
            actor_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ActorAdapter.this.mlistener.onitemclick(position);
                }
            });
            actor_genre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ActorAdapter.this.mlistener1.onitem1click(position);
                }
            });
            actor_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    ActorAdapter.this.mlistener2.onitem2click(position);
                }
            });
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView actor_h, actor_w;

        public MyViewHolder2(View itemView) {
            super(itemView);
            actor_h = (TextView) itemView.findViewById(R.id.actor_height);
            actor_w = (TextView) itemView.findViewById(R.id.actor_weight);


        }
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
}