package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmActionBinding

class AlarmActionFragment : Fragment(R.layout.fragment_alarm_action)
{
    private lateinit var binding : FragmentAlarmActionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmActionBinding.bind(view)
    }
}