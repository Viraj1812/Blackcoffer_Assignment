package com.hvdev.blackcoffer_assignment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hvdev.blackcoffer_assignment.adapter.MainPagerAdapter
import com.hvdev.blackcoffer_assignment.databinding.ActivityMainBinding
import com.hvdev.blackcoffer_assignment.fragment.Business
import com.hvdev.blackcoffer_assignment.fragment.Merchant
import com.hvdev.blackcoffer_assignment.fragment.Personal
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentList: ArrayList<Fragment>
    private var tabTitle = arrayOf("Personal", "Business", "Merchant")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        setViewpagerAdapter()
        addListner()
    }

    private fun addListner() {
        binding.refine.setOnClickListener(){
            val intent = Intent(this, RefineActivity::class.java)
            startActivity(intent)
        }
    }

    private fun init() {
        fragmentList = ArrayList<Fragment>()
        fragmentList.add(Personal())
        fragmentList.add(Business())
        fragmentList.add(Merchant())
    }

    private fun setViewpagerAdapter() {
        val pagerAdapter = MainPagerAdapter(this, fragmentList)
        binding.viewpagerMain.adapter = pagerAdapter
        binding.viewpagerMain.isUserInputEnabled = true
        TabLayoutMediator(binding.tabMain, binding.viewpagerMain) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }
}