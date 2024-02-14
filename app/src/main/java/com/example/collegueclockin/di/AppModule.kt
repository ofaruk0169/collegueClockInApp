package com.example.collegueclockin.di

import com.example.collegueclockin.data.CollegueDataSource
import com.example.collegueclockin.data.CollegueDataSourceImpl
import com.example.collegueclockin.viewmodels.CollegueListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Declare CollegueDataSource singleton here
    single<CollegueDataSource> {CollegueDataSourceImpl(get())}

    // Declare CollegueListViewModel with ViewModel DSL
    viewModel { CollegueListViewModel(get()) }

}