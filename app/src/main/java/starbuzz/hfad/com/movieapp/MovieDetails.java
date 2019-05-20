package starbuzz.hfad.com.movieapp;

public class MovieDetails {
    private String Cast;
    private String Crew;
    private String Trailers;
    private String Reviews;
    private String SimilarMovies;

    public String getCast() {
        return Cast;
    }

    public void setCast(String cast) {
        Cast = cast;
    }

    public String getCrew() {
        return Crew;
    }

    public void setCrew(String crew) {
        Crew = crew;
    }

    public String getTrailers() {
        return Trailers;
    }

    public void setTrailers(String trailers) {
        Trailers = trailers;
    }

    public String getReviews() {
        return Reviews;
    }

    public void setReviews(String reviews) {
        Reviews = reviews;
    }

    public String getSimilarMovies() {
        return SimilarMovies;
    }

    public void setSimilarMovies(String similarMovies) {
        SimilarMovies = similarMovies;
    }
}
