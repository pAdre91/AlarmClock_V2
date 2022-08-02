package com.example.alarmclockv2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    private val _nearestTimer = MutableLiveData<DisplayTimerInfo>()
    var nearestTimer : LiveData<DisplayTimerInfo> = _nearestTimer

    fun getAlarmClockList()
    {
        viewModelScope.launch {
            val alarmsInfo = alarmClockService.getAllAlarmClocks()

            val displayTimerList : MutableList<DisplayTimerInfo> = mutableListOf()
            alarmsInfo.forEach {
                displayTimerList.add(
                        DisplayTimerInfo(
                        it.timeMS,
                        it.name,
                        getTimeFromMS(it.timeMS),
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
            val alarmInfo = alarmClockService.getNearestAlarmClock()

            _nearestTimer.value = DisplayTimerInfo(
                alarmInfo.timeMS,
                alarmInfo.name,
                getTimeFromMS(alarmInfo.timeMS),
                alarmInfo.isActive
            )
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

    private fun getTimeFromMS(timeMS: Long) : FormattedTime //TODO вынести в утилиты
    {
        val formattedMonth = SimpleDateFormat("MM").format(timeMS)
        val formattedDay = SimpleDateFormat("dd").format(timeMS)
        val formattedHours = SimpleDateFormat("HH").format(timeMS)
        val formattedMinutes = SimpleDateFormat("mm").format(timeMS)

        val month = DateFormatSymbols().months[formattedMonth.toInt()]

        return FormattedTime(
            getFormatTime(formattedMinutes),
            getFormatTime(formattedHours),
            formattedDay,
            month
        )
    }

    private fun getFormatTime(time : String) : String    //TODO вынести в утилиты
    {

        if(time.length > 1)
            return time

        return "0$time"

    }
}

data class DisplayTimerInfo(
    val timeMS : Long,
    val name : String,
    val formattedTime : FormattedTime,
    val isActive : Boolean
)

data class FormattedTime(
    val minutes : String,
    val hours : String,
    val day : String,
    val month : String
)