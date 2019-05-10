package starbuzz.hfad.com.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MovieActivity extends AppCompatActivity {

    private TextView movieTitle;
    private ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        searchMovies();
        Picasso.get().load("http://image.tmdb.org/t/p/w185/").into(moviePoster);

    }

    private void importPoster(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movieIds));
        Gson gson = new Gson();

        Poster[] movies = gson.fromJson(jsonString, Poster[].class);
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .build();
        MovieService service = retrofit.create(MovieService.class);
    }

    private void assignId(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movieIds));
        Gson gson = new Gson();
    }


    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

}
