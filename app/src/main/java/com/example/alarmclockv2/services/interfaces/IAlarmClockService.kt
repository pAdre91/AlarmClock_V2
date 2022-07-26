package com.example.alarmclockv2.services.interfaces

import android.content.Intent
import com.example.alarmclockv2.services.impl.AlarmInfo

interface IAlarmClockService
{
    fun getAllAlarmClocks() : List<AlarmInfo>
    fun setTimer(timeMS : Long, intent : Intent, alarmInfo: AlarmInfo)
    fun removeTimer(timeMS : Long)
}