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
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class GridviewAdapter extends  BaseAdapter{
    private Context context;
    private Movie[] movies;
    private static LayoutInflater inflater = null;

    public GridviewAdapter(Context context, Movie[] movies){
        this.context = context;
        this.movies = movies;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount(){
        return movies.length;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Movie getItem(int position){
        return movies[position];
    }

    @Override
    public View getView(int position, View converterView, ViewGroup parent ){
        View itemView = converterView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.grid_item, null) : itemView;
        ImageView imageView = itemView.findViewById(R.id.grid_dynamic);
        //imageView.setImageResource(Picasso.);
       // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
       // imageView.setLayoutParams(new GridView.LayoutParams(70, 70));

        //Movie selectedMovie = movies.get(position);
        Picasso.get().load("http://image.tmdb.org/t/p/w185/").into(imageView);
        //selectedMovie.setOnCl
        //imageViewMovie.setImageResource(selectedMovie.getPosterPath() );
        return itemView;
    }
}
