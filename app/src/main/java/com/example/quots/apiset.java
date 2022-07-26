package com.example.quots;

import com.example.quots.models.ShowCategorywiseDataResponseModel;
import com.example.quots.models.ShowOnlyCategoryNameResponseModel;
import com.example.quots.models.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset
{

    @GET("fetchdata.php")
    Call<List<model>> getdata();

    @GET("ShowOnlyCategoryName.php")
    Call<List<ShowOnlyCategoryNameResponseModel>>onlyCatName();

    @FormUrlEncoded
    @POST("ShowCategorywiseData.php")
    Call<List<ShowCategorywiseDataResponseModel>>categoryWiseData(
            @Field("cname") String cname
    );




}
