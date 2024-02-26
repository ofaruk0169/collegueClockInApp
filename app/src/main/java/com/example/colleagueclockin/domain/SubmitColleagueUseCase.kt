package com.example.colleagueclockin.domain

import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.util.Resource



/*

class SubmitColleagueUseCase(
    //You're supposed to do Dependecy Injection here somehow, figure out later
    private val colleagueDataSource: ColleagueDataSource
) {

    fun execute(id: Long, firstName: String, lastName: String, pinText: String, pinReenterText: String, clockInStatus: Long): Resource<Unit> {
        if(pinText !== pinReenterText) {
            return Resource.Error("The Pins are not the same")
        }
        return colleagueDataSource.insertColleague(id, firstName, lastName, pinText, clockInStatus)
    }
}*/
