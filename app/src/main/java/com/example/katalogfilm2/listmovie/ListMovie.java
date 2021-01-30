package com.example.katalogfilm2.listmovie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.katalogfilm2.R;
import com.example.katalogfilm2.detailmovie.DetailMovie;
import com.example.katalogfilm2.listmovies.WatchModel;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListWatchAdapter mAdapter;

    private ArrayList<WatchModel> modelList = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findviews();
        setAdapter();

    }

    private void findviews() {
        recyclerView = findViewById(R.id.recycler_view);
    }


    private void setAdapter() {

        modelList.add(new WatchModel(getResources().getString(R.string.title_avengerinfinity), getResources().getString(R.string.overview_avengerinfinity), R.drawable.avangers_infinity));
        modelList.add(new WatchModel(getResources().getString(R.string.title_black_panther), getResources().getString(R.string.overview_black_panther), R.drawable.black_panther));
        modelList.add(new WatchModel(getResources().getString(R.string.title_rampage), getResources().getString(R.string.overview_rampage), R.drawable.rampage));
        modelList.add(new WatchModel(getResources().getString(R.string.title_mission_imposible), getResources().getString(R.string.overview_mission_imposible), R.drawable.mission_imposible));
        modelList.add(new WatchModel(getResources().getString(R.string.title_ready_player_one), getResources().getString(R.string.overview_ready_player_one), R.drawable.ready_player_one));
        modelList.add(new WatchModel(getResources().getString(R.string.title_the_meg), getResources().getString(R.string.overview_the_meg), R.drawable.the_meg));
        modelList.add(new WatchModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.overview_aquaman), R.drawable.aquaman));
        modelList.add(new WatchModel(getResources().getString(R.string.title_jurassic_world), getResources().getString(R.string.overview_jurassic_world), R.drawable.jurasic_world));
        modelList.add(new WatchModel(getResources().getString(R.string.title_incredibles2), getResources().getString(R.string.overview_incredibles2), R.drawable.incredibles2));
        modelList.add(new WatchModel(getResources().getString(R.string.title_deadpool2), getResources().getString(R.string.overview_deadpool2), R.drawable.deadpool2));
        modelList.add(new WatchModel(getResources().getString(R.string.title_star_wars), getResources().getString(R.string.overview_star_wars), R.drawable.solo_stars_wars));
        modelList.add(new WatchModel(getResources().getString(R.string.title_ant_man), getResources().getString(R.string.overview_ant_man), R.drawable.ant_man));
        modelList.add(new WatchModel(getResources().getString(R.string.title_predator), getResources().getString(R.string.overview_predator), R.drawable.predator));
        modelList.add(new WatchModel(getResources().getString(R.string.title_skyscraper), getResources().getString(R.string.overview_skyscreper), R.drawable.skyscraper));
        modelList.add(new WatchModel(getResources().getString(R.string.title_alpha), getResources().getString(R.string.overview_alpha), R.drawable.alpha));
        modelList.add(new WatchModel(getResources().getString(R.string.title_oceans8), getResources().getString(R.string.overview_oceans8), R.drawable.oceans8));
        modelList.add(new WatchModel(getResources().getString(R.string.title_bumblebee), getResources().getString(R.string.overview_bumblebee), R.drawable.bumblebee));
        modelList.add(new WatchModel(getResources().getString(R.string.title_strong), getResources().getString(R.string.overview_strong), R.drawable.strong));
        modelList.add(new WatchModel(getResources().getString(R.string.title_robin_hood), getResources().getString(R.string.overview_robin_hood), R.drawable.robin_hood));
        modelList.add(new WatchModel(getResources().getString(R.string.title_alita_battle_angel), getResources().getString(R.string.overview_alita_battle_angel), R.drawable.alita_battle_angel));

        mAdapter = new ListWatchAdapter(ListMovie.this, modelList);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.SetOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(ListMovie.this, DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE, model);
                startActivity(goToDetailMovie);

            }
        });
    }


}
