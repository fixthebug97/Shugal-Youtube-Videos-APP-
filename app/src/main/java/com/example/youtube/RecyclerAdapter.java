package com.example.youtube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<VideoData> data;
    private Context context;
    private ICustomClick iCustomClick;

    public RecyclerAdapter(ArrayList<VideoData> data, Context context,ICustomClick iCustomClick) {
        this.data = data;
        this.context = context;
        this.iCustomClick=iCustomClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler, viewGroup, false);
        final MyViewHolder holder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iCustomClick.onCustomClick(data.get(holder.getAdapterPosition()),view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
holder.channelTitle.setText(data.get(i).getChannel());
        Picasso.with(context).load(data.get(i).getImageUrl()).into(holder.videoImage);
        holder.videoTitle.setText(data.get(i).getTitle());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView videoImage;
        TextView videoTitle;
        TextView channelTitle;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImage=itemView.findViewById(R.id.videoImage);
            videoTitle=itemView.findViewById(R.id.videoTitle);
            channelTitle=itemView.findViewById(R.id.chanelTitle);

        }
    }
}
