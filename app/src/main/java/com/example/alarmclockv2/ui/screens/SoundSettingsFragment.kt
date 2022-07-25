package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentSoundSettingsBinding

class SoundSettingsFragment : Fragment(R.layout.fragment_sound_settings)
{
    private lateinit var binding : FragmentSoundSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSoundSettingsBinding.bind(view)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_soundSettingsFragment_to_alarmInfoFragment)
        }

        binding.saveAndBack.setOnClickListener {

        }
    }
}