package com.example.dicodingtask.data.api.service

import com.example.dicodingtask.data.api.response.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiService {
    //home
    @Headers("Authorization: 563492ad6f917000010000018a0c2aa3465b478dbf22687fdb46614a")
    @GET("curated?page=2&per_page=16")
    suspend fun allPhoto(): Response<PhotoResponse>
}
