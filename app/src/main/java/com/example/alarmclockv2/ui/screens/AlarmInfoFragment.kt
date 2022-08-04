package com.example.alarmclockv2.ui.screens

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmInfoBinding
import com.example.alarmclockv2.viewModels.AlarmInfoViewModel
import com.example.alarmclockv2.viewModels.CurrentAlarmClockViewModel
import com.example.alarmclockv2.viewModels.UserAlarmInfo

class AlarmInfoFragment : Fragment(R.layout.fragment_alarm_info) {
    private lateinit var binding: FragmentAlarmInfoBinding
    private val viewModel by viewModels<AlarmInfoViewModel>()
    private val sharedViewModel by activityViewModels<CurrentAlarmClockViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmInfoBinding.bind(view)

        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.goBack.setOnClickListener {
            sharedViewModel.cleanAlarmClock()
            findNavController().navigateUp()
        }

        binding.soundInfoContainer.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_soundSettingsFragment)
        }

        binding.vibrationInfoContainer.setOnClickListener {
            findNavController().navigate(R.id.action_alarmInfoFragment_to_vibrationSettingsFragment)
        }

        binding.saveAndGoBack.setOnClickListener {
            viewModel.setAlarmClock(sharedViewModel.currentTimer, getAlarmAction())
            sharedViewModel.cleanAlarmClock()
            findNavController().navigateUp()
        }

        viewModel.currentTimerInfo.observe(viewLifecycleOwner) {
            setAlarmClockInfo(it)
        }

        val timerMS = requireArguments().getLong(TIMER_KEY)
        if(!sharedViewModel.isAlarmClockChanged() && timerMS != 0L) {
            viewModel.requestAlarmClockInfo(timerMS)
        }
        else
        {
            setAlarmClockInfo(sharedViewModel.currentTimer)
        }
    }

    private fun setAlarmClockInfo(info : UserAlarmInfo)
    {
        initTimePickers(info.formattedTime.hours.toInt(), info.formattedTime.minutes.toInt())

        binding.alarmClockName.setText(info.timerName)

        binding.soundName.text = info.soundName
        binding.isSoundActive.isChecked = info.isSoundActive
        binding.isSoundActive.setOnClickListener {
            sharedViewModel.currentTimer.isSoundActive = binding.isSoundActive.isChecked
        }

        binding.vibrationPatternName.text = info.vibrationPatternName
        binding.isVibrationActive.isChecked = info.isVibrationActive
        binding.isVibrationActive.setOnClickListener {
            sharedViewModel.currentTimer.isVibrationActive = binding.isVibrationActive.isChecked
        }

        sharedViewModel.currentTimer = info
    }

    //TODO написать нормальную реализацию при реализации будильника
    private fun getAlarmAction() : PendingIntent
    {
        val alarmAction = Intent(requireContext(), AlarmActionFragment::class.java)

        return PendingIntent.getActivity(requireContext(), 1, alarmAction,0)
    }

    private fun initTimePickers(hours : Int, minutes : Int) {
        binding.minutePicker.minValue = 0
        binding.minutePicker.maxValue = 59

        binding.minutePicker.setFormatter(PickerFormatter())
        binding.horusPicker.setFormatter(PickerFormatter())

        binding.horusPicker.maxValue = 23
        binding.horusPicker.minValue = 0

        binding.horusPicker.value = hours
        binding.minutePicker.value = minutes
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