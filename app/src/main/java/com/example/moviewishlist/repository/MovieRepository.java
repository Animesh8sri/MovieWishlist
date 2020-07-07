package com.example.moviewishlist.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.moviewishlist.dao.MovieDao;
import com.example.moviewishlist.database.MovieDatabase;
import com.example.moviewishlist.entity.Movie;

import java.util.List;

public class MovieRepository {

    private MovieDao movieDao;

    private LiveData<List<Movie>> allMovies;

    public MovieRepository(Application application) {
        MovieDatabase movieDatabase = MovieDatabase.getInstance(application);
        movieDao = movieDatabase.movieDao();

        allMovies = movieDao.getAllMovies();
    }




    public void insertMovie(Movie movie){

    }

    public void deleteMovie(Movie movie){

    }




    public LiveData<List<Movie>> getAllMovies() {
        return allMovies;
    }
}
