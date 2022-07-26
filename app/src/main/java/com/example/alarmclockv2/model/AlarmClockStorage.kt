package com.example.alarmclockv2.model

import com.example.alarmclockv2.db.AlarmClockDAO
import javax.inject.Inject

class AlarmClockStorage @Inject constructor() : IAlarmClockStorage
{
    @Inject
    lateinit var alarmClockDB : AlarmClockDAO
}