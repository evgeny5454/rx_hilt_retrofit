package com.evgeny5454.rx_retrofit.data.repository

import android.content.Context
import com.evgeny5454.rx_retrofit.R
import com.evgeny5454.rx_retrofit.domain.model.PodResponse
import com.evgeny5454.rx_retrofit.data.network.ApiService
import com.evgeny5454.rx_retrofit.domain.repository.Repository
import io.reactivex.rxjava3.core.Observable

class RepositoryImpl(
    private val apiService: ApiService,
    private val context: Context
) : Repository {

    override fun getPictureByDate(date: String): Observable<PodResponse> {
        return apiService.getPictureByDate(
            api_key = context.getString(R.string.nasa_api_key),
            date = date
        )
    }
}