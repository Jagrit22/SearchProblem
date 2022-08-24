package com.example.searchproblem.data.repo

import com.example.searchproblem.data.local.VideoLocalDataSource
import com.example.searchproblem.data.model.LessonDataModel
import com.example.searchproblem.data.model.VideoDataModel
import com.example.searchproblem.data.remote.VideoRemoteDataSource

class VideoRepository(private val localDataSource: VideoLocalDataSource, val remoteDataSource: VideoRemoteDataSource) {
    fun getAllLessonsWithText(key: String): List<VideoDataModel> {
        return localDataSource.getAllLessonsWithSearchString(key)
    }
}