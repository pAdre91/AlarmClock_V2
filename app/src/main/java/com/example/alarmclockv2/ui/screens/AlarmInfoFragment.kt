package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmInfoBinding
import com.example.alarmclockv2.viewModels.AlarmActionViewModel
import com.example.alarmclockv2.viewModels.AlarmInfoViewModel

class AlarmInfoFragment : Fragment(R.layout.fragment_alarm_info) {
    private lateinit var binding: FragmentAlarmInfoBinding
    private val viewModel by viewModels<AlarmInfoViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmInfoBinding.bind(view)

        initTilePickers()

        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_alarmListFragment)
        }

        binding.soundInfoContainer.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_soundSettingsFragment)
        }

        binding.vibrationInfoContainer.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_vibrationSettingsFragment)
        }

        binding.saveAndGoBack.setOnClickListener {

        }
    }

    private fun initTilePickers() {
        binding.minutePicker.minValue = 0
        binding.minutePicker.maxValue = 59

        binding.minutePicker.setFormatter(PickerFormatter())
        binding.horusPicker.setFormatter(PickerFormatter())

        binding.horusPicker.maxValue = 23
        binding.horusPicker.minValue = 0

        binding.horusPicker.value = 6
        binding.minutePicker.value = 0
    }

    companion object {
        const val TIMER_KEY = "timerMS"
    }
}

class PickerFormatter : NumberPicker.Formatter
{
    override fun format(p0: Int): String
    {
        if(p0.toString().length > 1)
            return p0.toString()

        return "0$p0"
    }
}