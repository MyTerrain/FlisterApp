package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.bumptech.glide.Glide;
import com.example.flisterapp.R;
import com.example.flisterapp.model.Movie;

import java.util.List;

public class MovieAdapters extends RecyclerView.Adapter<MovieAdapters.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapters(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get movie at position
        Movie movie = movies.get(position);
        //Bind movie data into viewHolder
        holder.bind(movie);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPoster;
        TextView tvTitle;
        TextView tvOverview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvOverview = itemView.findViewById(R.id.tvOverview);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverView());

            //Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
           GlideApp.with(context).load(movie.getPosterPath()).into(ivPoster);
           // GlideApp.with(con)

        }
    }

}
