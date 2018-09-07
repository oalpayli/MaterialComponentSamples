package com.ceng.ozi.bottomAppBar

import android.os.Bundle
import android.support.design.bottomappbar.BottomAppBar
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ceng.ozi.R

class BottomAppBarActivity: AppCompatActivity(){

    lateinit var bottomAppBar: BottomAppBar
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var fabButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        fabButton = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomAppBar)
        setSupportActionBar(bottomAppBar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, "BottomNavDrawerFragment")
            }
            R.id.menu_search -> {
                displayMaterialSnackBar("Search Clicked")
            }
            R.id.menu_delete -> {
                displayMaterialSnackBar("Delete Clicked")
            }
        }

        return true
    }

    private fun displayMaterialSnackBar(text: String) {
        val snackbar = Snackbar.make(
                fabButton,
                text,
                Snackbar.LENGTH_LONG
        ).setAction("UNDO") {  }
        snackbar.show()

        /*val marginSide = 0
        val marginBottom = 550
        val snackbar = Snackbar.make(
                fabButton,
                text,
                Snackbar.LENGTH_LONG
        ).setAction("UNDO") {  }
        // Changing message text color
        snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.colorAccent))

        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams

        params.setMargins(
                params.leftMargin + marginSide,
                params.topMargin,
                params.rightMargin + marginSide,
                params.bottomMargin + marginBottom
        )

        snackbarView.layoutParams = params
        snackbar.show()*/
    }

}