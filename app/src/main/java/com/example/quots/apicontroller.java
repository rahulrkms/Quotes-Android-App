package com.example.quots;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apicontroller
{
    private static final String url = "https://quickyitsolutions.000webhostapp.com/";
    public static apicontroller clientobject;
    public static Retrofit retrofit;

    public apicontroller() {
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized apicontroller getInstance(){
        if (clientobject==null)
            clientobject =new apicontroller();
        return clientobject;
    }
    public apiset getapi(){
        return retrofit.create(apiset.class);
    }


}
