package com.example.covidinfo.api

import com.example.covidinfo.data.db.CovidInfoEntity
import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("OBJECTID")
    var oBJECTID: Int, // 1
    @SerializedName("Country_Region")
    var countryRegion: String, // Afghanistan
    @SerializedName("Last_Update")
    var lastUpdate: Long, // 1643286073000
    @SerializedName("Lat")
    var lat: Double?, // 33.93911
    @SerializedName("Long_")
    var long: Double?, // 67.709953
    @SerializedName("Confirmed")
    var confirmed: Int?, // 161004
    @SerializedName("Deaths")
    var deaths: Int?, // 7403
    @SerializedName("Recovered")
    var recovered: Int?, // null
    @SerializedName("Active")
    var active: Int?, // null
    @SerializedName("Incident_Rate")
    var incidentRate: Double?, // 413.590705034155
    @SerializedName("People_Tested")
    var peopleTested: Int?, // null
    @SerializedName("People_Hospitalized")
    var peopleHospitalized: Int?, // null
    @SerializedName("Mortality_Rate")
    var mortalityRate: Double?, // 4.59802240938113
    @SerializedName("UID")
    var uID: Int, // 4
    @SerializedName("ISO3")
    var iSO3: String? // AFG
)



