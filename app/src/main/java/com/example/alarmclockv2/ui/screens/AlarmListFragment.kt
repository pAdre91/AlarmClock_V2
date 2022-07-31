package com.example.alarmclockv2.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmListBinding
import com.example.alarmclockv2.viewModels.AlarmListViewModel
import java.text.DateFormatSymbols

class AlarmListFragment : Fragment(R.layout.fragment_alarm_list)
{
    private lateinit var binding : FragmentAlarmListBinding
    private val viewModel  by viewModels<AlarmListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmListBinding.bind(view)
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.addAlarmClockButton.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_alarmInfoFragment)
        }

        displayNearestTimer()
        displayTimersList()
    }

    private fun displayNearestTimer()
    {
        val alarmDate = viewModel.getNearestAlarmDate()
        val nearestAlarmTime = StringBuilder()

        nearestAlarmTime.append(alarmDate.hours).append(" ").append(resources.getString(R.string.hour)).append(" ")
            .append(alarmDate.minutes).append(" ").append(resources.getString(R.string.minutes))
        binding.nearestAlarmClockTime.text = nearestAlarmTime

        val nearestAlarmDate = StringBuilder()
        val dfs = DateFormatSymbols().months
        nearestAlarmDate.append(alarmDate.day).append(" ").append(dfs[alarmDate.month])
        binding.nearestAlarmClockDate.text = nearestAlarmDate

    }

    private fun displayTimersList()
    {

    }

    private fun switchTimerActive()     //Изменить принимаемое значение
    {

    }

    private fun removeTimers()     //Изменить принимаемое значение, реализацию оставить на потом
    {

    }

    private fun getLocalizedMonth(monthNumber : Int) : String
    {
        return ""
    }
}