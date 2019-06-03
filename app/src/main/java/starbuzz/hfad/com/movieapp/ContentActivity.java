package starbuzz.hfad.com.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Retrofit;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import retrofit2.converter.gson.GsonConverterFactory;

public class ContentActivity extends AppCompatActivity {

    private TextView description;
    private TextView cast;
    private TextView director;
    private ImageView similarMovie;
    private int id;
    private Movie[] movie;
    private URL url;
    private HttpURLConnection urlConnection;
    private BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        wireWidgets();
        searchMovies();
        assignContent();
        importInfo();
    }

    private void wireWidgets() {
        description = findViewById(R.id.textView_description_content);
        cast = findViewById(R.id.textView_cast_content);
        director = findViewById(R.id.textView_director_content);
        similarMovie = findViewById(R.id.imageView_similarmovie_content);

        //description.setText(movie.getDescription());
    }

    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieService service = retrofit.create(MovieService.class);
        Call<List<Movie>> movies = service.getMovieById("", Credentials.API_KEY);



    }

    private void importInfo(){

        List<Movie> movies1 =  assignContent().get(id).getMovieId();
        movie = movies1.toArray(new Movie[movies1.size()]);

        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);

//        try {
//            JSONArray jArray = new JSONArray(readJSONFromAsset());
//            for (int i = 0; i < movies1; ++i) {
//                 description = jArray.getJSONObject(i).toString("name");// name of the country
//                 cast = jArray.getJSONObject(i).setString("dial_code"); // dial code of the country
//                 director = jArray.getJSONObject(i).getString("code"); // code of the country
//
//            }
//        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
     }

        public String readJSONFromAsset() {
            String json = null;
            try {
                InputStream is = getAssets().open("movie.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }






    private List<Movie> assignContent(){
        String jsonString = readTextFile(getResources().openRawResource(R.raw.movie));
        Gson gson = new Gson();

        Movie[] movies = gson.fromJson(jsonString, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);

        Log.d("Content", movieList.toString());

        return movieList;

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
