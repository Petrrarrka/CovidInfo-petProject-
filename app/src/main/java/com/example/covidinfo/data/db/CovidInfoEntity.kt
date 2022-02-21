package com.example.covidinfo.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.covidinfo.api.Attributes
import com.example.covidinfo.data.network.response.CovidInfoResponse
import com.google.gson.annotations.SerializedName

@Entity(tableName = "covid_Info")
data class CovidInfoEntity(
    @SerializedName("objectID")
    val ObjectID: Int,
    @SerializedName("country_Region")
    val countryRegion: String,
    @SerializedName("last_Update")
    val lastUpdate: Long,
    @SerializedName("latitude")
    val lattitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("confirmed")
    val confirmed: Int?,
    @SerializedName("deaths")
    val deaths: Int?,
    @SerializedName("recovered")
    val recovered: Int?,
    @SerializedName("active")
    val active: Int?,
    @SerializedName("incident_Rate")
    val incidentRate: Double?,
    @SerializedName("people_Tested")
    val peopleTested: Int?,
    @SerializedName("people_Hospitalized")
    val peopleHospitalized: Int?,
    @SerializedName("mortality_Rate")
    val mortalityRate: Double?,
    @SerializedName("uID")
    @PrimaryKey
    val uID: Int,
    @SerializedName("iSO3")
    val iSO3: String?
)

fun Attributes.toCovidInfoEntity(): CovidInfoEntity =
    CovidInfoEntity(
        ObjectID = oBJECTID,
        countryRegion = countryRegion,
        lastUpdate = lastUpdate,
        lattitude = lat,
        longitude = long,
        confirmed = confirmed,
        deaths = deaths,
        recovered = recovered,
        active = active,
        incidentRate = incidentRate,
        peopleTested = peopleTested,
        peopleHospitalized = peopleHospitalized,
        mortalityRate = mortalityRate,
        uID = uID,
        iSO3 = iSO3
    )

