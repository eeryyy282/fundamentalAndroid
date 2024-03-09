package com.example.fundamentalandroid.learntablayout

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fundamentalandroid.learntablayout.fragment.HomeFragmentTabLayout
import com.example.fundamentalandroid.learntablayout.fragment.ProfileFragmentTabLayout

class SectionPageAdapter (activity: AppCompatActivity): FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = HomeFragmentTabLayout()
            1 -> fragment = ProfileFragmentTabLayout()
        }
        return fragment as Fragment
    }

}