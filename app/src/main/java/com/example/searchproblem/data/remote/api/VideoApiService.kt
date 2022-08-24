package com.example.searchproblem.data.remote.api

import com.example.searchproblem.data.model.VideoDataModel
import retrofit2.Response
import retrofit2.http.GET

interface VideoApiService {
    @GET("fetch_videos")
    fun getVideoLessons() : Response<VideoDataModel>
}