package com.hvdev.blackcoffer_assignment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hvdev.blackcoffer_assignment.R
import com.hvdev.blackcoffer_assignment.databinding.ActivityMainBinding
import com.hvdev.blackcoffer_assignment.databinding.ActivityRefineBinding

class RefineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRefineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListner()
    }

    private fun addListner() {
        binding.ivSetting.setOnClickListener()
        {
            super.onBackPressed()
        }
    }
}