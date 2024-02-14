package com.example.collegueclockin.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegueclockin.data.CollegueDataSource
import databases.CollegueEntity
import kotlinx.coroutines.launch

class CollegueListViewModel(
    private val collegueDataSource: CollegueDataSource
): ViewModel() {


    val collegues = collegueDataSource.getAllPersons()

    var personDetails by mutableStateOf<CollegueEntity?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set

    var lastNameText by mutableStateOf("")
        private set

    fun onInsertPersonClick() {
        if(firstNameText.isBlank() || lastNameText.isBlank()) {
            return
        }
        viewModelScope.launch {
            collegueDataSource.insertPerson(firstNameText, lastNameText)
            firstNameText = ""
            lastNameText = ""
        }
    }

    fun onDeleteClick(id: Long) {
        viewModelScope.launch {
            collegueDataSource.deletePersonById(id)
        }
    }

    fun getPersonById(id: Long) {
        viewModelScope.launch {
            personDetails = collegueDataSource.getPersonById(id)
        }
    }

    fun onFirstNameChange(value: String) {
        firstNameText = value
    }

    fun onLastNameChange(value: String) {
        lastNameText = value
    }

    fun onPersonDetailsDialogDismiss() {
        personDetails = null
    }
}