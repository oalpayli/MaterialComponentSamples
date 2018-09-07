package com.ceng.ozi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ceng.ozi.R
import kotlinx.android.synthetic.main.recyclerview_home_list_item_row.view.*

class HomeListAdapter(val items: MutableList<String>, val context: Context): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_home_list_item_row, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = items[p1]
    }

    class ViewHolder (view: View): RecyclerView.ViewHolder(view){
        val textView = view.textView_RecyclerViewHomeListItemRow!!
    }

}