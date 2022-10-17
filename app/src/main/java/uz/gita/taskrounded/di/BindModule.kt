package uz.gita.taskrounded.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.taskrounded.domain.repository.Repository
import uz.gita.taskrounded.domain.repository.impl.RepositoryImpl
import uz.gita.taskrounded.domain.usecase.MainScreenUseCase
import uz.gita.taskrounded.domain.usecase.impl.MainScreenUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {

    @[Binds Singleton]
    fun getRepository(impl: RepositoryImpl): Repository

    @[Binds Singleton]
    fun getUsecase(impl: MainScreenUseCaseImpl): MainScreenUseCase

}