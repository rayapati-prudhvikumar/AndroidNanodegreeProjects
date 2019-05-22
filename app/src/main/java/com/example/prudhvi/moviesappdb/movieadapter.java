package com.example.prudhvi.moviesappdb;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.prudhvi.moviesappdb.allpojos.Result;

import java.util.List;

public class movieadapter extends RecyclerView.Adapter<Movieviewholder> implements View.OnClickListener {
    Context context;
    List<Result> lists;
    //private MovieInfo[] mMovieInfoArray;

    public movieadapter(Context context, List<Result> lists)
    {
        this.context = context;
        this.lists = lists;
    }

    @NonNull
    @Override
    public Movieviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(context).inflate(R.layout.single_entry,
                viewGroup,false);
        Movieviewholder fvh = new Movieviewholder(view);
        view.setOnClickListener(this);
        return fvh;
    }
    @Override
    public void onBindViewHolder(@NonNull Movieviewholder movieviewholder, int i) {
        String s1="http://image.tmdb.org/t/p/w342/"+lists.get(i).getPosterPath();
        //Glide.with(context).load(s1).into(movieviewholder.imageView);

        Glide.with(context).load(s1).into(movieviewholder.imageView);
        movieviewholder.itemView.setTag(i);

    }
    @Override
    public int getItemCount() {
        return lists.size();
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context,Second.class);
        int position = (int) view.getTag();
        String image_url =lists.get(position).getPosterPath();
        String i=lists.get(position).getOverview();
        String i1=lists.get(position).getTitle();
        String i2=lists.get(position).getVoteAverage().toString();
        String i3=lists.get(position).getReleaseDate();
        intent.putExtra("KEY",image_url);
        intent.putExtra("Key1",i);
        intent.putExtra("Key2",i1);
        intent.putExtra("Key3",i2);
        intent.putExtra("Key4",i3);

        context.startActivity(intent);
    }
    }
