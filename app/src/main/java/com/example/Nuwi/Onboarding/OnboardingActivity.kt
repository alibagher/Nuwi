package com.example.Nuwi.Onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.Nuwi.R


class OnboardingActivity :  AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        if (savedInstanceState == null) {
            var newFragment = OnBoardingFragment();
            println("after OnBoardingFragment()")
            supportFragmentManager.beginTransaction().replace(R.id.container, newFragment).commit();
            println("after supportFragmentManager")
        }
    }
}