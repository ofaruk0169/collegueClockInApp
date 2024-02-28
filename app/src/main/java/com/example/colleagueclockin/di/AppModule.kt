package com.example.colleagueclockin.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.colleagueclockin.ColleagueClockInDatabase
import com.example.colleagueclockin.data.ColleagueDataSource
import com.example.colleagueclockin.data.ColleagueDataSourceImpl
import com.example.colleagueclockin.domain.SubmitColleagueUseCase
import com.example.colleagueclockin.viewmodels.ColleagueListViewModel
import com.example.colleagueclockin.viewmodels.MainScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Declare ColleagueDataSource singleton here
    single<ColleagueDataSource> { ColleagueDataSourceImpl(get()) }

    // Declare ColleagueListViewModel with ViewModel DSL
    viewModel { ColleagueListViewModel(get(), get()) }
    viewModel { MainScreenViewModel(get()) }

    single { provideSqlDriver(androidContext()) }
    single { provideColleagueDataSource(get()) }

    // Declare SubmitColleagueUseCase singleton
    single { SubmitColleagueUseCase(get()) }
}


fun provideSqlDriver(app: Context): SqlDriver {
    return AndroidSqliteDriver(
        schema = ColleagueClockInDatabase.Schema,
        context = app,
        name = "colleague.db"
    )
}

fun provideColleagueDataSource(driver: SqlDriver): ColleagueDataSource {
    return ColleagueDataSourceImpl(ColleagueClockInDatabase(driver))
}