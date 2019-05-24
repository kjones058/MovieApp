package starbuzz.hfad.com.movieapp;

import android.graphics.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("/movie/{movie_id}/reviews/videos/release_dates/credits")
    Call<List<Movie>> getMovieById(@Path("movie_id") String id, @Query("api_key") String key);

    Call<List<Poster>> getPosterpath(@Path("poster_path") String path, @Query("api_key") String key);



}
