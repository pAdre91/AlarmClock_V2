package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import javax.inject.Inject

class AlarmListViewModel : ViewModel()
{
    @Inject
    lateinit var alarmClockService: IAlarmClockService

    fun getAlarmClockList() : List<DisplayTimerInfo>
    {
        return emptyList()
    }

    fun getNearestAlarmDate() : FormattedDate
    {
        return FormattedDate(12,5, 1, 2)
    }

    fun switchTimerActive(timeMS: Long, isActive : Boolean)
    {

    }

    fun removeTimer(timeMS : Long)
    {

    }
}

data class DisplayTimerInfo(
    val timeMS : Long,
    val name : String,
    val formattedTime : FormattedDate,
    val isActive : Boolean
)

data class FormattedDate(
    val minutes : Int,
    val hours : Int,
    val day : Int,
    val month : Int
)