package com.example.searchproblem.data.remote.api

import com.example.searchproblem.data.model.LessonDataModel
import retrofit2.Response
import retrofit2.http.GET

interface LessonApiService {
    @GET("fetch_lessons")
    fun getLessons() : Response<LessonDataModel>
}