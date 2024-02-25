package com.example.colleagueclockin.data

import databases.ColleagueEntity
import kotlinx.coroutines.flow.Flow

interface ColleagueDataSource {

    suspend fun getColleagueById(id: Long): ColleagueEntity?

    fun getAllColleagues(): Flow<List<ColleagueEntity>>

    suspend fun deleteColleagueById(id: Long)

    suspend fun insertColleague(
        firstName: String,
        lastName: String,
        loginNumber: String,
        clockInStatus: Long? = 0,
        id: Long? = null)
}
