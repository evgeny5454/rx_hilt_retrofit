package com.evgeny5454.rx_retrofit.presentation.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evgeny5454.rx_retrofit.domain.model.PodResponse
import com.evgeny5454.rx_retrofit.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _picture = MutableLiveData<PodResponse>()
    val picture: LiveData<PodResponse> = _picture

    init {
        getPictureByDate("2022-11-11")
    }

    private fun getPictureByDate(date: String) {
        useCase.getPictureByDate.execute(date).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { item ->
                _picture.postValue(item)
            }
    }
}