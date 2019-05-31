package starbuzz.hfad.com.movieapp;

import android.content.Intent;
import android.net.Uri;
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
import retrofit2.converter.gson.GsonConverterFactory;
import java.net.URI;

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
    private int genre;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        genre = getIntent().getIntExtra("genre", 0);

        ArrayList<Movie> movies;
        wireWidgets();
        searchMovies();

//        private int[] images = {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9};
//
//        imageView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//                String item = (String) imageView1.getItemAtPosition(position);
//                Toast.makeText(MovieActivity.this, "You selected : " + item,Toast.LENGTH_SHORT).show();
//
//                Intent intentContent = new Intent( MovieActivity.this, ContentActivity.class);
//                intentContent.putExtra("Movie", position);
//                startActivity(intentContent);
//            }
//        });

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
    private void importPoster(){
//        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
//        Gson gson = new Gson();
        String baseURL = "https://image.tmdb.org/t/p/w185";
        //Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        //Log.d("MOVIES THINGY", "importPoster: " + movies.length);
        List<Movie> movies1 =         assignId().get(genre).getMovies();
        Movie[] movies = movies1.toArray(new Movie[movies1.size()]);

        Movie movie1 = movies[0];
        Movie movie2 = movies[1];
        Movie movie3 = movies[2];
        Movie movie4 = movies[3];
        Movie movie5 = movies[4];
        Movie movie6 = movies[5];
        Movie movie7 = movies[6];
        Movie movie8 = movies[7];
        Movie movie9 = movies[8];

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }

        });
        builder.build().load(baseURL).into(imageView1);

        Picasso.get().load(baseURL+movie1.getPoster_path()).into(imageView1);
        Log.d("MOVIES THINGY", "importPoster: " + (baseURL+ movie2.getPoster_path()));
        Picasso.get().load(baseURL+ movie2.getPoster_path()).into(imageView2);
        Picasso.get().load(baseURL+ movie3.getPoster_path()).into(imageView3);
        Picasso.get().load(baseURL+ movie4.getPoster_path()).into(imageView4);
        Picasso.get().load(baseURL+ movie5.getPoster_path()).into(imageView5);
        Picasso.get().load(baseURL+ movie6.getPoster_path()).into(imageView6);
        Picasso.get().load(baseURL+ movie7.getPoster_path()).into(imageView7);
        Picasso.get().load(baseURL+ movie8.getPoster_path()).into(imageView8);
        Picasso.get().load(baseURL+ movie9.getPoster_path()).into(imageView9);

//        return movieList2;
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
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
