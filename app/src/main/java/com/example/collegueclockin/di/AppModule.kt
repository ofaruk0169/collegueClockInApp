package com.example.collegueclockin.di

import com.example.collegueclockin.data.CollegueDataSource
import com.example.collegueclockin.data.CollegueDataSourceImpl
import org.koin.dsl.module

val appModule = module {

    //Declare CollegueDataSource singleton here
    single<CollegueDataSource> {CollegueDataSourceImpl(get())}

}