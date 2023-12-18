package com.example.javaopenai.network;

import com.example.javaopenai.response.ImageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import com.example.javaopenai.request.ChatRequest;
import com.example.javaopenai.response.ChatResponse;

public interface ApiInterface {

    @POST("chat/completions")
    public Call<ChatResponse> generateText(
        @Body Object request,
        @Header ("Content-Type") String contentType, 
        @Header ("Authorization") String authorization
        );

    @POST("images/generations")
    public Call<ImageResponse> generateImage(
            @Body Object request,
            @Header ("Content-Type") String contentType,
            @Header ("Authorization") String authorization
    );

        // add method for image generation
    



    
}
