package com.example.covidinfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covidinfo.R
import com.example.covidinfo.databinding.ActivityMainBinding
import com.example.covidinfo.databinding.ActivityCountryInfoBinding

class CountryInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityCountryInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryInfoBinding.inflate(layoutInflater)
        window.statusBarColor = resources.getColor(R.color.green)
        val intent = this.intent

        binding.countryName.text = intent.getCharSequenceExtra("countryRegion")
        binding.confimedValue.text = intent.getCharSequenceExtra("confirmed")
        binding.deathValue.text = intent.getCharSequenceExtra("deaths")
        binding.mortalityRateValue.text = intent.getCharSequenceExtra("mortalityRate")
        binding.incidentRateValue.text = intent.getCharSequenceExtra("incidentRate")
        binding.lastUpdateValue.text = intent.getCharSequenceExtra("lastUpdate")
        binding.longitudeValue.text = intent.getCharSequenceExtra("longitude")
        binding.latitudeValue.text = intent.getCharSequenceExtra("latitude")
        setContentView(binding.root)
    }
}

