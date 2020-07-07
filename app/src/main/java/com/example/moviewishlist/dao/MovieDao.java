package com.example.moviewishlist.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.moviewishlist.entity.Movie;

import java.util.List;


@Dao
public interface MovieDao {

    @Insert
    void insertMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("SELECT * FROM movies_table")
    LiveData<List<Movie>> getAllMovies();
}
