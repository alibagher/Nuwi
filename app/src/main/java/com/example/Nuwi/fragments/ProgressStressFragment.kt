package com.example.Nuwi.fragments

//Graph

//import com.github.mikephil.charting.charts.BarChart
//import com.github.mikephil.charting.data.BarData
//import com.github.mikephil.charting.data.BarDataSet
//import com.github.mikephil.charting.data.BarEntry
//import com.github.mikephil.charting.utils.ColorTemplate

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.Nuwi.R
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import java.util.*


//import android.support.v4.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProgressStressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProgressStressFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var vview: View? = null

    // for our graph view.
    var graphView : GraphView? = null;

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
        vview = inflater.inflate(R.layout.fragment_progress_stress, container, false)

        val graphView = vview!!.findViewById<GraphView>(R.id.idGraphView);

        // on below line we are adding data to our graph view.
        // on below line we are adding data to our graph view.
        val series = LineGraphSeries(
            arrayOf<DataPoint>( // on below line we are adding
                // each point on our x and y axis.
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 3.0),
                DataPoint(2.0, 4.0),
                DataPoint(3.0, 9.0),
                DataPoint(4.0, 6.0),
                DataPoint(5.0, 3.0),
                DataPoint(6.0, 6.0),
                DataPoint(7.0, 1.0),
                DataPoint(8.0, 2.0)
            )
        )

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.
        graphView.title = "My Graph View"

        // on below line we are setting
        // text color to our graph view.
        // on below line we are setting
        // text color to our graph view.
        graphView.titleColor = R.color.purple_200

        // on below line we are setting
        // our title text size.

        // on below line we are setting
        // our title text size.
        graphView.titleTextSize = 18f

        // on below line we are adding
        // data series to our graph view.

        // on below line we are adding
        // data series to our graph view.
        graphView.addSeries(series)
        return vview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProgressStressFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProgressStressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}