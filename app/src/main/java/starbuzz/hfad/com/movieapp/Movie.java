package starbuzz.hfad.com.movieapp;

public class Movie {
    private String id;
    private String movie;
    private String poster_path;

    public Movie (){

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

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movie='" + movie + '\'' +
                ", poster_path='" + poster_path + '\'' +
                '}';
    }
}
