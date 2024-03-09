package com.example.fundamentalandroid.learntablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fundamentalandroid.learntablayout.fragment.HomeFragmentTabLayout
import com.example.fundamentalandroid.learntablayout.fragment.ProfileFragmentTabLayout

class SectionPageAdapter (activity: AppCompatActivity): FragmentStateAdapter(activity){

    var appName: String = ""
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
       val fragment = HomeFragmentTabLayout()
        fragment.arguments = Bundle().apply {
            putInt(HomeFragmentTabLayout.ARG_SECTION_NUMBER, position + 1)
            putString(HomeFragmentTabLayout.ARG_NAME, appName)
        }
        return fragment
    }

}