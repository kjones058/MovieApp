package starbuzz.hfad.com.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    private TextView description;
    private TextView cast;
    private TextView crew;
    private ImageView similarMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        wireWidgets();
    }

    private void wireWidgets() {
        description = findViewById(R.id.textView_description_content);
        cast = findViewById(R.id.textView_cast_content);
        crew = findViewById(R.id.textView_crew_content);
        similarMovie = findViewById(R.id.imageView_similarmovie_content);
    }
}
