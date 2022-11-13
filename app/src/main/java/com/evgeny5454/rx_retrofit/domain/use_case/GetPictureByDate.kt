package com.evgeny5454.rx_retrofit.domain.use_case

import com.evgeny5454.rx_retrofit.domain.model.PodResponse
import com.evgeny5454.rx_retrofit.domain.repository.Repository
import io.reactivex.rxjava3.core.Observable

class GetPictureByDate(private val repository: Repository) {
    fun execute(date: String): Observable<PodResponse> {
        return repository.getPictureByDate(date = date)
    }
}