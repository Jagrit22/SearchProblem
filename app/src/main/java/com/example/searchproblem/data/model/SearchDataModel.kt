package com.example.searchproblem.data.model

data class SearchDataModel(
    val title : String,

    /**
    type values will define as -
    * 1 -> QBANK
    * 2 -> TEST
    * 3 -> VIDEOS
    * */
    val type : Int,
    val matchScore : Int
)
