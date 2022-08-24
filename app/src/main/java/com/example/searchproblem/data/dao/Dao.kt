package com.example.searchproblem.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.searchproblem.data.model.LessonDataModel
import com.example.searchproblem.data.model.VideoDataModel

const val LESSON_TABLE = "lesson"
const val VIDEO_TABLE = "video"
const val LESSON_TYPE = "type"
const val LESSON_TITLE = "lesson_title"
const val VIDEO_TITLE = "video_title"

@Dao
interface QueryDao {

    @Query("SELECT * from $LESSON_TABLE where $LESSON_TITLE LIKE :searchString")
    fun getAllLessonRecordsWithSearch(searchString: String): List<LessonDataModel>

}
