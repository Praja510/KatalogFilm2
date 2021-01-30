package com.example.katalogfilm2.listtvshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import com.example.katalogfilm2.listmovies.WatchModel;

public class ListTvShowFragment extends Fragment {

    private ListTvShowViewModel mViewModel;
    private ListWatchAdapter mAdapter;

    public static ListTvShowFragment newInstance() {
        return new ListTvShowFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_tv_show_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(ListTvShowViewModel.class);

        mViewModel.addTvShowModel(getResources().getString(R.string.title_teen_titans), getResources().getString(R.string.overview_teen_titans), R.drawable.teen_titans);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_dexters), getResources().getString(R.string.overview_dexters), R.drawable.dexters);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_powerpuff), getResources().getString(R.string.overview_powerpuff), R.drawable.powerpuff);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_courage), getResources().getString(R.string.overview_courage), R.drawable.courage);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_adventure_time), getResources().getString(R.string.overview_adventure_time), R.drawable.adventure_time);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_samurai_jack), getResources().getString(R.string.overview_samurai_jack), R.drawable.samurai_jack);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_tom_jerry), getResources().getString(R.string.overview_tom_jerry), R.drawable.tom_jerry);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_regular_show), getResources().getString(R.string.overview_regular_show), R.drawable.regular_show);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_scooby), getResources().getString(R.string.overview_scooby), R.drawable.scooby);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_pokemon), getResources().getString(R.string.overview_pokemon), R.drawable.pokemon);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_loony_tunes), getResources().getString(R.string.overview_loony_tunes), R.drawable.loony_tunes);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_ben10), getResources().getString(R.string.overview_ben10), R.drawable.ben10);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_gumbal), getResources().getString(R.string.overview_gumbal), R.drawable.gumbal);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_chowder), getResources().getString(R.string.overview_chowder), R.drawable.chowder);
        mViewModel.addTvShowModel(getResources().getString(R.string.title_justice), getResources().getString(R.string.overview_justice), R.drawable.justice);

        mAdapter = new ListWatchAdapter(view.getContext(), mViewModel.getTvShowList());
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
