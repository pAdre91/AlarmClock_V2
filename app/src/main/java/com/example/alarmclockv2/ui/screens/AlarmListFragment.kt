package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmListBinding

class AlarmListFragment : Fragment(R.layout.fragment_alarm_list)
{
    private lateinit var binding : FragmentAlarmListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmListBinding.bind(view)

        binding.goToAlarmInfo.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_alarmInfoFragment)
        }
    }
}