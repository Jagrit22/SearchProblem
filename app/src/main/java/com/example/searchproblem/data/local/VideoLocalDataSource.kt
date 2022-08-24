package com.example.searchproblem.data.local

import com.example.searchproblem.data.dao.VideoDao
import com.example.searchproblem.data.model.LessonDataModel
import com.example.searchproblem.data.model.VideoDataModel

class VideoLocalDataSource(private val videoDao: VideoDao) {
    fun getAllLessonsWithSearchString(key: String): List<VideoDataModel> {
        return videoDao.getAllVideoRecordsWithSearch(key)
    }
}