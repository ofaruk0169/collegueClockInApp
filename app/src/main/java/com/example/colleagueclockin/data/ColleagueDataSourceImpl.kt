package com.example.colleagueclockin.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.colleagueclockin.ColleagueClockInDatabase
import com.example.colleagueclockin.common.Resource
import com.example.colleagueclockin.domain.repository.ColleagueDataSource
import databases.ColleagueEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlin.random.Random


class ColleagueDataSourceImpl (
    db: ColleagueClockInDatabase
): ColleagueDataSource {

    private val queries = db.colleagueEntityQueries

    override suspend fun getColleagueById(id: Long): ColleagueEntity? {
        return withContext(Dispatchers.IO) {
            queries.getColleagueById(id).executeAsOneOrNull()
        }
    }

    override suspend fun getColleagueByLoginNumber(loginNumber: String): ColleagueEntity? {
        return withContext(Dispatchers.IO) {
            // Implement the logic to get a colleague by login number
            // For example, you might use a query from your database
            queries.getColleagueByLoginNumber(loginNumber).executeAsOneOrNull()
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

    override suspend fun insertColleague(
        firstName: String,
        lastName: String,
        loginNumber: String,
        clockInStatus: Long,
        id: Long?
    ): Resource<Unit>
    {
        return if(loginNumber.length == 5) {
            withContext(Dispatchers.IO) {
                queries.insertColleague(
                    id,
                    firstName,
                    lastName,
                    loginNumber,
                    clockInStatus ?: 0L
                )
            }
            Resource.Success(Unit)
        } else {
            if(Random.nextBoolean()) {
                Resource.Error("Server error")
            } else {
                Resource.Error("Not authenticated error")
            }
        }

    }

    override suspend fun toggleClockInStatus(
        id: Long,
        firstName: String,
        lastName: String,
        loginNumber: String,
        clockInStatus: Long
    ): Resource<Unit> {
        return try {
            queries.insertColleague(
                firstName = firstName,
                lastName = lastName,
                loginNumber = loginNumber,
                clockInStatus = clockInStatus,
                id = id
            )
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error("Failed to update colleague: ${e.message}")
        }
    }
}