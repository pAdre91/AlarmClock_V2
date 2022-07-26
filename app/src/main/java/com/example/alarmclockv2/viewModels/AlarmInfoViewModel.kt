package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import com.example.alarmclockv2.services.interfaces.ISoundService
import com.example.alarmclockv2.services.interfaces.IVibrationService
import javax.inject.Inject

class AlarmInfoViewModel : ViewModel()
{
    @Inject
    lateinit var soundService : ISoundService

    @Inject
    lateinit var vibrationService: IVibrationService

    @Inject
    lateinit var alarmClockService: IAlarmClockService

    fun getAlarmClockInfo(id : Int) : UsersAlarmInfo
    {
        TODO()
    }
}

data class UsersAlarmInfo(
    val soundName : String,
    val vibrationPatternName : String,
    val timerTime : Time
)

data class Time(
    val hours : Int,
    val minutes : Int
)