package com.example.covidinfo.data.repository

import androidx.lifecycle.LiveData
import com.example.covidinfo.data.db.CovidInfoEntity

interface CovidInfoRepository {

    suspend fun getCovidInfo(): LiveData<List<CovidInfoEntity>>
}