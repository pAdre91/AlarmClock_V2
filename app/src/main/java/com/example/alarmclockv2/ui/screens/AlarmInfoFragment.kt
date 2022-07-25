package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmInfoBinding

class AlarmInfoFragment : Fragment(R.layout.fragment_alarm_info)
{
    private lateinit var binding : FragmentAlarmInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmInfoBinding.bind(view)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_alarmListFragment)
        }

        binding.goToSoundSettings.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_soundSettingsFragment)
        }

        binding.goToVibrationSettings.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_vibrationSettingsFragment)
        }
    }
}