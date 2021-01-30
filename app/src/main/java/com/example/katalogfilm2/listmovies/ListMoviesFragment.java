package com.example.katalogfilm2.listmovies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.katalogfilm2.R;
import com.example.katalogfilm2.detailmovie.DetailMovie;
import com.example.katalogfilm2.listmovie.ListMovie;
import com.example.katalogfilm2.listmovie.ListWatchAdapter;

public class ListMoviesFragment extends Fragment {

    private ListMoviesViewModel mViewModel;
    private ListWatchAdapter mAdapter;

    public static ListMoviesFragment newInstance() {
        return new ListMoviesFragment();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_movie_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        mViewModel = ViewModelProviders.of(this).get(ListMoviesViewModel.class);

        mViewModel.addMovieModel(getResources().getString(R.string.title_avengerinfinity), getString(R.string.overview_avengerinfinity), R.drawable.avangers_infinity);
        mViewModel.addMovieModel(getResources().getString(R.string.title_black_panther), getResources().getString(R.string.overview_black_panther), R.drawable.black_panther);
        mViewModel.addMovieModel(getResources().getString(R.string.title_rampage), getResources().getString(R.string.overview_rampage), R.drawable.rampage);
        mViewModel.addMovieModel(getResources().getString(R.string.title_mission_imposible), getResources().getString(R.string.overview_mission_imposible), R.drawable.mission_imposible);
        mViewModel.addMovieModel(getResources().getString(R.string.title_ready_player_one), getResources().getString(R.string.overview_ready_player_one), R.drawable.ready_player_one);
        mViewModel.addMovieModel(getResources().getString(R.string.title_the_meg), getResources().getString(R.string.overview_the_meg), R.drawable.the_meg);
        mViewModel.addMovieModel(getResources().getString(R.string.title_aquaman), getResources().getString(R.string.overview_aquaman), R.drawable.aquaman);
        mViewModel.addMovieModel(getResources().getString(R.string.title_jurassic_world), getResources().getString(R.string.overview_jurassic_world), R.drawable.jurasic_world);
        mViewModel.addMovieModel(getResources().getString(R.string.title_incredibles2), getResources().getString(R.string.overview_incredibles2), R.drawable.incredibles2);
        mViewModel.addMovieModel(getResources().getString(R.string.title_deadpool2), getResources().getString(R.string.overview_deadpool2), R.drawable.deadpool2);
        mViewModel.addMovieModel(getResources().getString(R.string.title_star_wars), getResources().getString(R.string.overview_star_wars), R.drawable.solo_stars_wars);
        mViewModel.addMovieModel(getResources().getString(R.string.title_ant_man), getResources().getString(R.string.overview_ant_man), R.drawable.ant_man);
        mViewModel.addMovieModel(getResources().getString(R.string.title_predator), getResources().getString(R.string.overview_predator), R.drawable.predator);
        mViewModel.addMovieModel(getResources().getString(R.string.title_skyscraper), getResources().getString(R.string.overview_skyscreper), R.drawable.skyscraper);
        mViewModel.addMovieModel(getResources().getString(R.string.title_alpha), getResources().getString(R.string.overview_alpha), R.drawable.alpha);
        mViewModel.addMovieModel(getResources().getString(R.string.title_oceans8), getResources().getString(R.string.overview_oceans8), R.drawable.oceans8);
        mViewModel.addMovieModel(getResources().getString(R.string.title_bumblebee), getResources().getString(R.string.overview_bumblebee), R.drawable.bumblebee);
        mViewModel.addMovieModel(getResources().getString(R.string.title_strong), getResources().getString(R.string.overview_strong), R.drawable.strong);
        mViewModel.addMovieModel(getResources().getString(R.string.title_robin_hood), getResources().getString(R.string.overview_robin_hood), R.drawable.robin_hood);
        mViewModel.addMovieModel(getResources().getString(R.string.title_alita_battle_angel), getResources().getString(R.string.overview_alita_battle_angel), R.drawable.alita_battle_angel);

        mAdapter = new ListWatchAdapter(view.getContext(), mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.SetOnItemClickListener(new ListWatchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(view.getContext(), DetailMovie.class);
                goToDetailMovie.putExtra(ListMovie.SELECTED_MOVIE, model);
                startActivity(goToDetailMovie);
            }
        });
    }
}


