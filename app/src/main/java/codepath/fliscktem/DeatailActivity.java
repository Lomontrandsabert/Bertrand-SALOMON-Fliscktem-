package codepath.fliscktem;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import codepath.fliscktem.models.Movie;

public class DeatailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatail);

        ImageView ivImageView = (ImageView) findViewById(R.id.imageView);
        RatingBar rbRating = (RatingBar) findViewById(R.id.rbRating);
        TextView txTitle = (TextView) findViewById(R.id.tvTitle);
        TextView txOverview = (TextView) findViewById(R.id. tvOverview);
        rbRating.setEnabled(false);
        Movie uMovie = (Movie) getIntent().getSerializableExtra("movie");
        uMovie.getPosterPath();
        uMovie.getOriginalTitle();
        uMovie.getOverView();

        Picasso.with(getApplicationContext()).load(uMovie.getPosterPath()).into(ivImageView);
        // return the view

        rbRating.setRating(uMovie.getVote_average());
        txTitle.setText(uMovie.getOriginalTitle().toString());
        txOverview.setText(uMovie.getOverView().toString());
    }
}
