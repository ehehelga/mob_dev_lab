package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val onboardingItems: List<OnboardingItem>):RecyclerView.Adapter<PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_intro, parent, false),
        )
    }

    override fun getItemCount(): Int {
        return onboardingItems.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
    holder.bind(onboardingItems[position])
    }
}
class PagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val imageOnboarding = itemView.findViewById<ImageView>(R.id.imageOnboarding)
    private val textTitle = itemView.findViewById<TextView>(R.id.textTitle)

    fun bind(onboardingItem: OnboardingItem){
        imageOnboarding.setImageResource(onboardingItem.onboardingImage)
        textTitle.text= onboardingItem.title
    }
}