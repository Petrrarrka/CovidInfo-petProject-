package com.example.covidinfo.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidinfo.data.db.CovidInfoEntity
import com.example.covidinfo.databinding.FragmentCountriesListBinding

import com.example.covidinfo.ui.adapters.RecyclerAdapter
import com.example.covidinfo.ui.base.ScopedFragment
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance
import java.text.SimpleDateFormat
import java.util.*


class CountriesListFragment : ScopedFragment(), KodeinAware, RecyclerAdapter.OnItemClickListener {
    override val kodein by closestKodein()
    lateinit var binding: FragmentCountriesListBinding
    private val viewModelFactory: CovidInfoViewModelFactory by instance()
    private lateinit var viewModel: CovidInfoViewModel
    private var covidList = mutableListOf<CovidInfoEntity>()
    private val recycleAdapter = RecyclerAdapter(covidList, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CovidInfoViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = launch {
        val covidInfo = viewModel.covid.await()
        covidInfo.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer
            covidList.addAll(it)
            binding.progressBar.visibility = View.GONE
            binding.loading.visibility = View.GONE
            Log.i("tag", "bindUI: ${covidList[5].active}")
        })

        binding.countriesList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = recycleAdapter

        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onItemClick(position: Int) {
        val intent = Intent(context, CountryInfoActivity::class.java)
        intent.putExtra("countryRegion", covidList[position].countryRegion)
        intent.putExtra("confirmed", "Causes: ${covidList[position].confirmed.toString()}")
        intent.putExtra("deaths", "Deaths: ${covidList[position].deaths.toString()}")
        intent.putExtra("mortalityRate", covidList[position].mortalityRate.toString())
        intent.putExtra("incidentRate", covidList[position].incidentRate.toString())
        intent.putExtra("latitude", covidList[position].lattitude.toString())
        intent.putExtra("longitude", covidList[position].longitude.toString())
        val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = covidList[position].lastUpdate
        intent.putExtra("lastUpdate", formatter.format(calendar.time))
        startActivity(intent)

    }
}