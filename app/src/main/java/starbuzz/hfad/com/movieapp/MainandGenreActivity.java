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

public class MainandGenreActivity extends AppCompatActivity {

    private ListView genrelist;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
