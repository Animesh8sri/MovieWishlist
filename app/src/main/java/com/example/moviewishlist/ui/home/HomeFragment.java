package com.example.moviewishlist.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.moviewishlist.MovieClick;
import com.example.moviewishlist.MovieDetailsPage;
import com.example.moviewishlist.R;
import com.example.moviewishlist.entity.ResponseAll;
import com.example.moviewishlist.entity.ResultsItem;
import com.example.moviewishlist.recyclerview.RecyclerViewAdapter;
import com.example.moviewishlist.ui.Favourites.FavouritesViewModel;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment implements MovieClick {


    private HomeViewModel homeViewModel;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recycler_view_home);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);



        
        return root;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.getDataFromFavouritesViewModel().observe(getViewLifecycleOwner(), new Observer<ResponseAll>() {
            @Override
            public void onChanged(ResponseAll responseAlls) {

                adapter = new RecyclerViewAdapter(responseAlls, getContext(),HomeFragment.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void movieOnClickListener(ResultsItem resultsItem) {

        Intent intent = new Intent(getContext(), MovieDetailsPage.class);
        intent.putExtra("backdrop_path", resultsItem.getBackdropPath());
        intent.putExtra("poster_path", resultsItem.getPosterPath());
        intent.putExtra("vote_average", String.valueOf(resultsItem.getVoteAverage()));
        intent.putExtra("release_date", resultsItem.getReleaseDate());
        intent.putExtra("overview", resultsItem.getOverview());
        intent.putExtra("title", resultsItem.getTitle());
        startActivity(intent);
    }
}
