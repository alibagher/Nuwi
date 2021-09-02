package com.example.Nuwi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.Nuwi.*

//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
//import android.support.v4.app.FragmentPagerAdapter


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProgressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProgressFragment : Fragment()  {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var vview: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            println("reached onCreate in progressFragment");
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        println("reached onCreateView");
        if (vview == null) {
            // Inflate the layout for this fragment
            vview = inflater.inflate(R.layout.fragment_progress, container, false)
        }

            tabLayout = vview!!.findViewById<TabLayout>(R.id.tab_layout);
            viewPager = vview!!.findViewById<ViewPager>(R.id.pager);
            tabLayout!!.addTab(tabLayout!!.newTab().setText("Home"))
            tabLayout!!.addTab(tabLayout!!.newTab().setText("Exercise"))
            tabLayout!!.addTab(tabLayout!!.newTab().setText("Sleep"))
            tabLayout!!.addTab(tabLayout!!.newTab().setText("Stress"))
            tabLayout!!.setTabGravity(TabLayout.GRAVITY_FILL);

            var adapter =
                MyAdapter(activity!!, activity!!.getSupportFragmentManager(), tabLayout!!.tabCount)
            viewPager!!.adapter = adapter;

            viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
            tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager!!.currentItem = tab.position
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })

        return vview
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProgressFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProgressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}