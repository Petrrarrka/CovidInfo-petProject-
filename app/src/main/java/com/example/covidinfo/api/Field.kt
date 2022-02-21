package com.example.covidinfo.api


data class Field(
    val name: String,
    val type: String,
    val alias: String,
    val sqlType: String,
    val domain: Any,
    val defaultValue: Any,
    val length: Int
)