package starbuzz.hfad.com.movieapp;

import com.squareup.picasso.Picasso;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridviewAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Movie> movies;
    private static LayoutInflater inflater = null;

    public GridviewAdapter(Context context, ArrayList<Movie> movies){
        this.context = context;
        this.movies = movies;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return movies.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Movie getItem(int position){
        return movies.get(position);
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent ){
        View itemView = converterView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.activity_movie, null) : itemView;
        ImageView imageViewMovie = itemView.findViewById(R.id.imageViewMovie);
        TextView textViewMovieTitle = itemView.findViewById(R.id.textViewMovieTitle);
        //Movie selectedMovie = movies.get(position);
        Picasso.get().load("http://image.tmdb.org/t/p/w185/").into(imageViewMovie);
        //selectedMovie.setOnCl
        //imageViewMovie.setImageResource(selectedMovie.getPosterPath() );
        return itemView;
    }
}
