package com.evgeny5454.rx_retrofit.di

import com.evgeny5454.rx_retrofit.domain.repository.Repository
import com.evgeny5454.rx_retrofit.domain.use_case.GetPictureByDate
import com.evgeny5454.rx_retrofit.domain.use_case.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideUseCase(repository: Repository): UseCase{
        return UseCase(
            getPictureByDate = GetPictureByDate(repository)
        )
    }
}