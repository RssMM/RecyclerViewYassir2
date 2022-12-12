package com.example.recyclerapp;

public class Film {
    private String movie;
    private String director;
    private int year;

    public Film(String movie, String director, int year) {
        this.movie = movie;
        this.director = director;
        this.year = year;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "movie='" + movie + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                '}';
    }
}
