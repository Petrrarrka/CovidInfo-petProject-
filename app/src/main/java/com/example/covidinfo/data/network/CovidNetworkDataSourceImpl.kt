package com.example.covidinfo.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.covidinfo.api.Feature
import com.example.covidinfo.data.db.CovidInfoEntity
import com.example.covidinfo.data.network.response.CovidInfoResponse
import com.example.covidinfo.data.network.response.toCovidInfoEntities
import com.example.covidinfo.internal.NoConnectivityException

class CovidNetworkDataSourceImpl(
    private val covidApiService: CovidApiService
) : CovidNetworkDataSource {

    private val _downloadedCovidInfo = MutableLiveData<List<CovidInfoEntity>>()
    override val downloadedCovidInfo: LiveData<List<CovidInfoEntity>>
        get() = _downloadedCovidInfo

    override suspend fun fetchCovidInfo(): LiveData<List<CovidInfoEntity>> {
        return try {
            val fetchedCovidInfo = covidApiService
                .getCovidInfoAsync()
                .await()
            _downloadedCovidInfo.postValue(fetchedCovidInfo.toCovidInfoEntities())
            downloadedCovidInfo

        }catch (e: NoConnectivityException){
            Log.e("Connectivity", "No internet connection", e)
            MutableLiveData(emptyList())
        }
    }
}