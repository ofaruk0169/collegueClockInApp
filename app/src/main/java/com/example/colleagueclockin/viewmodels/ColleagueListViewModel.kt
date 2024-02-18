package com.example.colleagueclockin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colleagueclockin.data.ColleagueDataSource
import databases.ColleagueEntity
import kotlinx.coroutines.launch

class ColleagueListViewModel(
    private val colleagueDataSource: ColleagueDataSource
): ViewModel() {


    val colleagues = colleagueDataSource.getAllColleagues()

    var colleagueDetails by mutableStateOf<ColleagueEntity?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set

    var lastNameText by mutableStateOf("")
        private set

    fun onInsertColleagueClick() {
        if(firstNameText.isBlank() || lastNameText.isBlank()) {
            return
        }
        viewModelScope.launch {
            colleagueDataSource.insertColleague(firstNameText, lastNameText)
            firstNameText = ""
            lastNameText = ""
        }
    }

    fun onDeleteClick(id: Long) {
        viewModelScope.launch {
            colleagueDataSource.deleteColleagueById(id)
        }
    }

    fun getColleagueById(id: Long) {
        viewModelScope.launch {
            colleagueDetails = colleagueDataSource.getColleagueById(id)
        }
    }

    fun onFirstNameChange(value: String) {
        firstNameText = value
    }

    fun onLastNameChange(value: String) {
        lastNameText = value
    }

    fun onColleagueDetailsDialogDismiss() {
        colleagueDetails = null
    }
}