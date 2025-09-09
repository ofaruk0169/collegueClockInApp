package com.example.colleagueclockin.presentation.ui.screens.clockin_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colleagueclockin.domain.repository.ColleagueDataSource
import com.example.colleagueclockin.domain.use_case.ClockInChecker
import com.example.colleagueclockin.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val colleagueDataSource: ColleagueDataSource,
    private val clockInChecker: ClockInChecker
) : ViewModel() {

    private val _signInError = MutableStateFlow<String?>(null)
    val signInError: Flow<String?> = _signInError.asStateFlow()

    private val _success = MutableStateFlow<String?>(null)
    val success: Flow<String?> = _success.asStateFlow()

    // ADD THIS NEW STATE
    private val _isClockIn = MutableStateFlow<Boolean?>(null)
    val isClockIn: Flow<Boolean?> = _isClockIn.asStateFlow()

    // UPDATE THIS FUNCTION
    fun clearSuccess() {
        _success.value = null
        _isClockIn.value = null // Clear both together
    }

    // UPDATE THIS FUNCTION TO ACCEPT BOOLEAN
    fun setSuccess(successMessage: String?, isClockedIn: Boolean) {
        _success.value = successMessage
        _isClockIn.value = isClockedIn
    }

    fun clearSignInError() {
        _signInError.value = null
    }

    fun setSignInError(errorMessage: String?) {
        _signInError.value = errorMessage
    }

    val colleagues = colleagueDataSource.getAllColleagues()

    // UPDATE THIS FUNCTION COMPLETELY
    fun toggleClockInStatus(password: String) {
        viewModelScope.launch {
            when (val signInResult = clockInChecker.checkClockIn(password)) {
                is Resource.Success -> {
                    val isClockedIn = signInResult.data ?: false
                    val message = if (isClockedIn) {
                        "You're ready to begin!" // User just clocked IN
                    } else {
                        "You're good to go!" // User just clocked OUT
                    }
                    setSuccess(message, isClockedIn)
                }
                is Resource.Error -> {
                    setSignInError(signInResult.message)
                }
            }
        }
    }
}