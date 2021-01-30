package com.example.katalogfilm2.detailmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katalogfilm2.R;
import com.example.katalogfilm2.listmovie.ListMovie;
import com.example.katalogfilm2.listmovies.WatchModel;

public class DetailMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvOverView = findViewById(R.id.tv_txt_overview);

        ImageView imgPoster = findViewById(R.id.img_poster);
        WatchModel watchModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);

        tvTitle.setText(watchModel.getTitle());
        tvOverView.setText(watchModel.getOverview());
        imgPoster.setImageResource(watchModel.getPoster());
        setTitle(watchModel.getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
