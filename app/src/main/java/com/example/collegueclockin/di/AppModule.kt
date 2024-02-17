package com.example.collegueclockin.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.collegueclockin.CollegueClockInDatabase
import com.example.collegueclockin.data.CollegueDataSource
import com.example.collegueclockin.data.CollegueDataSourceImpl
import com.example.collegueclockin.viewmodels.CollegueListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Declare CollegueDataSource singleton here
    single<CollegueDataSource> { CollegueDataSourceImpl(get()) }

    // Declare CollegueListViewModel with ViewModel DSL
    viewModel { CollegueListViewModel(get()) }

    single { provideSqlDriver(androidContext()) }
    single { provideCollegueDataSource(get()) }
}


fun provideSqlDriver(app: Context): SqlDriver {
    return AndroidSqliteDriver(
        schema = CollegueClockInDatabase.Schema,
        context = app,
        name = "collegue.db"
    )
}

fun provideCollegueDataSource(driver: SqlDriver): CollegueDataSource {
    return CollegueDataSourceImpl(CollegueClockInDatabase(driver))
}