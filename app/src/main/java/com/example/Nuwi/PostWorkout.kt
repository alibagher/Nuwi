package com.example.Nuwi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PostWorkout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.postworkout)

        val intensity = intent.getStringExtra(EXTRA_MESSAGE)
        val focus = intent.getStringExtra(EXTRA_MESSAGE_TWO)
        val duration = intent.getStringExtra(EXTRA_MESSAGE_TIME)

        val description1 = findViewById<TextView>(R.id.Description1);
        description1.text = "You just did a "
        val description2 = findViewById<TextView>(R.id.Description2);
        description2.text = duration + " min " + intensity + " " + focus + "workout"
        val description3 = findViewById<TextView>(R.id.Description3);
        description3.text = "and burned about - calories."
        val randomFact = findViewById<TextView>(R.id.randomFact);
        randomFact.text = "That's enough to power a toaster for - minutes"


        val finish = findViewById<Button>(R.id.finish);
        finish.setOnClickListener{
            finish();
        }
    }
}
