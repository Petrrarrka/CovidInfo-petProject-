package com.example.covidinfo.data.network.response

import com.example.covidinfo.api.Feature
import com.example.covidinfo.api.Field
import com.example.covidinfo.api.SpatialReference
import com.example.covidinfo.api.UniqueIdField
import com.example.covidinfo.data.db.CovidInfoEntity
import com.example.covidinfo.data.db.toCovidInfoEntity
import com.google.gson.annotations.SerializedName


data class CovidInfoResponse(

    val objectIdFieldName: String,
    val uniqueIdField: UniqueIdField,
    val globalIdFieldName: String,
    val geometryType: String,
    val spatialReference: SpatialReference,
    val fields: List<Field>,
    val features: List<Feature>
)

fun CovidInfoResponse.toCovidInfoEntities(): List<CovidInfoEntity>{
    return this.features.map {
        it.attributes.toCovidInfoEntity()
    }
}