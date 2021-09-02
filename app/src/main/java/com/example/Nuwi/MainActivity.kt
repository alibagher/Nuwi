package com.example.Nuwi

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.Nuwi.fragments.HomeFragment
import com.example.Nuwi.Onboarding.OnBoardingFragment
import com.example.Nuwi.Onboarding.*
import com.example.Nuwi.fragments.ProgressFragment
import com.example.Nuwi.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentTransaction
//import android.support.v4.app.FragmentManager
//import android.support.v4.app.FragmentPagerAdapter




//const val EXTRA_MESSAGE = "key1"
//const val EXTRA_MESSAGE_TWO = "key2"
//const val EXTRA_MESSAGE_TIME = "key3"


public class MainActivity : AppCompatActivity()  {
//    var popUp: PopupWindow? = null
//    var focusPopUp: PopupWindow? = null
//
    private lateinit var bottomNavigationView: BottomNavigationView;
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1) {
//            val message = data?.getStringExtra("MESSAGE")
//            println("the message: $message");
//            val focusButton = findViewById<Button>(R.id.intensityButton);
//            focusButton.setText(message);
//        }else if (requestCode == 2){
//            val message = data?.getStringExtra("MESSAGE")
//            println("the message: $message");
//            val focusButton = findViewById<Button>(R.id.focusButton);
//            focusButton.setText(message);
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Onboarding
//        PreferenceManager.getDefaultSharedPreferences(this).apply {
//            // Check if we need to display our OnboardingSupportFragment
////            if (!getBoolean(OnBoardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
//                // The user hasn't seen the OnboardingSupportFragment yet, so show it
//                val intent = Intent(this@MainActivity, OnboardingActivity::class.java);
//                startActivity(intent)
////            }
//        }



        bottomNavigationView=findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener{
//            override public boolean onNavigationItemSelected(MenuItem menuItem){
//                return false;
//            }
            var fragment : Fragment? = null;
            when (it.itemId) {
                R.id.settings -> {
                    fragment = SettingsFragment();
                }
                R.id.home -> {
                    fragment = HomeFragment();
                }
                R.id.progress -> {
                    fragment = ProgressFragment();
                    println("Progress selected");
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!).commit();
            true
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit();
        bottomNavigationView.getMenu().getItem(1).setChecked(true);

//        supportFragmentManager.beginTransaction().replace(R.id.container, Insights()).commit();

//        //Intensity popup
//        val layout = LinearLayout(this)
//        val intensity = findViewById<Button>(R.id.intensityButton);
//        intensity.setOnClickListener { // Code here executes on main thread after user presses button
////            startActivity(Intent(this, Pop::class.java));
//            var requestCode = 1;
//            startActivityForResult(Intent(this, Pop::class.java),  requestCode);
//        }
//        popUp?.contentView = layout;
//
//        // Focus popup
//        val focusLayout = LinearLayout(this)
//        val focus = findViewById<Button>(R.id.focusButton);
//        focus.setOnClickListener { // Code here executes on main thread after user presses button;
////            startActivity(Intent(this, FocusPopUp::class.java));
//            var requestCode = 2;
//            startActivityForResult(Intent(this, FocusPopUp::class.java),  requestCode);
//        }
//        focusPopUp?.contentView = focusLayout;
//
//
//        val seekbar = findViewById<SeekBar>(R.id.timeSeekBar);
//        val timeText = findViewById<TextView>(R.id.timeText);
//        seekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
//            override fun onProgressChanged(seekBar: SeekBar, progress: Int, b: Boolean) {
////                if(progress < 3 ){
//////                    seekbar.progress = 3;
////                    timeText.text = "3 Minutes"
////                }else {
//                    timeText.text = (progress + 3).toString() + " Minutes"
////                }
//            }
//            override fun onStartTrackingTouch(seekBar: SeekBar) {}
//            override fun onStopTrackingTouch(seekBar: SeekBar) {}
//        })
//
////        // Focus popup
////        val startLayout = LinearLayout(this)
////        val start = findViewById<Button>(R.id.start);
////        start.setOnClickListener { // Code here executes on main thread after user presses button;
////            var requestCode = 2;
////            startActivityForResult(Intent(this, FocusPopUp::class.java),  requestCode);
////        }
////        focusPopUp?.contentView = focusLayout;

    }

//    private fun bottomNavMethod (btm:BottomNavigationView.OnNavigationItemSelectedListener){
//
//    }

//    /** Called when the user taps the Start button */
//    fun sendMessage(view: View) {
//        // Do something in response to button
//        val intensityButton = findViewById<Button>(R.id.intensityButton)
//        val focusButton = findViewById<Button>(R.id.focusButton)
////        val timeText = findViewById<TextView>(R.id.timeText)
//        val seekbar = findViewById<SeekBar>(R.id.timeSeekBar);
//
//        val intensity = intensityButton.text.toString()
//        val focus = focusButton.text.toString()
//        val duration = (seekbar.progress+3).toString()
////        val message = "$intensity=>$focus";
//
//        val intent = Intent(this, LoadStartActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, intensity)
//            putExtra(EXTRA_MESSAGE_TWO, focus)
//            putExtra(EXTRA_MESSAGE_TIME, duration)
//        }
//        startActivity(intent)
//    }
}

//private fun FragmentTransaction.replace(container: Int, insights: Insights.Companion): FragmentTransaction {
//
//}
