package com.example.moviewishlist.api;


import androidx.lifecycle.MutableLiveData;

import com.example.moviewishlist.entity.ResponseAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoints {

    @GET("movie/popular")
    Call<ResponseAll> getAllMovies(@Query("api_key") String apiKey);
}
