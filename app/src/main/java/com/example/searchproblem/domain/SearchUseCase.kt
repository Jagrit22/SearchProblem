package com.example.searchproblem.domain

import com.example.searchproblem.data.model.SearchDataModel
import com.example.searchproblem.data.repo.LessonRepository
import com.example.searchproblem.data.repo.VideoRepository

class SearchUseCase(
    private val lessonRepository: LessonRepository,
    private val videoRepository: VideoRepository
) {

    fun getAllSearchMatchedItems(key: String): MutableList<SearchDataModel> {
        val searchList: MutableList<SearchDataModel> = mutableListOf()

        lessonRepository.getAllLessonsWithText(key).forEach { lessonDataModel ->
            searchList.add(
                SearchDataModel(
                    title = lessonDataModel.title,
                    type = lessonDataModel.type,
                    matchScore = lessonDataModel.title.calculateScore(key)
                )
            )
        }

        videoRepository.getAllLessonsWithText(key).forEach { videoDataModel ->
            searchList.add(
                SearchDataModel(
                    title = videoDataModel.title,
                    type = TYPE_VIDEO,
                    matchScore = videoDataModel.title.calculateScore(key)
                )
            )
        }

        return searchList
    }


    /** Searched string = "Bone"
     * 100% - Bone
     * 95%  - Bones
     * 90%  - UBone
     * 80%  - Bone Marrow
     * 70%  - Marrow Bone
     * 0 - Default
     * */
    private fun String.calculateScore(searchText: String): Int =
        when {
            equals(searchText) -> 100

            matches(Regex("$searchText.")) -> 95

            matches(Regex(".$searchText")) -> 90

            matches(Regex("$searchText..")) -> 95

            matches(Regex("..$searchText")) -> 90

            matches(Regex("$searchText*")) -> 80

            matches(Regex("*$searchText")) -> 70

            else -> 0
        }


    companion object {
        private const val TYPE_VIDEO = 3
    }
}