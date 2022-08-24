package com.example.searchproblem.data.local

import com.example.searchproblem.data.dao.QbankDao
import com.example.searchproblem.data.dao.TestDao
import com.example.searchproblem.data.model.LessonDataModel

class LessonLocalDataSource(private val qbankDao: QbankDao, private val testDao: TestDao) {
    fun getAllLessonsWithSearchString(key: String): List<LessonDataModel> {
        return qbankDao.getAllQBankRecordsWithSearch(key) + testDao.getAllTestRecordsWithSearch(key)
    }
}