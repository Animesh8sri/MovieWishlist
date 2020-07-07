package com.example.moviewishlist.ui.Favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.moviewishlist.R;

public class FavouritesFragment extends Fragment {

    private FavouritesViewModel favouritesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        favouritesViewModel = ViewModelProviders.of(this).get(FavouritesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favourites, container, false);


        return root;
    }
}
