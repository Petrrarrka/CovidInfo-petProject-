package com.example.covidinfo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CovidInfoEntity::class],
    version = 1
)
abstract class CovidInfoDataBase: RoomDatabase() {
    abstract fun covidInfoDao(): CovidInfoDao

    companion object{
        @Volatile private var instance : CovidInfoDataBase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDataBase(context).also { instance = it }
        }

        private fun buildDataBase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                CovidInfoDataBase::class.java, "covidInfo.db").build()

    }
}