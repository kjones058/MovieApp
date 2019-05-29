package starbuzz.hfad.com.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import retrofit2.Call;
import retrofit2.Retrofit;
import com.google.gson.Gson;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MovieActivity extends AppCompatActivity {

//    private MovieContent movieContent;
//    private MovieDetails movieDetails;
    private TextView textViewMovieTitle;
    private ImageView imageViewmovie;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ArrayList<Movie> movies;
        wireWidgets();
        searchMovies();

//        grid.setAdapter(new GridviewAdapter(this, movies));



//            GridView gridview = (GridView) findViewById(R.id.gridview);
//            gridview.setAdapter(new ImageAdapter(this));
//
//            gridview.setOnItemClickListener(new OnItemClickListener() {
//                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                    Toast.makeText(M.this, "" + position, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }

        assignId();
        searchMovies();
        importPoster();
        assignDetails();
        populateGridView();

    }

    private void populateGridView(){
        grid= findViewById(R.id.movieGrid_dynamic);
       // movieGrid.setAdapter(GridviewAdapter);
    }



    private void wireWidgets(){
       // movieTitle = findViewById(R.id.textView_movieactivity_movieTitle);
    }
    private void importPoster(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        Poster[] poster_path = gson.fromJson(jsonString, Poster[].class);
        List<Poster> posterList = Arrays.asList(poster_path);
        Log.d("POSTERS", posterList.toString());
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .build();
        MovieService service = retrofit.create(MovieService.class);
        Call<List<android.graphics.Movie>> movies = service.getMovieById("", Credentials.API_KEY);
        Call<List<Poster>> poster_path = service.getPosterpath("", Credentials.API_KEY);
//        movies.request(android.graphics.Movie.class);


    }


    private void assignId(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        //need to change the array to the movie class bc its the only one with id
        GenreAndMovie[] movies = gson.fromJson(jsonString, GenreAndMovie[].class);
        List<GenreAndMovie> movieList = Arrays.asList(movies);
        Log.d("MOVIEHOPEITWORKS", movieList.toString());


//        movieContent = new MovieContent(movieList);
////        movieContent.getInformation();
    }

    private void assignDetails(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        MovieDetails[] details = gson.fromJson(jsonString, MovieDetails[].class);
        List<MovieDetails> detailsList = Arrays.asList(details);
        Log.d("DETAILS", detailsList.toString());
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
