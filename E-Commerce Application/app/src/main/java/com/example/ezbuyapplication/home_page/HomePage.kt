package com.example.ezbuyapplication.home_page

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.ezbuyapplication.R
import com.example.ezbuyapplication.TabAdapter
import com.example.ezbuyapplication.profile.ProfileFragment
import com.google.android.material.tabs.TabLayout

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        setUpTabBar()

    }

    private fun setUpTabBar(){

        var tabLayout : TabLayout = findViewById(R.id.tabBarLayout)
        var viewPager : ViewPager = findViewById(R.id.viewPager)

        //Control tab menu function
        viewPager.adapter = TabAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
        })
    }
}