package starbuzz.hfad.com.movieapp;

public class MovieDetails {
    private String Description;
    private String Cast;
    private String Crew;
    private String Trailers;
    private String Reviews;
    private String SimilarMovies;

    public MovieDetails(String cast, String crew, String description, String trailers, String reviews, String similarMovies) {
        Cast = cast;
        Crew = crew;
        Description = description;
        Trailers = trailers;
        Reviews = reviews;
        SimilarMovies = similarMovies;
    }

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    @Override
    public String toString() {
        return "MovieDetails{" +
                "Description='" + Description + '\'' +
                ", Cast='" + Cast + '\'' +
                ", Crew='" + Crew + '\'' +
                ", Trailers='" + Trailers + '\'' +
                ", Reviews='" + Reviews + '\'' +
                ", SimilarMovies='" + SimilarMovies + '\'' +
                '}';
    }
}
