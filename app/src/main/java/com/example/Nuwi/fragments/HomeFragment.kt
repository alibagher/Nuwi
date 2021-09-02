package com.example.Nuwi.fragments

//import android.support.v4.app.Fragment
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.Nuwi.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

const val EXTRA_MESSAGE = "key1"
const val EXTRA_MESSAGE_TWO = "key2"
const val EXTRA_MESSAGE_TIME = "key3"
const val INTENSITY_PREV_SELECTED = "key4"
const val FOCUS_PREV_SELECTED = "key5"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var vview: View? = null


    var popUp: PopupWindow? = null
    var focusPopUp: PopupWindow? = null


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val message = data?.getStringExtra("MESSAGE")
            println("the message: $message");
            val focusButton = vview!!.findViewById<Button>(R.id.intensityButton);
            focusButton.setText(message);
        } else if (requestCode == 2) {
            val message = data?.getStringExtra("MESSAGE")
            println("the message: $message");
            val focusButton = vview!!.findViewById<Button>(R.id.focusButton);
            focusButton.setText(message);
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            println("onCreate in HomeFragment");
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vview = inflater.inflate(R.layout.fragment_home, container, false)
        //Intensity popup
        val layout = LinearLayout(activity)
        val intensity = vview!!.findViewById<Button>(R.id.intensityButton);
        intensity.setOnClickListener { // Code here executes on main thread after user presses button
//            startActivity(Intent(this, Pop::class.java));
            var requestCode = 1;
            val intent = Intent(getActivity(), Pop::class.java).apply {
                putExtra(INTENSITY_PREV_SELECTED, intensity.text)
            }
            startActivityForResult(intent, requestCode);
        }
        popUp?.contentView = layout;

        // Focus popup
        val focusLayout = LinearLayout(getActivity())
        val focus = vview!!.findViewById<Button>(R.id.focusButton);
        focus.setOnClickListener { // Code here executes on main thread after user presses button;
//            startActivity(Intent(this, FocusPopUp::class.java));
            var requestCode = 2;
            val intent = Intent(getActivity(), FocusPopUp::class.java).apply {
                putExtra(FOCUS_PREV_SELECTED, focus.text)
            }
            startActivityForResult(intent, requestCode);
        }
        focusPopUp?.contentView = focusLayout;


        val seekbar = vview!!.findViewById<SeekBar>(R.id.timeSeekBar);
        val timeText = vview!!.findViewById<TextView>(R.id.timeText);
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
//                if(progress < 3 ){
////                    seekbar.progress = 3;
//                    timeText.text = "3 Minutes"
//                }else {
                timeText.text = (progress + 3).toString() + " Minutes"
//                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

//        // Start Button
//        val startLayout = LinearLayout(activity)
        val start = vview!!.findViewById<Button>(R.id.start);
        start.setOnClickListener { // Code here executes on main thread after user presses button;
//            var requestCode = 2;
//            startActivityForResult(Intent(activity, FocusPopUp::class.java),  requestCode);
            sendMessage(vview!!);
        }
//        focusPopUp?.contentView = focusLayout;
        return vview
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    /** Called when the user taps the Start button */
    fun sendMessage(view: View) {
        // Do something in response to button
        val intensityButton = vview!!.findViewById<Button>(R.id.intensityButton)
        val focusButton = vview!!.findViewById<Button>(R.id.focusButton)
//        val timeText = findViewById<TextView>(R.id.timeText)
        val seekbar = vview!!.findViewById<SeekBar>(R.id.timeSeekBar);

        val intensity = intensityButton.text.toString()
        val focus = focusButton.text.toString()
        val duration = (seekbar.progress + 3).toString()
//        val message = "$intensity=>$focus";

        val intent = Intent(getActivity(), LoadStartActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, intensity)
            putExtra(EXTRA_MESSAGE_TWO, focus)
            putExtra(EXTRA_MESSAGE_TIME, duration)
        }
        startActivity(intent)
    }
}