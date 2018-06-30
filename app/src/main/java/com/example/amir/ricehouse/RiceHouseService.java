package com.example.amir.ricehouse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amir on 29/06/18.
 */

public interface RiceHouseService {

    @GET("api/v1/product")
    Observable<RiceHouseResponse> getAllProducts();

    @GET("api/v1/product")
    Call<RiceHouseResponse> getAll();

}
