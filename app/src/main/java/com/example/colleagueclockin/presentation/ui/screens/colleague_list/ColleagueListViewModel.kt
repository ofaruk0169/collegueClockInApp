package com.example.colleagueclockin.presentation.ui.screens.colleague_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colleagueclockin.domain.repository.ColleagueDataSource
import com.example.colleagueclockin.domain.use_case.SubmitColleagueUseCase
import com.example.colleagueclockin.common.Resource
import databases.ColleagueEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ColleagueListViewModel(
    private val colleagueDataSource: ColleagueDataSource,
    private val submitColleagueUseCase: SubmitColleagueUseCase
): ViewModel() {

    private val _error = MutableStateFlow<String?>(null)
    val error: Flow<String?> = _error.asStateFlow()

    fun clearError() {
        _error.value = null
    }

    fun setError(errorMessage: String?) {
        _error.value = errorMessage
    }

    val colleagues = colleagueDataSource.getAllColleagues()

    private var _showInputDialog: MutableState<Boolean> = mutableStateOf(false)
    val showInputDialog: MutableState<Boolean> get() = _showInputDialog

    var colleagueDetails by mutableStateOf<ColleagueEntity?>(null)
        private set

    var firstNameText by mutableStateOf("")
        private set

    var lastNameText by mutableStateOf("")
        private set

    var pinText by mutableStateOf("") // New field for login number
        private set

    var pinReenterText by mutableStateOf("") // New field for login number
        private set

    fun onInsertColleagueClick() {
        if(firstNameText.isBlank() || lastNameText.isBlank() || pinText.isBlank()) {
            return
        }
        viewModelScope.launch {

            val result = submitColleagueUseCase.execute(firstNameText, lastNameText, pinText, pinReenterText)

            when (result) {
                is Resource.Success -> {
                    // Clear the error on success
                    clearError()
                }
                is Resource.Error -> {
                    // Set the error message on failure
                    setError(result.message)
                }
            }

            //colleagueDataSource.insertColleague(firstNameText, lastNameText, pinText)
            firstNameText = ""
            lastNameText = ""
            pinText = ""
            pinReenterText = ""
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

    fun onPinChange(value: String) {
        pinText = value
    }

    fun onPinReenterChange(value: String) {
        pinReenterText = value
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