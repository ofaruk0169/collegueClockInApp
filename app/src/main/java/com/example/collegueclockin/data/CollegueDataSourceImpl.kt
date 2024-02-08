package com.example.collegueclockin.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.collegueclockin.CollegueClockInDatabase
import databases.CollegueEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class CollegueDataSourceImpl (
    db: CollegueClockInDatabase
): CollegueDataSource {

    private val queries = db.collegueEntityQueries

    override suspend fun getPersonById(id: Long): CollegueEntity? {
        return withContext(Dispatchers.IO) {
            queries.getPersonById(id).executeAsOneOrNull()
        }
    }


    override fun getAllPersons(): Flow<List<CollegueEntity>> {
        return queries.getAllPersons().asFlow().mapToList(Dispatchers.IO)
    }


    override suspend fun deletePersonById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deletePersonById(id)
        }
    }

    override suspend fun insertPerson(firstName: String, lastName: String, id: Long?) {
        withContext(Dispatchers.IO) {
            queries.insertPerson(id, firstName, lastName)
        }
    }
}