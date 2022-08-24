package com.example.searchproblem.data.remote

import com.example.searchproblem.data.remote.api.LessonApiService
import com.example.searchproblem.data.BaseDataSource

class LessonRemoteDataSource(
    private val lessonApiService: LessonApiService
) : BaseDataSource() {

    suspend fun fetchData() = getResult {
        lessonApiService.getLessons()
    }
}