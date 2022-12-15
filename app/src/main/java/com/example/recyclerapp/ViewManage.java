package com.example.recyclerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ViewManage extends RecyclerView.ViewHolder {
    private TextView  movie, director, year;


    ViewManage(@NonNull View itemView) {
        super(itemView);
        movie = itemView.findViewById(R.id.movie);
        director = itemView.findViewById(R.id.director);
        year = itemView.findViewById(R.id.year);
    }

    TextView getMovie() {
        return movie;
    }

    TextView getDirector() {
        return director;
    }

    TextView getYearA(){
        return year;
    }

}