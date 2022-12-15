package com.example.recyclerapp;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Film> films = new ArrayList<Film>();

    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText movieEdit = (EditText) findViewById(R.id.movie);
        EditText directorEdit = (EditText) findViewById(R.id.director);
        EditText yearEdit = (EditText) findViewById(R.id.year);

        Button add = (Button) findViewById(R.id.add);
        Button edit = findViewById(R.id.edit);
        Button delete = findViewById(R.id.delete);

        RecyclerView recycler = findViewById(R.id.recycler);


        Recycler adapter = new Recycler(films);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayoutManager);

        //recycler.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));

        recycler.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                String movie = movieEdit.getText().toString();
                String director = directorEdit.getText().toString();
                String year = yearEdit.getText().toString();

                if (movie.isEmpty() || director.isEmpty() || year.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Rellena los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Film newFilm = new Film(movie, director, Integer.parseInt(year));
                for(Film film:adapter.getFilms()){
                    if(newFilm.equals(film)){
                        return;
                    }

                }
                adapter.addFilm(newFilm);
            }
        });

        adapter.setOnItemClick(new Recycler.OnItemClick() {
            @Override
            public void getPosition(int pos) {
                position = pos;

                Film film = adapter.getFilms().get(pos);

                movieEdit.setText(film.getMovie());
                directorEdit.setText(film.getDirector());
                yearEdit.setText("" + film.getYear());

                Toast.makeText(getApplicationContext(),"Item Postion::"+pos,Toast.LENGTH_SHORT).show();
            }
        });


        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String movie = movieEdit.getText().toString();
                String director = directorEdit.getText().toString();
                String year = yearEdit.getText().toString();

                if (movie.isEmpty() || director.isEmpty() || year.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Rellena los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Film newFilm = new Film(movie, director, Integer.parseInt(year));
                for(Film film:adapter.getFilms()){
                    if(newFilm.equals(film)){
                        return;
                    }

                }
                try {
                    adapter.editFilm(newFilm, position );
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error en editar", Toast.LENGTH_SHORT).show();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.removeFilm(position);
            }
        });
    }
}