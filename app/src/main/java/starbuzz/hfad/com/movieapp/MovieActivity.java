package starbuzz.hfad.com.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Retrofit;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        searchMovies();
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3")
                .build();

    }
}
