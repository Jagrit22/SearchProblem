package com.example.searchproblem.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchproblem.data.model.SearchDataModel
import com.example.searchproblem.domain.SearchUseCase

class SearchViewModel(private val searchUseCase: SearchUseCase?) : ViewModel() {
    val searchList = MutableLiveData<List<SearchDataModel>>()

    fun search(searchText: String): MutableList<SearchDataModel> {
        val searchList = searchUseCase!!.getAllSearchMatchedItems(searchText)
        val sortedList = mutableListOf<SearchDataModel>()

        //Sorting logic - Insertion Sort
        for (count in 1..searchList.size) {
            val itemScore = searchList[count].title.calculateScore(searchText)

            var i = count
            while (i > 0 && itemScore < sortedList[i - 1].matchScore) {
                sortedList[i] = sortedList[i - 1]
                i -= 1
            }

            sortedList[i] = sortedList[count]
        }

        return sortedList
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
}