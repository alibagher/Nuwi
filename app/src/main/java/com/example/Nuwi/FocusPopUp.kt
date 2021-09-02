package com.example.Nuwi

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class FocusPopUp : AppCompatActivity(), OnClickListener{

    private var selected : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focuspopup);

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels.toDouble()
        val height = dm.heightPixels.toDouble()

        window.setLayout(((width*0.9).toInt()), ((0.9*height).toInt()))

        // Set listeners for all buttons.
        val fullbody: Button = findViewById<Button>(R.id.fullbody) as Button
        fullbody.setOnClickListener(this) // calling onClick() method
        val ub: Button = findViewById<View>(R.id.ub) as Button
        ub.setOnClickListener(this)
        val lb: Button = findViewById<View>(R.id.lb) as Button
        lb.setOnClickListener(this)
        val arms: Button = findViewById<View>(R.id.arms) as Button
        arms.setOnClickListener(this)
        val shoulders: Button = findViewById<View>(R.id.shoulders) as Button
        shoulders.setOnClickListener(this)
        val back: Button = findViewById<Button>(R.id.back) as Button
        back.setOnClickListener(this) // calling onClick() method
        val chest: Button = findViewById<View>(R.id.chest) as Button
        chest.setOnClickListener(this)
        val core: Button = findViewById<View>(R.id.core) as Button
        core.setOnClickListener(this)
        val legs: Button = findViewById<View>(R.id.legs) as Button
        legs.setOnClickListener(this)
        val glutes: Button = findViewById<View>(R.id.glutes) as Button
        glutes.setOnClickListener(this)

        selected = fullbody;
        selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
        val intent = Intent()
        intent.putExtra("MESSAGE", "Full Body")
        setResult(RESULT_OK, intent)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.fullbody -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.fullbody) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Full Body")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.ub -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.ub) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Upper Body")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.lb -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.lb) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Lower Body")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.arms -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.arms) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Arms")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.shoulders -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.shoulders) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Shoulders")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.back -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.back) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Back")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.chest -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.chest) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Chest")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.core -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.core) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Core")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.legs -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.legs) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Legs")
                setResult(RESULT_OK, intent)
                finish()
            }
            R.id.glutes -> {
                selected?.setBackgroundColor(getResources().getColor(R.color.purple_500));
                selected = findViewById<Button>(R.id.glutes) as Button;
                selected?.setBackgroundColor(getResources().getColor(R.color.teal_200));
                val intent = Intent()
                intent.putExtra("MESSAGE", "Glutes")
                setResult(RESULT_OK, intent)
                finish()
            }

            else -> {
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