package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentVibrationSettingsBinding

class VibrationSettingsFragment : Fragment(R.layout.fragment_vibration_settings)
{
    private lateinit var binding : FragmentVibrationSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVibrationSettingsBinding.bind(view)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_vibrationSettingsFragment_to_alarmInfoFragment)
        }

        binding.saveAndBack.setOnClickListener {

        }
    }
}