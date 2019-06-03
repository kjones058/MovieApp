package starbuzz.hfad.com.movieapp;

import java.util.ArrayList;

public class GenreAndMovie {

    private String genre;
    private ArrayList<Movie> movies;

    public GenreAndMovie(String genre, ArrayList<Movie> movies) {
        this.genre = genre;
        this.movies = movies;
    }

    public GenreAndMovie() {
    }

    @Override
    public String toString() {
        return "GenreAndMovie{" +
                "genre='" + genre + '\'' +
                ", movies=" + movies +
                '}';
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }


    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
