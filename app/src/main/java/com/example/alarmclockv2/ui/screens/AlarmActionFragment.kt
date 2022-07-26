package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmActionBinding
import com.example.alarmclockv2.viewModels.AlarmActionViewModel

class AlarmActionFragment : Fragment(R.layout.fragment_alarm_action)
{
    private lateinit var binding : FragmentAlarmActionBinding
    private val viewModel  by viewModels<AlarmActionViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmActionBinding.bind(view)

        (requireActivity().application as App).appComponent.injectViewModel(viewModel)
        val qwe = viewModel.soundService
    }
}