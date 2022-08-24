package com.example.searchproblem.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.searchproblem.R

class SearchActivity : AppCompatActivity() {
    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchViewModel = ViewModelProvider(this, MainViewModelFactory()).get(SearchViewModel::class.java)

        //TextWatcher
        //Listener
        //viewmodel.search
        searchViewModel.search("Anatomy")
    }
}