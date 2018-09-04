package com.ceng.ozi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ceng.ozi.adapter.HomeListAdapter
import com.ceng.ozi.bottomAppBar.BottomAppBarActivity
import com.ceng.ozi.ext.ItemClickSupport

class HomeActivity : AppCompatActivity(), ItemClickSupport.OnItemClickListener {

    lateinit var recyclerView: RecyclerView

    val array: MutableList<String> = mutableListOf("Bottom App Bar", "Bottom Navigation", "Bottom Sheets", "Chips", "Collapsing Toolbars", "Float Action Button", "Material Button", "Modal Bottom Sheets",
            "Navigation Views", "Snackbars", "Tab Layout", "Text Fields", "Top App Bar", "Extended Fab Button")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = HomeListAdapter(array, this)

        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(this)

    }

    override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
        when(position){
            0 -> startActivity(Intent(this, BottomAppBarActivity::class.java))
        }
    }

}
