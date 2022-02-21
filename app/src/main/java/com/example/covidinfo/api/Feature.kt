package com.example.covidinfo.api

import com.example.covidinfo.data.db.CovidInfoEntity
import com.google.gson.annotations.SerializedName


data class Feature(
    val attributes: Attributes,
    val geometry: Geometry
)