package uz.gita.taskrounded.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.taskrounded.data.local.room.dao.DataDao
import uz.gita.taskrounded.data.local.room.database.AppDatabase
import uz.gita.taskrounded.data.remote.retrofit.api.BaseApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Provides Singleton]
    fun getRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    @[Provides Singleton]
    fun getData(retrofit: Retrofit): BaseApi = retrofit.create(BaseApi::class.java)

    @[Provides Singleton]
    fun getDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").build()


    @[Provides Singleton]
    fun getDao(appDatabase: AppDatabase):DataDao = appDatabase.getDao()

}