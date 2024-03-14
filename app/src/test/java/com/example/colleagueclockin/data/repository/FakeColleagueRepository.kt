package com.example.colleagueclockin.data.repository

import com.example.colleagueclockin.domain.repository.ColleagueDataSource
import com.example.colleagueclockin.common.Resource
import databases.ColleagueEntity
import kotlinx.coroutines.flow.Flow

class FakeColleagueRepository : ColleagueDataSource {

    //no idea what to do here
    //private val colleagues = mutableListOf<Colleague>()

    override suspend fun getColleagueByLoginNumber(loginNumber: String): ColleagueEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getColleagueById(id: Long): ColleagueEntity? {
        TODO("Not yet implemented")
    }

    override fun getAllColleagues(): Flow<List<ColleagueEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteColleagueById(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun insertColleague(
        firstName: String,
        lastName: String,
        loginNumber: String,
        clockInStatus: Long,
        id: Long?
    ): Resource<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun toggleClockInStatus(
        id: Long,
        firstName: String,
        lastName: String,
        loginNumber: String,
        clockInStatus: Long
    ): Resource<Unit> {
        TODO("Not yet implemented")
    }
}