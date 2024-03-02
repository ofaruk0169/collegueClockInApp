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
            val colleagueId = matchingColleague.id
            val firstName = matchingColleague.firstName
            val secondName = matchingColleague.lastName
            val clockInString = clockInString
            var clockInStatus = matchingColleague.clockInStatus

            // Perform clock-in logic or any other operations with the extracted details

            clockInStatus = if (clockInStatus == 1L) 0L else 1L
            val updatedColleague = matchingColleague.copy(clockInStatus = clockInStatus)

            // Use the updatedColleague for further operations or persistence
            colleagueDataSource.toggleClockInStatus(colleagueId,firstName, secondName, clockInString, clockInStatus)
            return Resource.Success(Unit)
        } else {
            // No matching colleague found, handle accordingly
            return Resource.Error("Colleague not found with the provided loginNumber")
        }
    }
}



