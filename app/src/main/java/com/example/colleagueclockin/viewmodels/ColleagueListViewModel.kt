package com.example.colleagueclockin.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
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

    private var _showInputDialog: MutableState<Boolean> = mutableStateOf(false)
    val showInputDialog: MutableState<Boolean> get() = _showInputDialog

    var colleagueDetails by mutableStateOf<ColleagueEntity?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set

    var lastNameText by mutableStateOf("")
        private set

    var loginNumberText by mutableStateOf("") // New field for login number
        private set

    fun onInsertColleagueClick() {
        if(firstNameText.isBlank() || lastNameText.isBlank() || loginNumberText.isBlank()) {
            return
        }
        viewModelScope.launch {
            colleagueDataSource.insertColleague(firstNameText, lastNameText, loginNumberText)
            firstNameText = ""
            lastNameText = ""
            loginNumberText = ""
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

    //Staff Dialog Options
    fun addStaff() {
        _showInputDialog.value = true
    }
    fun addStaffDismiss() {
        _showInputDialog.value = false
    }

}