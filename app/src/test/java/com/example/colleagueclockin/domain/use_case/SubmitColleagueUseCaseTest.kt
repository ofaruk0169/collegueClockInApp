package com.example.colleagueclockin.domain.use_case

import com.example.colleagueclockin.data.ColleagueDataSourceImpl
import com.example.colleagueclockin.data.repository.FakeColleagueRepository
import org.junit.Assert.*
import org.junit.Before

class SubmitColleagueUseCaseTest {
    private lateinit var submitColleague: SubmitColleagueUseCase
    private lateinit var fakeRepository: FakeColleagueRepository

    @Before
    fun setUp() {
        fakeRepository = FakeColleagueRepository()
        submitColleague = SubmitColleagueUseCase(fakeRepository)
    }
}