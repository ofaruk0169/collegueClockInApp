package com.example.colleagueclockin.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.colleagueclockin.ColleagueClockInDatabase
import databases.ColleagueEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class ColleagueDataSourceImpl (
    db: ColleagueClockInDatabase
): ColleagueDataSource {

    private val queries = db.colleagueEntityQueries

    override suspend fun getColleagueById(id: Long): ColleagueEntity? {
        return withContext(Dispatchers.IO) {
            queries.getColleagueById(id).executeAsOneOrNull()
        }
    }


    override fun getAllColleagues(): Flow<List<ColleagueEntity>> {
        return queries.getAllColleagues().asFlow().mapToList(Dispatchers.IO)
    }


    override suspend fun deleteColleagueById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deleteColleagueById(id)
        }
    }

    override suspend fun insertColleague(firstName: String, lastName: String, loginNumber: String,id: Long?) {
        withContext(Dispatchers.IO) {
            queries.insertColleague(id, firstName, lastName, loginNumber)
        }
    }
}