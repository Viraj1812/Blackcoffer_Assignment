package com.hvdev.blackcoffer_assignment.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hvdev.blackcoffer_assignment.R
import com.hvdev.blackcoffer_assignment.adapter.PostListAdapter
import com.hvdev.blackcoffer_assignment.databinding.FragmentPersonalBinding
import com.hvdev.blackcoffer_assignment.model.PostData

class Personal : Fragment() {

    private lateinit var postData: ArrayList<PostData>
    private lateinit var binding: FragmentPersonalBinding
    private lateinit var activity: Activity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalBinding.inflate(inflater, container, false)

        activity = requireActivity()

        init()
        setCaptionListAdapter()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        activity = context as Activity
    }

    private fun init() {
        postData = ArrayList()
        val data = listOf(
            PostData("John", "New York", "Reading, hiking", "Looking for adventure", R.drawable.temp),
            PostData(
                "Sarah",
                "Chicago",
                "Yoga, movies",
                "Just seeing what's out there",
                R.drawable.temp
            ),
            PostData("Mark", "Miami", "Surfing", "Love the beach vibe", R.drawable.temp),
            PostData("Mark", "Miami", "Surfing", "Love the beach vibe", R.drawable.temp),
            PostData("Mark", "Miami", "Surfing", "Love the beach vibe", R.drawable.temp),
            PostData("Mark", "Miami", "Surfing", "Love the beach vibe", R.drawable.temp)
        )

        postData.addAll(data)
    }

    private fun setCaptionListAdapter() {

        binding.rvCaptionList.layoutManager = LinearLayoutManager(activity)
        val adapter = PostListAdapter(activity,postData)
        binding.rvCaptionList.adapter = adapter

    }

}