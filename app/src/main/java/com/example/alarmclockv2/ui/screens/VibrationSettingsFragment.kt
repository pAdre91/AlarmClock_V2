package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentVibrationSettingsBinding
import com.example.alarmclockv2.viewModels.AlarmListViewModel
import com.example.alarmclockv2.viewModels.VibrationSettingsViewModel

class VibrationSettingsFragment : Fragment(R.layout.fragment_vibration_settings)
{
    private lateinit var binding : FragmentVibrationSettingsBinding
    private val viewModel  by viewModels<VibrationSettingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentVibrationSettingsBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_vibrationSettingsFragment_to_alarmInfoFragment)
        }

        binding.saveAndBack.setOnClickListener {

        }
    }
}