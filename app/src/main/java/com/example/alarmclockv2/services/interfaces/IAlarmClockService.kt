package com.example.alarmclockv2.services.interfaces

import android.content.Intent
import com.example.alarmclockv2.services.impl.AlarmInfo

interface IAlarmClockService
{
    suspend fun getAllAlarmClocks() : List<AlarmInfo>
    suspend fun setTimer(timeMS : Long, intent : Intent, alarmInfo: AlarmInfo)
    suspend fun removeTimer(timeMS : Long)
}