package com.example.alarmclockv2.ui.screens.timersList

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmclockv2.App
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.FragmentAlarmListBinding
import com.example.alarmclockv2.ui.screens.AlarmInfoFragment
import com.example.alarmclockv2.viewModels.AlarmListViewModel
import com.example.alarmclockv2.viewModels.FormattedTime

class AlarmListFragment : Fragment(R.layout.fragment_alarm_list)
{
    private lateinit var binding : FragmentAlarmListBinding
    private val viewModel  by viewModels<AlarmListViewModel>()
    private lateinit var adapter : AlarmListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlarmListBinding.bind(view)
        initScreen()

        getNearestTimer()
        getTimersList()
    }

    private fun initScreen()
    {
        (requireActivity().application as App).appComponent.injectViewModel(viewModel)

        binding.addAlarmClockButton.setOnClickListener {
            findNavController().navigate(R.id.action_alarmListFragment_to_alarmInfoFragment)
        }

        adapter = AlarmListAdapter(
            object : IAlarmItemClickAction {
                override fun onAlarmClicked(timeMS: Long) {
                    findNavController().navigate(R.id.action_alarmListFragment_to_alarmInfoFragment,
                        bundleOf(
                            Pair(AlarmInfoFragment.TIMER_KEY, timeMS)
                        )
                    )
                }

                override fun onAlarmSwitchClicked(timeMS: Long, isActive: Boolean) {
                    viewModel.switchTimerActive(timeMS, isActive)
                }
            }
        )
        binding.alarmClockListContainer.adapter = adapter
        binding.alarmClockListContainer.layoutManager = LinearLayoutManager(requireContext())

        viewModel.timersInfoList.observe(viewLifecycleOwner) {
            adapter.timersList = it
        }

        viewModel.nearestTimer.observe(viewLifecycleOwner) {
            displayNearestTimer(it.formattedTime)
        }
    }

    private fun displayNearestTimer(alarmDate : FormattedTime)
    {
        val nearestAlarmTime = StringBuilder()

        nearestAlarmTime.append(alarmDate.hours).append(" ").append(resources.getString(R.string.hour)).append(" ")
            .append(alarmDate.minutes).append(" ").append(resources.getString(R.string.minutes))
        binding.nearestAlarmClockTime.text = nearestAlarmTime

        val nearestAlarmDate = StringBuilder()
        nearestAlarmDate.append(alarmDate.day).append(" ").append(alarmDate.month)
        binding.nearestAlarmClockDate.text = nearestAlarmDate

    }

    private fun getTimersList()
    {
        viewModel.getAlarmClockList()
    }

    private fun getNearestTimer()
    {
        viewModel.getNearestTimer()
    }

    private fun removeTimer(timeMS: Long)     //Изменить принимаемое значение, реализацию оставить на потом
    {
        viewModel.removeTimer(timeMS)
    }
}