package com.example.lab1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnboardingItems()
        //var viewPager = findViewById<ViewPager2>(R.id.viewPager)
        //viewPager.adapter = MyAdapter()
        //viewPager.registerOnPageChangeCallback()
        //viewPager.setCurrentItem()
    }

    private fun setOnboardingItems(){
        onboardingItemsAdapter = MyAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_long_distance_relationship,
                    title = "Learn anytime and anywhere"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_staying_home,
                    title = "Find a course for you"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_high_tech,
                    title = "Improve your skills"
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.viewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
    }
}