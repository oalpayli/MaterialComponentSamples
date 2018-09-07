package com.ceng.ozi.bottomAppBar

import android.app.Dialog
import android.os.Bundle
import android.support.design.internal.NavigationMenuView
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.NavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.ceng.ozi.R
import kotlinx.android.synthetic.main.fragment_menu_bottomsheet.*

class BottomNavigationDrawerFragment: BottomSheetDialogFragment(){

    var rootView: View? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_menu_bottomsheet, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menu_navigation_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_play -> Toast.makeText(context!!, "Oynatıldı", Toast.LENGTH_SHORT).show()
                R.id.nav_pause -> Toast.makeText(context!!, "Durduruldu", Toast.LENGTH_SHORT).show()
                R.id.nav_stop -> Toast.makeText(context!!, "Duraklatıldı", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        close_imageview.setOnClickListener {
            this.dismiss()
        }

        disableNavigationViewScrollbars(menu_navigation_view)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog

            val bottomSheet = d.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
            bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset > 0.5) {
                        close_imageview.visibility = View.VISIBLE
                    } else {
                        close_imageview.visibility = View.GONE
                    }
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_HIDDEN-> dismiss()
//                        else -> close_imageview.visibility = View.GONE
                    }
                }
            })
        }

        return dialog
    }

    private fun disableNavigationViewScrollbars(navigationView: NavigationView?) {
        val navigationMenuView = navigationView?.getChildAt(0) as NavigationMenuView
        navigationMenuView.isVerticalScrollBarEnabled = false
    }

}