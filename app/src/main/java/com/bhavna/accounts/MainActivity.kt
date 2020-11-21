package com.bhavna.accounts

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bhavna.accounts.ui.dashboard.DashboardFragment
import com.bhavna.accounts.ui.home.HomeFragment
import com.bhavna.accounts.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val homeFragment = HomeFragment()
        val dashboardFragment = DashboardFragment()
        val notificationsFragment = NotificationsFragment()

        loadFragment(homeFragment, "HomeFragment")

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->loadFragment(homeFragment, "HomeFragment")
                R.id.navigation_dashboard->loadFragment(dashboardFragment, "DashboardFragment")
                R.id.navigation_notifications->loadFragment(notificationsFragment, "NotificationsFragment")

            }
            true
        }

        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        var sp = findViewById<Spinner>(R.id.spinner)
        var accounts = arrayListOf<String>("Divya Traders", "Saibaba")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, accounts)
        adapter.setDropDownViewResource(R.layout.dropdown_item)
        sp.adapter = adapter
        toolbar.setNavigationOnClickListener { view ->
            finish()
        }
    }

    private fun loadFragment(fragment: Fragment, TAG: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_framelayout, fragment, TAG)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

}