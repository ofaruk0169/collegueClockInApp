package com.example.colleagueclockin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.domain.ClockInChecker
import com.example.colleagueclockin.domain.SubmitColleagueUseCase
import com.example.colleagueclockin.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val colleagueDataSource: ColleagueDataSource,
    private val clockInChecker: ClockInChecker

): ViewModel() {

    private val _signInError = MutableStateFlow<String?>(null)
    val signInError: Flow<String?> = _signInError.asStateFlow()

    fun clearError() {
        _signInError.value = null
    }

    fun setError(errorMessage: String?) {
        _signInError.value = errorMessage
    }

    val colleagues = colleagueDataSource.getAllColleagues()

    fun toggleClockInStatus(password: String) {

        viewModelScope.launch {

            when (val signInResult = clockInChecker.checkClockIn(password)) {
                is Resource.Success -> {
                    // Clear the error on success
                    clearError()
                }
                is Resource.Error -> {
                    // Set the error message on failure
                    setError(signInResult.message)
                }
            }


        }
    }
}