package com.example.covidinfo.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.covidinfo.data.db.CovidInfoDao
import com.example.covidinfo.data.db.CovidInfoEntity
import com.example.covidinfo.data.db.toCovidInfoEntity
import com.example.covidinfo.data.network.CovidApiService
import com.example.covidinfo.data.network.CovidNetworkDataSource
import com.example.covidinfo.data.network.response.CovidInfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime

class CovidInfoRepositoryImpl(
//    private val covidInfoDao: CovidInfoDao,
    private val covidNetworkDataSource: CovidNetworkDataSource,
) : CovidInfoRepository {

//    init {
//        covidNetworkDataSource.downloadedCovidInfo.observeForever { newCovidInfo ->
//            saveFetchedCovidInfo(newCovidInfo)
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCovidInfo(): LiveData<List<CovidInfoEntity>> {
        return withContext(Dispatchers.IO) {

            covidNetworkDataSource.fetchCovidInfo()
        }
    }


//    private fun saveFetchedCovidInfo(fetchedInfo: CovidInfoResponse) {
//        GlobalScope.launch(Dispatchers.IO) {
//                covidInfoDao.upsert(fetchedInfo.features[0].attributes.toCovidInfoEntity())
//        }
//    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    private suspend fun initCovidData() {
//        if (isFetchCurrentNeeded(ZonedDateTime.now().minusHours(1)))
//            fetchCovidInfo()
//    }
//
//    private suspend fun fetchCovidInfo() {
//        covidNetworkDataSource.fetchCovidInfo()
//
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun isFetchCurrentNeeded(lastFetchTime: ZonedDateTime): Boolean {
//        val thirtyMinutesAgo = ZonedDateTime.now().minusMinutes(30)
//        return lastFetchTime.isBefore(thirtyMinutesAgo)
//    }

}