package com.example.Nuwi

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.Nuwi.fragments.INTENSITY_PREV_SELECTED


class Pop : AppCompatActivity(), OnClickListener {

    private var selected : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intensitypopup);


        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels.toDouble()
        val height = dm.heightPixels.toDouble()

        window.setLayout(((width*0.9).toInt()), ((0.9*height).toInt()))

        // Set listeners for all buttons.
        val advanced: Button = findViewById<Button>(R.id.advanced) as Button
        advanced.setOnClickListener(this) // calling onClick() method
        val intermediate: Button = findViewById<View>(R.id.intermediate) as Button
        intermediate.setOnClickListener(this)
        val beginner: Button = findViewById<View>(R.id.beginner) as Button
        beginner.setOnClickListener(this)

        // Get and set the selection
        val intensity = intent.getStringExtra(INTENSITY_PREV_SELECTED)
        when (intensity) {
            "Advanced" ->{
                selected = advanced;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
            }
            "Intermediate" ->{
                selected = intermediate;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
            }
            "Beginner" ->{
                selected = beginner;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
            }
        }

        val intent = Intent()
        intent.putExtra("MESSAGE", "Advanced")
        setResult(RESULT_OK, intent)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.advanced -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.advanced) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Advanced")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.intermediate -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.intermediate) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Intermediate")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.beginner -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.beginner) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Beginner")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("MESSAGE", selected!!.text)
        setResult(RESULT_OK, intent)
        finish()
    }

}
