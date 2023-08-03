package com.hvdev.blackcoffer_assignment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainPagerAdapter(fragmentActivity: FragmentActivity, var fragmentList: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }
}
