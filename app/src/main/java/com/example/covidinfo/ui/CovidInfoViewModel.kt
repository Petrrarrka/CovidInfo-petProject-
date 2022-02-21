package com.example.covidinfo.ui

import androidx.lifecycle.ViewModel
import com.example.covidinfo.data.repository.CovidInfoRepository
import com.example.covidinfo.internal.lazyDeferred

class CovidInfoViewModel(
    covidInfoRepository: CovidInfoRepository
): ViewModel() {

    val covid by lazyDeferred {
        covidInfoRepository.
        getCovidInfo()
    }

}