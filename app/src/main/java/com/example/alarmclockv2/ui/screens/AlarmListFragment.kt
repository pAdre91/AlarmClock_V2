package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmListBinding
import com.example.alarmclockv2.viewModels.AlarmInfoViewModel
import com.example.alarmclockv2.viewModels.AlarmListViewModel

class AlarmListFragment : Fragment(R.layout.fragment_alarm_list)
{
    private lateinit var binding : FragmentAlarmListBinding
    private val viewModel  by viewModels<AlarmListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmListBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goToAlarmInfo.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_alarmInfoFragment)
        }
    }
}