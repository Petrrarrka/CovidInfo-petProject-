package com.example.covidinfo.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covidinfo.R
import com.example.covidinfo.data.db.CovidInfoEntity

class RecyclerAdapter(
    private val dataList: List<CovidInfoEntity>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(dataList[position])


    }

    override fun getItemCount(): Int = dataList.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val countryRegion = itemView.findViewById<TextView>(R.id.country)
        private val countOfCauses = itemView.findViewById<TextView>(R.id.description)
        private val flag = itemView.findViewById<ImageView>(R.id.flag)

        @SuppressLint("SetTextI18n")
        fun bindView(covidInfoEntity: CovidInfoEntity) {
            covidInfoEntity.let {
                countryRegion.text = it.countryRegion
                countOfCauses.text = "Active causes: " + it.confirmed.toString()
                flag.setImageResource(R.mipmap.ic_launcher_round)
            }


        }

        init {
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}

