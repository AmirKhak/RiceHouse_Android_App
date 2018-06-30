package com.example.amir.ricehouse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RiceHouseRetrofitClass {

    private static String BASE_URL = "https://polar-anchorage-22281.herokuapp.com/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }

    public static RiceHouseService getRiceHouseService() {
        return getRetrofitInstance().create(RiceHouseService.class);
    }

}
