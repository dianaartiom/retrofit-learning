package com.example.diana.retrofit_learning.controllers;

import com.example.diana.retrofit_learning.interfaces.IComments;
import com.example.diana.retrofit_learning.model.Comment;

import java.util.List;

import de.greenrobot.event.EventBus;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 8/1/16.
 */
public class CommentsController {

    public static final String SERVER_URL = "https://jsonplaceholder.typicode.com/";
    private IComments iComments;

    public void getComments() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IComments iComments = retrofit.create(IComments.class);

        Call<List<Comment>> commList = iComments.getComments((long) 1);
        commList.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                EventBus.getDefault().post(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}
