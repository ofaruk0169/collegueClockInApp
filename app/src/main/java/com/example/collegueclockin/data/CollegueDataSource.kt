package com.example.collegueclockin.data

import databases.CollegueEntity
import kotlinx.coroutines.flow.Flow

interface CollegueDataSource {

    suspend fun getPersonById(id: Long): CollegueEntity?

    fun getAllPersons(): Flow<List<CollegueEntity>>

    suspend fun deletePersonById(id: Long)

    suspend fun insertPerson(firstName: String, lastName: String, id: Long? = null)
}