package com.example.ludex_crypta

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ProfileSettingsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileFragment()
            1 -> SettingsFragment()
            else -> {
                throw IllegalStateException("Invalid position in FragmentStateAdapter")
            }
        }
    }
}