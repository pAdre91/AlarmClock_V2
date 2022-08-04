package com.example.alarmclockv2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockv2.services.FormattedTime
import com.example.alarmclockv2.services.Utils
import com.example.alarmclockv2.services.impl.AlarmInfo
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import kotlinx.coroutines.launch
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import javax.inject.Inject

class AlarmListViewModel : ViewModel()
{
    @Inject
    lateinit var alarmClockService: IAlarmClockService

    private val _timersInfoList = MutableLiveData<List<DisplayTimerInfo>>()
    val timersInfoList : LiveData<List<DisplayTimerInfo>> = _timersInfoList

    private val _nearestTimer = MutableLiveData<FormattedTime>()
    var nearestTimer : LiveData<FormattedTime> = _nearestTimer

    fun getAlarmClockList()
    {
        viewModelScope.launch {
            val alarmsInfo = alarmClockService.getAllAlarmClocks()

            val displayTimerList : MutableList<DisplayTimerInfo> = mutableListOf()
            alarmsInfo.forEach {
                displayTimerList.add(
                        DisplayTimerInfo(
                        Utils.getActualDate(it.timeMS),
                        it.name,
                        Utils.getTimeFromMS(it.timeMS),
                        it.isActive
                    )
                )
            }
            _timersInfoList.value = displayTimerList
        }
    }

    fun getNearestTimer()
    {
        viewModelScope.launch {
            val alarmInfo = alarmClockService.getAllAlarmClocks()
            if(alarmInfo.isEmpty()) return@launch

            var nearestTimer: AlarmInfo? = alarmInfo.firstOrNull { it.isActive } ?: return@launch

            alarmInfo.forEach {
                if(it.isActive && it.timeMS < nearestTimer!!.timeMS)
                    nearestTimer = it
            }

            val timeToTimer = nearestTimer!!.timeMS - System.currentTimeMillis()
            _nearestTimer.value = Utils.getTimeFromMS(timeToTimer)
        }
    }

    fun switchTimerActive(timeMS: Long, isActive : Boolean)
    {
        viewModelScope.launch {
            alarmClockService.switchTimerActive(timeMS, isActive)
        }
    }

    fun removeTimer(timeMS : Long)
    {
        viewModelScope.launch {
            alarmClockService.removeTimer(timeMS)
        }
    }
}

data class DisplayTimerInfo(
    val timeMS : Long,
    val name : String,
    val formattedTime : FormattedTime,
    val isActive : Boolean
)

