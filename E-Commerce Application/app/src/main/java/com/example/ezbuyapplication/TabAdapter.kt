package com.example.ezbuyapplication

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ezbuyapplication.home_page.HomeRecyclerViewFragment
import com.example.ezbuyapplication.profile.FragmentContainerProfile
import com.example.ezbuyapplication.promotion.PromotionRecyclerViewFragment

@Suppress("DEPRECATION")
internal class TabAdapter(var context: Context,
                          fragment: FragmentManager,
                          private var totalTabs: Int) :
    FragmentPagerAdapter(fragment, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {

        return when (position){
            0 -> HomeRecyclerViewFragment()

            1 -> PromotionRecyclerViewFragment()

            2 -> FragmentContainerProfile()

            else -> getItem(position)
        }
    }
}