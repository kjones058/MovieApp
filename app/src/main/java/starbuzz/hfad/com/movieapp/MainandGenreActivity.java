package starbuzz.hfad.com.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.Gson;
import retrofit2.Retrofit;

public class MainandGenreActivity extends AppCompatActivity {

    private ListView genrelist;
    private ArrayList<String> list;
    private String API_KEY = "0bd70a2fbc2eccd47cf0105a9cfbb6cc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchMovies();
        list = new ArrayList<>();
        genrelist = findViewById(R.id.listView_genre_mainandgenre);

        list.add("Romance");
        list.add("Comedy");
        list.add("Horror/Thriller");
        list.add("Fantasy/Science Fiction");
        list.add("Drama");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        genrelist.setAdapter(arrayAdapter);



        genrelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                String item = (String) genrelist.getItemAtPosition(position);
                Toast.makeText(MainandGenreActivity.this, "You selected : " + item,Toast.LENGTH_SHORT).show();

                Intent intentMovies = new Intent(MainandGenreActivity.this, MovieActivity.class);
                startActivity(intentMovies);


            }
        });
    }


    private void searchMovies() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieService service = retrofit.create(MovieService.class);
    }

}
