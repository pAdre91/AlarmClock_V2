package com.example.alarmclockv2.ui.screens.vibrationSettings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentVibrationSettingsBinding
import com.example.alarmclockv2.viewModels.CurrentAlarmClockViewModel
import com.example.alarmclockv2.viewModels.VibrationSettingsViewModel

class VibrationSettingsFragment : Fragment(R.layout.fragment_vibration_settings)
{
    private lateinit var binding : FragmentVibrationSettingsBinding
    private val viewModel  by viewModels<VibrationSettingsViewModel>()
    private val sharedViewModel by activityViewModels<CurrentAlarmClockViewModel>()
    private lateinit var adapter : VibrationListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVibrationSettingsBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            viewModel.stopVibrate()
            findNavController().navigateUp()
        }

        adapter = VibrationListAdapter( object : IVibrateItemClickAction {
            override fun onVibrateItemClickAction(patternName: String) {
                viewModel.stopVibrate()
                viewModel.vibrate(patternName)
                sharedViewModel.currentTimer.vibrationPatternName = patternName
            }
        }, sharedViewModel.currentTimer.vibrationPatternName)

        binding.patternsList.layoutManager = LinearLayoutManager(requireContext())
        binding.patternsList.adapter = adapter

        viewModel.vibratePatterns.observe(viewLifecycleOwner) {
            adapter.patternsList = it
        }

        viewModel.requireVibratePatterns()
    }
}