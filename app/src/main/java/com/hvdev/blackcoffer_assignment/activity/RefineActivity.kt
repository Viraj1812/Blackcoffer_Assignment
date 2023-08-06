package com.hvdev.blackcoffer_assignment.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hvdev.blackcoffer_assignment.R
import com.hvdev.blackcoffer_assignment.databinding.ActivityMainBinding
import com.hvdev.blackcoffer_assignment.databinding.ActivityRefineBinding

class RefineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRefineBinding
    private lateinit var availability: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListner()
        fetchSpinnerValues()
        initializeSpinners()
    }

    private fun addListner() {
        binding.ivSetting.setOnClickListener()
        {
            super.onBackPressed()
        }
        binding.ivSetting.setOnClickListener()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchSpinnerValues() {
        binding.spGender.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                availability = adapterView?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    private fun initializeSpinners() {
        val availabilityAdapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            resources.getStringArray(R.array.availability)
        )
        binding.spGender.adapter = availabilityAdapter
    }
}