package com.example.covidinfo.data.network

import androidx.lifecycle.LiveData
import com.example.covidinfo.data.db.CovidInfoEntity
import com.example.covidinfo.data.network.response.CovidInfoResponse

interface CovidNetworkDataSource {

    val downloadedCovidInfo: LiveData<List<CovidInfoEntity>>

    suspend fun fetchCovidInfo(): LiveData<List<CovidInfoEntity>>
}