package com.example.alarmclockv2.ui.screens.soundSettings

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentSoundSettingsBinding
import com.example.alarmclockv2.viewModels.CurrentAlarmClockViewModel
import com.example.alarmclockv2.viewModels.SoundSettingsViewModel

class SoundSettingsFragment : Fragment(R.layout.fragment_sound_settings)
{
    private lateinit var binding : FragmentSoundSettingsBinding
    private val viewModel  by viewModels<SoundSettingsViewModel>()
    private val sharedViewModel by activityViewModels<CurrentAlarmClockViewModel>()
    private lateinit var adapter : SoundListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSoundSettingsBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            viewModel.stopPlaying()
            findNavController().navigateUp()
        }

        adapter = SoundListAdapter(object : ISoundItemClickAction {
            override fun onSoundItemClickAction(soundName: String) {
                viewModel.stopPlaying()
                viewModel.playSong(soundName, sharedViewModel.currentTimer.soundVolume)
                sharedViewModel.currentTimer.soundName = soundName
            }
        }, sharedViewModel.currentTimer.soundName)

        binding.soundsList.layoutManager = LinearLayoutManager(requireContext())
        binding.soundsList.adapter = adapter

        viewModel.songs.observe(viewLifecycleOwner) {
            adapter.soundsList = it
        }

        binding.soundVolumeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    sharedViewModel.currentTimer.soundVolume = p1
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}
            }
        )

        binding.soundVolumeBar.progress = sharedViewModel.currentTimer.soundVolume
        viewModel.requireSongsList()
    }
}