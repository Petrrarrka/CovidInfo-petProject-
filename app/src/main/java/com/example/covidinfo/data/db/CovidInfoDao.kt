package com.example.covidinfo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CovidInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(covidInfoEntity: CovidInfoEntity)

    @Query("SELECT * FROM covid_Info")
    fun getCovidInfo(): LiveData<List<CovidInfoEntity>>

    @Query("SELECT * FROM covid_Info WHERE uID = :ID")
    fun getCovidInfoByID(ID: Int): LiveData<List<CovidInfoEntity>>
}