package com.example.recyclerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<ViewManage> {
    private List<Film> films;


    public Recycler(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
        this.notifyItemInserted(this.films.size() - 1);
    }


    public void removeFilm(int pos) {
        if (pos < 0 || pos >= this.getItemCount()) return;
        this.films.remove(pos);
        this.notifyItemRemoved(pos);
    }

    public void editFilm(Film film, int pos){
        this.films.get(pos).setDirector(film.getDirector());
        this.films.get(pos).setMovie(film.getMovie());
        this.films.get(pos).setYear(film.getYear());
        this.notifyItemChanged(pos);
    }


    @NonNull
    @Override
    public ViewManage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.content, parent, false);
        final ViewManage viewHolder = new ViewManage(vista);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewManage holder, int position) {
        Film film = this.films.get(position);
        holder.getMovie().setText(film.getMovie());
        holder.getDirector().setText(String.valueOf(film.getDirector()));

        holder.getYearA().setText(String.valueOf(film.getYear()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.getPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.films.size();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos); //pass any things
    }
}
