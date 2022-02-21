package com.example.covidinfo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidinfo.data.repository.CovidInfoRepository

class CovidInfoViewModelFactory(
    private val covidInfoRepository: CovidInfoRepository
): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CovidInfoViewModel(covidInfoRepository) as T
    }
}