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

        // Use SQLDelight query to get a colleague by loginNumber
        val matchingColleague = colleagueDataSource.getColleagueByLoginNumber(clockInString)

        return if (matchingColleague != null) {
            // Matching colleague found, extract details
            val firstName = matchingColleague.firstName
            val secondName = matchingColleague.lastName
            val clockInStatus = matchingColleague.clockInStatus

            // Perform clock-in logic or any other operations with the extracted details
            // ...

            Resource.Success(Unit)
        } else {
            // No matching colleague found, handle accordingly
            Resource.Error("Colleague not found with the provided loginNumber")
        }
    }


}



//return colleagueDataSource.insertColleague(firstNameText, lastNameText, pinText)
