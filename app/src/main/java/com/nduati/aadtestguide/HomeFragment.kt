package com.nduati.aadtestguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nduati.aadtestguide.adapter.TestGuidelineAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclMain = view.findViewById<RecyclerView>(R.id.testGuidelinesRecycler)
        val adp = TestGuidelineAdapter()
        val lytmng = LinearLayoutManager(activity)
        recyclMain.apply {
            adapter = adp
            setHasFixedSize(true)
            layoutManager = lytmng
        }
    }
}