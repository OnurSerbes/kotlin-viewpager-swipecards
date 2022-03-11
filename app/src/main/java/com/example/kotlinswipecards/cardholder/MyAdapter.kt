package com.example.fameidentitykotlin.View.info.screens.mainfragments.cardholder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.kotlinswipecards.R


class MyAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent,false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)
}