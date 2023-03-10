package com.example.lab1


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: MyAdapter
    private lateinit var textSkip: TextView
    private lateinit var onboardingViewPager: ViewPager2

    private lateinit var ind1: ImageView
    private lateinit var ind2: ImageView
    private lateinit var ind3: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ind1 = findViewById(R.id.ind1)
        ind2 = findViewById(R.id.ind2)
        ind3 = findViewById(R.id.ind3)

        onboardingItemsAdapter = MyAdapter(
            listOf(
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_long_distance_relationship,
                    title = "Learn anytime\nand anywhere"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_staying_home,
                    title = "Find a course\nfor you"
                ),
                OnboardingItem(
                    onboardingImage = R.drawable.cool_kids_high_tech,
                    title = "Improve your skills"
                )
            )
        )
        onboardingViewPager = findViewById<ViewPager2>(R.id.viewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter

        ind1.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_indicator))
        ind2.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
        ind3.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))

        onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeIndicator()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeIndicator()
            }

        })

        textSkip = findViewById(R.id.textSkip)
        textSkip.setOnClickListener {
            finish()
            val intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }

        val btnNextStep: Button = findViewById(R.id.btnNext)

        btnNextStep.setOnClickListener {
            if (getItem() > onboardingViewPager.childCount){
                finish()
                val intent = Intent(applicationContext, SignUp::class.java)
                startActivity(intent)
            } else {
                onboardingViewPager.setCurrentItem(getItem() + 1, true)
            }
        }

        onboardingViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position == 0){
                    btnNextStep.text = "Next"
                }
                if (position == 1){
                    btnNextStep.text = "Next"
                }
                if (position == 2){
                    btnNextStep.text = "Let's Start"
                }
                super.onPageSelected(position)
            }
        })

    }
    private lateinit var indicatorsContainer: LinearLayout
    fun changeIndicator(){
        when(onboardingViewPager.currentItem){
            0 ->
            {
                ind1.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_indicator))
                ind2.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
                ind3.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
            }
            1 ->
            {
                ind1.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
                ind2.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_indicator))
                ind3.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
            }
            2 ->
            {
                ind1.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
                ind2.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.inactive_indicator))
                ind3.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_indicator))
            }
        }
    }

    private fun getItem(): Int {
        return onboardingViewPager.currentItem
    }

}