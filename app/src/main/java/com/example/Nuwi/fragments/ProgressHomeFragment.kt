package com.example.Nuwi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.Nuwi.Adapters.CustomAdapter
import com.example.Nuwi.Adapters.DataModel
import com.example.Nuwi.R
import com.google.android.material.tabs.TabLayout


//import android.support.v4.app.Fragment
//import android.support.v4.view.ViewPager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProgressHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProgressHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var vview: View? = null
    var listView: ListView? = null
    var textView: TextView? = null

    var dataModels: ArrayList<DataModel>? = null
    private var adapter: CustomAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var inflater: LayoutInflater? = null;
    var container: ViewGroup? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("reached homeFrag onCreateView");
        if(vview == null) {
            println("inside if statement vview == null");
            this.container = container;
            this.inflater = inflater;
            // Inflate the layout for this fragment
            vview = inflater.inflate(R.layout.fragment_progress_home, container, false)
            listView = vview!!.findViewById<ListView>(R.id.list_view)
            textView = vview!!.findViewById<TextView>(R.id.textView)

            // create a custom adapter that populates the list View.
            listView = vview!!.findViewById(R.id.list_view) as ListView
            dataModels = ArrayList()
            dataModels!!.add(DataModel("Exercise Target", 4))
            dataModels!!.add(DataModel("Sleep Target", 5))
            dataModels!!.add(DataModel("Stress Target", 5))

            adapter = CustomAdapter(
                activity!!.getApplicationContext(),
                activity!!.supportFragmentManager,
                dataModels!!
            )
            listView!!.adapter = adapter;

            // Switch to the next tab when clicked.
            listView!!.setOnItemClickListener(AdapterView.OnItemClickListener() { adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
                println("NAme: " + dataModels!![i].getName());
                var tabLayout = activity!!.findViewById<TabLayout>(R.id.tab_layout);
                tabLayout.getTabAt(i + 1)!!.select()
            });
        }

        return vview!!
//        return inflater.inflate(R.layout.fragment_progress_home, container, false)
    }

//    override fun onResume(){
//        super.onResume()
//        vview = inflater!!.inflate(R.layout.fragment_progress_home, container, false)
//        listView = vview!!.findViewById<ListView>(R.id.list_view)
//        textView = vview!!.findViewById<TextView>(R.id.textView)
//        // create a custom adapter that populates the list View.
//        listView = vview!!.findViewById(R.id.list_view) as ListView
//        dataModels = ArrayList()
//        dataModels!!.add(DataModel("Exercise Target", 4))
//        dataModels!!.add(DataModel("Sleep Target", 5))
//        dataModels!!.add(DataModel("Stress Target", 5))
//        adapter = CustomAdapter(activity!!.getApplicationContext(), dataModels!!)
//        listView!!.adapter = adapter
//    }

        // TODO: This might be wrong. the menu is the bottom menu.
//    override fun onCreateOptionsMenu(menu: Menu, inflator :MenuInflater) {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        inflator.inflate(R.menu.menu, menu)
//        setHasOptionsMenu(true);//Make sure you have this line of code.
////        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        val id: Int = item.getItemId()
//        return if (id == R.id.action_settings) {
//            true
//        } else super.onOptionsItemSelected(item)
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProgressHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProgressHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}