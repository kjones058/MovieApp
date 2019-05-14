package starbuzz.hfad.com.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import retrofit2.Retrofit;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class MovieActivity extends AppCompatActivity {

    private MovieContent movieContent;
    private MovieDetails movieDetails;
    private TextView movieTitle;
    private ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        wireWidgets();
        searchMovies();
        Picasso.get().load("http://image.tmdb.org/t/p/w185/").into(moviePoster);

        movieTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textView = movieTitle.getText().toString();
                Intent intenttextview = new Intent(MovieActivity.this, Content.class);
                startActivity(intenttextview);
            }
        });

    }

    private void wireWidgets(){
        movieTitle = findViewById(R.id.textView_movieactivity_movieTitle);
    }
    private void importPoster(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movieIds));
        Gson gson = new Gson();

        Poster[] poster_path = gson.fromJson(jsonString, Poster[].class);
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

        GenreAndMovie[] movies = gson.fromJson(jsonString, GenreAndMovie[].class);
        List<GenreAndMovie> movieList = Arrays.asList(movies);

//        movieContent = new MovieContent(movieList);
//        movieContent.getInformation();
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
