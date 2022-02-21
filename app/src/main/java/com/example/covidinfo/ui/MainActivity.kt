package com.example.covidinfo.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.example.covidinfo.R
import com.example.covidinfo.ui.adapters.ViewPagerAdapter
import com.example.covidinfo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = resources.getColor(R.color.green)
        val tabTitle = arrayOf(getString(R.string.countries_list), getString(R.string.watch_list))

        binding.viewPager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager2){
            tab, position ->
                tab.text = tabTitle[position]
        }.attach()

    }
}