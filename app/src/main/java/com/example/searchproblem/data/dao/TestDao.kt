package com.example.searchproblem.data.dao

import androidx.room.Query
import com.example.searchproblem.data.model.LessonDataModel

interface TestDao {

    @Query("SELECT * from $LESSON_TABLE where $LESSON_TITLE LIKE :searchString AND $LESSON_TYPE = '1'")
    fun getAllTestRecordsWithSearch(searchString: String): List<LessonDataModel>

}