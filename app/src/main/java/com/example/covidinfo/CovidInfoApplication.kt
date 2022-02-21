package com.example.covidinfo

import android.app.Application
import com.example.covidinfo.data.db.CovidInfoDataBase
import com.example.covidinfo.data.network.*
import com.example.covidinfo.data.repository.CovidInfoRepository
import com.example.covidinfo.data.repository.CovidInfoRepositoryImpl
import com.example.covidinfo.ui.CovidInfoViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class CovidInfoApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@CovidInfoApplication))

        //bind() from singleton { CovidInfoDataBase(instance()) }
        //bind() from singleton { instance<CovidInfoDataBase>().covidInfoDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { CovidApiService(instance()) }
        bind<CovidNetworkDataSource>() with singleton { CovidNetworkDataSourceImpl(instance()) }
        bind<CovidInfoRepository>() with singleton { CovidInfoRepositoryImpl(instance()) }
        bind() from provider { CovidInfoViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}