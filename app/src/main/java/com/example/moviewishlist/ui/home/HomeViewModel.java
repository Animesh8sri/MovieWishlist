package com.example.moviewishlist.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviewishlist.api.ApiEndpoints;
import com.example.moviewishlist.api.RetrofitClient;
import com.example.moviewishlist.entity.ResponseAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeViewModel extends ViewModel {
    private static final String API_KEY = "c0a28206d3f586cb927643cfed77e036";




    private ResponseAll responseAllList;
    private MutableLiveData<ResponseAll> responseAllMutableLiveData;

    public HomeViewModel() {

        responseAllMutableLiveData = new MutableLiveData<>();
        init();

    }

    public void init(){
        getDataFromReftrofit();
//        responseAllMutableLiveData.setValue(responseAllList);
   }

    private void getDataFromReftrofit() {
        ApiEndpoints apiEndpoints = RetrofitClient.getRetrofit().create(ApiEndpoints.class);
        Call<ResponseAll> call = apiEndpoints.getAllMovies(API_KEY);
        call.enqueue(new Callback<ResponseAll>() {
            @Override
            public void onResponse(Call<ResponseAll> call, Response<ResponseAll> response) {

                Log.d(TAG, "onResponse: ");


                responseAllList = response.body();
                responseAllMutableLiveData.setValue(responseAllList);



//                List<String> homePageRequirementsList = new ArrayList<>();
//                homePageRequirementsList.add(responseAllList.get(0).getResults().get(0).getPosterPath());
//                homePageRequirementsList.add(responseAllList.get(0).getResults().get(0).getTitle());
//                homePageRequirementsList.add(responseAllList.get(0).getResults().get(0).getReleaseDate());
//                homePageRequirementsList.add(responseAllList.get(0).getResults().get(0).getOverview());



            }


            @Override
            public void onFailure(Call<ResponseAll> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }


    public LiveData<ResponseAll> getDataFromFavouritesViewModel() {

        return responseAllMutableLiveData;
    }
}
