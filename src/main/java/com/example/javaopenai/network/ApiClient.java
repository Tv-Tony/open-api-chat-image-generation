package com.example.javaopenai.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.javaopenai.utils.AppConstants;

public class ApiClient {
    private static volatile ApiInterface INSTANCE = null;

    public static synchronized ApiInterface getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface.class);
            
        }


        return INSTANCE;
    }
}
