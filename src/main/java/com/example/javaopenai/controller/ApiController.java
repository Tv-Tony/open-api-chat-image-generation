package com.example.javaopenai.controller;

import java.io.IOException;

import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.request.ImageRequest;
import com.example.javaopenai.response.ImageResponse;
import retrofit2.Call;
import retrofit2.Response;


import com.example.javaopenai.network.ApiClient;
import com.example.javaopenai.network.ApiInterface;
import com.example.javaopenai.response.ChatResponse;
import com.example.javaopenai.utils.AppConstants;

public class ApiController{
    public void image(ImageRequest request){
        String contentType = "application/json";
        String authorization = "Bearer " + AppConstants.OPENAI_API_KEY;

        ApiInterface api = ApiClient.getInstance();
        Call<ImageResponse> call = api.generateImage(request, contentType, authorization);
        try {
            Response<ImageResponse> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println("Success");
                ImageResponse chatResponse = response.body();
                assert chatResponse != null;
                System.out.println(chatResponse.getData().get(0).getUrl());

            }
            else{
                System.out.println("Error");
                System.out.println(response.errorBody().string());
            }
        }catch (Exception error){
            error.printStackTrace();
        }

    }

    public void chat(ChatRequest request){
        String contentType = "application/json";
        String authorization = "Bearer " + AppConstants.OPENAI_API_KEY;

        ApiInterface api = ApiClient.getInstance();
        Call<ChatResponse> call = api.generateText(request, contentType, authorization);
        try {
            Response<ChatResponse> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println("Success");
                ChatResponse chatResponse = response.body();
                assert chatResponse != null;
                System.out.println(chatResponse.choices.get(0).message.content);

            }
            else{
                System.out.println("Error");
                    System.out.println(response.errorBody().string());
            }
        }catch (Exception error){
            error.printStackTrace();
        }

    }

    public void onResponse(Call<ChatResponse> call, Response<ChatResponse> response) {
        if (response.isSuccessful()) {
            System.out.println("Success");
            ChatResponse chatResponse = response.body();
            assert chatResponse != null;
            System.out.println(chatResponse.choices.get(0).message.content);

        }
        else{
            System.out.println("Error");
            try {
                System.out.println(response.errorBody().string());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void onFailure(Call<ChatResponse> call, Throwable t) {
        System.out.println("Faliure");
        t.printStackTrace();
    }
    
}
