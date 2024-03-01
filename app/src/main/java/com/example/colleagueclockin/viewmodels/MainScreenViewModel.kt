package com.example.colleagueclockin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.domain.ClockInChecker
import com.example.colleagueclockin.domain.SubmitColleagueUseCase
import com.example.colleagueclockin.util.Resource
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val colleagueDataSource: ColleagueDataSource,
    private val clockInChecker: ClockInChecker

): ViewModel() {

    val colleagues = colleagueDataSource.getAllColleagues()

    fun toggleClockInStatus(password: String) {

        viewModelScope.launch {

            val result = clockInChecker.checkClockIn(password)



        }
    }
}