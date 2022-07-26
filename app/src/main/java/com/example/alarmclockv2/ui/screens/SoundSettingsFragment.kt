package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentSoundSettingsBinding
import com.example.alarmclockv2.viewModels.AlarmListViewModel
import com.example.alarmclockv2.viewModels.SoundSettingsViewModel

class SoundSettingsFragment : Fragment(R.layout.fragment_sound_settings)
{
    private lateinit var binding : FragmentSoundSettingsBinding
    private val viewModel  by viewModels<SoundSettingsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSoundSettingsBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_soundSettingsFragment_to_alarmInfoFragment)
        }

        binding.saveAndBack.setOnClickListener {

        }
    }
}