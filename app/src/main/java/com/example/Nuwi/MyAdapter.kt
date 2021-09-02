package com.example.Nuwi

//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
//import android.support.v4.app.FragmentPagerAdapter
//import com.example.Nuwi.fragments.ProgressExerciseFragment
//import com.example.Nuwi.fragments.ProgressHomeFragment
//import com.example.Nuwi.fragments.ProgressSleepFragment
//import com.example.Nuwi.fragments.ProgressStressFragment

import androidx.fragment.app.*
import com.example.Nuwi.fragments.ProgressExerciseFragment
import com.example.Nuwi.fragments.ProgressHomeFragment
import com.example.Nuwi.fragments.ProgressSleepFragment
import com.example.Nuwi.fragments.ProgressStressFragment

class  MyAdapter(val myContext: FragmentActivity, fm: FragmentManager?, var totalTabs: Int ) : FragmentStatePagerAdapter(fm!!) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return (when (position) {
            0 -> {
                ProgressHomeFragment()
            }
            1 -> {
                ProgressExerciseFragment()
            }
            2 -> {
                ProgressSleepFragment()
            }
            3 -> {
                ProgressStressFragment()
            }
            else -> ProgressHomeFragment()
        } as Fragment?)!!
//        return ProgressHomeFragment()
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }

    private val tabTitles = arrayOf("Home", "Exercise", "Sleep", "Stress")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles.get(position)
    }

}