package com.evgeny5454.rx_retrofit.di

import android.content.Context
import com.evgeny5454.rx_retrofit.data.network.ApiService
import com.evgeny5454.rx_retrofit.data.repository.RepositoryImpl
import com.evgeny5454.rx_retrofit.domain.repository.Repository
import com.evgeny5454.rx_retrofit.other.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = Retrofit.Builder()
        .baseUrl(Constants.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build().create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRepository(
        @ApplicationContext context: Context,
        apiService: ApiService
    ): Repository = RepositoryImpl(apiService, context)
}