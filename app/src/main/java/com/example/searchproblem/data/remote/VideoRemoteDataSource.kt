package com.example.searchproblem.data.remote

import com.example.searchproblem.data.remote.api.VideoApiService
import com.example.searchproblem.data.BaseDataSource

class VideoRemoteDataSource(
    private val videoApiService: VideoApiService
) : BaseDataSource() {

    suspend fun fetchData() = getResult {
        videoApiService.getVideoLessons()
    }
}