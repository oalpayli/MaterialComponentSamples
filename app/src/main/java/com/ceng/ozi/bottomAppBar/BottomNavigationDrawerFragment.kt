package com.ceng.ozi.bottomAppBar

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.NavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ceng.ozi.R

class BottomNavigationDrawerFragment: BottomSheetDialogFragment(){

    var rootView: View? = null
    lateinit var navigationView: NavigationView



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_menu_bottomsheet, container, false)
        navigationView = rootView!!.findViewById(R.id.menu_navigation_view)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_play -> Toast.makeText(context!!, "Oynatıldı", Toast.LENGTH_SHORT).show()
                R.id.nav_pause -> Toast.makeText(context!!, "Durduruldu", Toast.LENGTH_SHORT).show()
                R.id.nav_stop -> Toast.makeText(context!!, "Duraklatıldı", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

}