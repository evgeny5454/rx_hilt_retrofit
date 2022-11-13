package com.evgeny5454.rx_retrofit.domain.repository

import com.evgeny5454.rx_retrofit.domain.model.PodResponse
import io.reactivex.rxjava3.core.Observable

interface Repository {
    fun getPictureByDate(date: String) : Observable<PodResponse>
}