package com.example.colleagueclockin.domain.use_case

import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.util.Resource


class SubmitColleagueUseCase(
    private val colleagueDataSource: ColleagueDataSource
){
    //the data we want to validate
    suspend fun execute(
        firstNameText: String,
        lastNameText: String,
        pinText: String,
        pinReenterText: String
    ): Resource<Unit> {
        if(pinText.length != 5) {
            return Resource.Error("Pin Length must be 5 digits")
        }
        if(pinText !=  pinReenterText) {
            return Resource.Error("You need to enter the same pin twice")
        }
        return colleagueDataSource.insertColleague(firstNameText, lastNameText, pinText)
    }

}


