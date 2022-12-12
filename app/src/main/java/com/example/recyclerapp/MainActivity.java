package com.example.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Film> films = new ArrayList<Film>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText movieEdit = (EditText) findViewById(R.id.movie);
        EditText directorEdit = (EditText) findViewById(R.id.director);
        EditText yearEdit = (EditText) findViewById(R.id.year);
        Button add = (Button) findViewById(R.id.add);

        Button edit = findViewById(R.id.edit);

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

                adapter.addFilm(new Film(movie, director, Integer.parseInt(year)));
            }
        });

    }
}