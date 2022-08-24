package com.example.searchproblem.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.searchproblem.data.model.LessonDataModel
import com.example.searchproblem.data.model.VideoDataModel

@Dao
interface QbankDao {

    @Query("SELECT * from $LESSON_TABLE where $LESSON_TITLE LIKE :searchString AND $LESSON_TYPE = '2'")
    fun getAllQBankRecordsWithSearch(searchString: String): List<LessonDataModel>
}