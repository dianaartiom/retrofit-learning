package com.example.diana.retrofit_learning.controllers;

import com.example.diana.retrofit_learning.interfaces.IPosts;
import com.example.diana.retrofit_learning.model.Post;
import com.google.gson.Gson;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

/**
 * Created by diana on 8/1/16.
 */
public class RequestController {

    public static final String SERVER_URL = "https://jsonplaceholder.typicode.com/";
    private IPosts iPosts;

    public void getProduct() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IPosts iPosts = retrofit.create(IPosts.class);

        Call<List<Post>> postList = iPosts.getAllPosts();
        postList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}

