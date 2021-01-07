package com.nduati.aadtestguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nduati.aadtestguide.R
import com.nduati.aadtestguide.TestCategories

class TestGuidelineAdapter() : RecyclerView.Adapter<TestGuidelineAdapter.GuidelineViewHolder>() {
    class GuidelineViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val CategoryTitleText : TextView = view.findViewById(R.id.categoryTitleTextView)
        val categoryContainer : CardView = view.findViewById(R.id.CategoryContainerCardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuidelineViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.test_guidline_recycler_items,parent, false)
        return GuidelineViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuidelineViewHolder, position: Int) {
        holder.CategoryTitleText.text = TestCategories().get(position).cat
        holder.categoryContainer.setOnClickListener {
            it.findNavController().navigate(TestCategories()[position].nav_id)
        }
    }

    override fun getItemCount(): Int {
        return TestCategories().size
    }
}