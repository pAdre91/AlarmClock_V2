package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import javax.inject.Inject

class AlarmListViewModel : ViewModel()
{
    @Inject
    lateinit var alarmClockService: IAlarmClockService
}