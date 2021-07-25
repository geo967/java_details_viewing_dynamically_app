package com.example.userdetailsviewingdynamically.Network;


import com.example.userdetailsviewingdynamically.Model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("users")
    Call<List<MainModel>> getModels();
}
