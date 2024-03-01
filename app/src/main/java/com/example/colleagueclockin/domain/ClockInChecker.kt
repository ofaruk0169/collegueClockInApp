package com.example.colleagueclockin.domain

import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.util.Resource

class ClockInChecker(
    private val colleagueDataSource: ColleagueDataSource
) {

    val colleagues = colleagueDataSource.getAllColleagues()


    suspend fun checkClockIn(
        clockInString: String
    ): Resource<Unit> {


    }


}



//return colleagueDataSource.insertColleague(firstNameText, lastNameText, pinText)
