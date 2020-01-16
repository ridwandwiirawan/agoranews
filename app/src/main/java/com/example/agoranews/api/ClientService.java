package com.example.agoranews.api;


import com.example.agoranews.model.News;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientService {

    @GET("v2/top-headlines?apiKey=b4040fde31c1425c9607e987b82ec8e7&pageSize=25")
    Call<ResponseBody> topHeadlines(@Query("country") String country);

}

//    @POST("auth/login")
//    Call<ResponseBody> login(@Field("username") String username,
//                             @Field("password") String password);
//
//    @POST("auth/logout")
//    Call<ResponseBody> logout();
//
//
//    @GET("user/{nim}")
//    Call<ResponseBody> user(@Path("nim") String nim);

//@Header("X-Api-Key: b4040fde31c1425c9607e987b82ec8e7") // jika post