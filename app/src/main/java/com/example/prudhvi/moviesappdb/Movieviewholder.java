package com.example.prudhvi.moviesappdb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

class Movieviewholder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public Movieviewholder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
