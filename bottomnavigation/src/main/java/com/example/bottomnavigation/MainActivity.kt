package com.example.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bottomnavigation.ui.dashboard.DashboardFragment
import com.example.bottomnavigation.ui.home.HomeFragment
import com.example.bottomnavigation.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            val fragment: Fragment
            when(item.itemId){
                R.id.navigation_home->{
                    fragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return true
                }
                R.id.navigation_dashboard->{
                    fragment = DashboardFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return true
                }
                R.id.navigation_notifications->{
                    fragment = NotificationsFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container_layout, fragment, fragment.javaClass.simpleName)
                        .commit()

                    return true
                }
            }
            return false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationSelectedListener)


        if(savedInstanceState == null){
            nav_view.selectedItemId = R.id.navigation_home
        }
    }
}
