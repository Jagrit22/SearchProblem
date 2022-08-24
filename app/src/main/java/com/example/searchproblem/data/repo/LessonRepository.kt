package com.example.searchproblem.data.repo

import com.example.searchproblem.data.local.LessonLocalDataSource
import com.example.searchproblem.data.model.LessonDataModel
import com.example.searchproblem.data.remote.LessonRemoteDataSource

class LessonRepository(private val localDataSource : LessonLocalDataSource,private val remoteDataSource: LessonRemoteDataSource) {

    fun getAllLessonsWithText(key: String): List<LessonDataModel> {
        return localDataSource.getAllLessonsWithSearchString(key)
    }
}