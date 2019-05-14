package starbuzz.hfad.com.movieapp;

import android.graphics.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/{id}")
    Call<List<Movie>> getMovieById(@Path("id") int id, @Query("api_key") String key);

    Call<List<Poster>> getPosterpath(@Path("poster_path") String path, @Query("api_key") String key);
}
