package com.example.collegueclockin

import android.app.Application
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.collegueclockin.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    private var isDatabaseInitialized = false

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }

        // Initialize SQLDelight database with AndroidSqliteDriver
      /*  if (!isDatabaseInitialized) {
            val driver = AndroidSqliteDriver(CollegueClockInDatabase.Schema, this, "collegue_clockin.db")
            CollegueClockInDatabase.Schema.create(driver)
            isDatabaseInitialized = true
        }*/
    }
}