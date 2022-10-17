package uz.gita.taskrounded.data.remote.retrofit.api

import retrofit2.http.GET
import retrofit2.http.Query
import uz.gita.taskrounded.data.model.BaseData

interface BaseApi {

    @GET("/api/character/")
    suspend fun getData(@Query("page") id:Int):BaseData

}