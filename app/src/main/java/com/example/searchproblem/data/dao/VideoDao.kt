package com.example.searchproblem.data.dao

import androidx.room.Query
import com.example.searchproblem.data.model.VideoDataModel

interface VideoDao {

    @Query("SELECT * from $VIDEO_TABLE where $VIDEO_TITLE LIKE :searchString")
    fun getAllVideoRecordsWithSearch(searchString: String): List<VideoDataModel>
}