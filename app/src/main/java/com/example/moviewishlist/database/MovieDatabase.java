package com.example.moviewishlist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moviewishlist.dao.MovieDao;
import com.example.moviewishlist.entity.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase movieDatabaseInstance;

    public abstract MovieDao movieDao();

    public static synchronized MovieDatabase getInstance(Context context) {
        if (movieDatabaseInstance == null){
            movieDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDatabase.class,
                    "movie_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return movieDatabaseInstance;
    }

}
