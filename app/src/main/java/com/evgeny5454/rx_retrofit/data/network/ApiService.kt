package com.evgeny5454.rx_retrofit.data.network

import com.evgeny5454.rx_retrofit.domain.model.PodResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("planetary/apod")
    fun getPictureByDate(
        @Query("api_key") api_key: String,
        @Query("date") date: String
    ): Observable<PodResponse>
}