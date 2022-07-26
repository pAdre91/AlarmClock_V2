package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.model.IAlarmClockStorage
import com.example.alarmclockv2.services.interfaces.ISoundService
import com.example.alarmclockv2.services.interfaces.IVibrationService
import javax.inject.Inject

class AlarmActionViewModel : ViewModel()
{
    @Inject
    lateinit var soundService : ISoundService

    @Inject
    lateinit var vibrationService: IVibrationService

    @Inject
    lateinit var storage : IAlarmClockStorage

    fun playAlarmClock(id : Int)
    {

    }
}