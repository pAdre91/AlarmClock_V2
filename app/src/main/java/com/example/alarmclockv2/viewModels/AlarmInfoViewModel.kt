package com.example.alarmclockv2.viewModels

import android.app.PendingIntent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockv2.services.Utils
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import com.example.alarmclockv2.services.interfaces.ISoundService
import com.example.alarmclockv2.services.interfaces.IVibrationService
import kotlinx.coroutines.launch
import javax.inject.Inject

class AlarmInfoViewModel : ViewModel()
{
    @Inject
    lateinit var soundService : ISoundService

    @Inject
    lateinit var vibrationService: IVibrationService

    @Inject
    lateinit var alarmClockService: IAlarmClockService

    private var _currentTimerInfo = MutableLiveData<UserAlarmInfo>()
    val currentTimerInfo : LiveData<UserAlarmInfo> = _currentTimerInfo

    fun requestAlarmClockInfo(timeMS : Long)
    {
        viewModelScope.launch {
            val alarmInfo = alarmClockService.getAlarmClockByTime(timeMS)
            _currentTimerInfo.value = UserAlarmInfo(
                alarmInfo.name,
                Utils.getTimeFromMS(alarmInfo.timeMS),
                soundService.getSoundName(alarmInfo.soundId),
                alarmInfo.isSoundActive,
                alarmInfo.volume,
                vibrationService.getPatternName(alarmInfo.vibratePattern),
                alarmInfo.isVibrateActive
            )
        }
    }

    fun setAlarmClock(alarmInfo: UserAlarmInfo, intent : PendingIntent)
    {
        //TODO не забыть обработать 2 сценария, приновом будильнике и при изменении старого
    }
}

