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
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        ArrayList<Movie> movies;
        wireWidgets();
        searchMovies();

//        movieGrid.setAdapter(new GridviewAdapter(this, ArrayList<Movie> movies));

       // textViewMovieTitle.setOnClickListener(this);

//        movieTitle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String textView = movieTitle.getText().toString();
//                Intent intenttextview = new Intent(MovieActivity.this, Content.class);
//                startActivity(intenttextview);
//            }
//        });
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_movie);
//
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

    }



    private void wireWidgets(){
       // movieTitle = findViewById(R.id.textView_movieactivity_movieTitle);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

    }
    private List<Movie> importPoster(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();
        String baseURL = "http://image.tmdb.org/t/p/w185/";
        Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        List<Movie> movieList2 = Arrays.asList(movies);
        Movie movie1 = movies[0];
        Movie movie2 = movies[1];
        Movie movie3 = movies[2];
        Movie movie4 = movies[3];
        Movie movie5 = movies[4];
        Movie movie6 = movies[5];
        Movie movie7 = movies[6];
        Movie movie8 = movies[7];
        Movie movie9 = movies[8];

        Picasso.get().load(baseURL+ movie1.getPoster_path()).into(imageView1);
        Picasso.get().load(baseURL+ movie2.getPoster_path()).into(imageView2);
        Picasso.get().load(baseURL+ movie3.getPoster_path()).into(imageView3);
        Picasso.get().load(baseURL+ movie4.getPoster_path()).into(imageView4);
        Picasso.get().load(baseURL+ movie5.getPoster_path()).into(imageView5);
        Picasso.get().load(baseURL+ movie6.getPoster_path()).into(imageView6);
        Picasso.get().load(baseURL+ movie7.getPoster_path()).into(imageView7);
        Picasso.get().load(baseURL+ movie8.getPoster_path()).into(imageView8);
        Picasso.get().load(baseURL+ movie9.getPoster_path()).into(imageView9);

        return movieList2;
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .build();
        MovieService service = retrofit.create(MovieService.class);
        Call<List<Movie>> movies = service.getMovieById("", Credentials.API_KEY);
//        Call<List<Poster>> poster_path = service.getPosterpath("", Credentials.API_KEY);
//        movies.request(android.graphics.Movie.class);
    }


    private List<GenreAndMovie> assignId(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        GenreAndMovie[] movies = gson.fromJson(jsonString, GenreAndMovie[].class);
        List<GenreAndMovie> movieList = Arrays.asList(movies);

        Log.d("MOVIEHOPEITWORKS", movieList.toString());

        return movieList;

//        movieContent = new MovieContent(movieList);
////        movieContent.getInformation();
    }

    private List<MovieDetails> assignDetails(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        MovieDetails[] details = gson.fromJson(jsonString, MovieDetails[].class);
        List<MovieDetails> detailsList = Arrays.asList(details);
        Log.d("DETAILS", detailsList.toString());

        return detailsList;
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
