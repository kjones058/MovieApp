package starbuzz.hfad.com.movieapp;

import java.util.ArrayList;
import java.util.Arrays;
public class Movie {
    private String id;
    private String movie;
    private String poster_path;
    private String description;
    private String cast;
    private String director;
    private String runtime;
    private ArrayList<Movie> movieId;
//    private Arrays Movie;

    public Movie (){
//        Movie = [9];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public ArrayList<Movie> getMovieId() {
        return movieId;
    }

    public void setMovieId(ArrayList<Movie> movieId) {
        this.movieId = movieId;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movie='" + movie + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", description='" + description + '\'' +
                ", cast='" + cast + '\'' +
                ", director='" + director + '\'' +
                ", runtime='" + runtime + '\'' +
                ", movieId=" + movieId +
                '}';
    }
}
