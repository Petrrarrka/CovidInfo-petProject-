package com.example.covidinfo.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.covidinfo.ui.CountriesListFragment
import com.example.covidinfo.ui.WatchListFragment

class ViewPagerAdapter(fragment: FragmentManager, lifeCycle: Lifecycle)
    : FragmentStateAdapter(fragment, lifeCycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CountriesListFragment()
            1 -> WatchListFragment()
            else -> CountriesListFragment()
        }
    }
}
