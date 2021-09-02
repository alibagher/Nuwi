package com.example.Nuwi.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.Nuwi.R

import androidx.leanback.app.OnboardingSupportFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var COMPLETED_ONBOARDING_PREF_NAME = false

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardingFragment : OnboardingSupportFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var vview: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("before inflate")
        vview = inflater.inflate(R.layout.fragment_on_boarding, container, false)
        println("after inflate" + vview)
        return vview;
    }

    override fun getPageCount(): Int {
        println("getPageCount")
        return 0;
    }

    override fun getPageTitle(pageIndex: Int): CharSequence {
        println("getPageTitle")
        return "test Page";
    }

    override fun getPageDescription(pageIndex: Int): CharSequence {
        println("getPageDescription")
        return "description needs to be updated."
    }

    override fun onCreateBackgroundView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        println("onCreateBackgroundView")
        return null;
    }

    override fun onCreateContentView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        println("onCreateContentView")
        return inflater!!.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onCreateForegroundView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        println("onCreateForegroundView")
        return null;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OnBoardingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OnBoardingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}