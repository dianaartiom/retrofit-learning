package com.example.diana.retrofit_learning.interfaces;

import com.example.diana.retrofit_learning.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by diana on 8/1/16.
 */
public interface IPosts {
    @GET("posts")
    Call<List<Post>> getAllPosts();
}

