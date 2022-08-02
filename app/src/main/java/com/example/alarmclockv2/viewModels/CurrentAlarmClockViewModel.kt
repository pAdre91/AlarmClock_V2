package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.FormattedTime

class CurrentAlarmClockViewModel : ViewModel()
{
    var currentTimer : UserAlarmInfo = UserAlarmInfo()

//    fun setAlarmClockName(newName : String)
//    {
//        currentTimer.timerName = newName
//    }
//
//    fun setAlarmClockTime(newTime : FormattedTime)
//    {
//        currentTimer.formattedTime = newTime
//    }
//
//    fun setAlarmClockSoundName(newSoundName: String)
//    {
//        currentTimer.soundName = newSoundName
//    }
//
//    fun setAlarmClockSoundActivity(isActive : Boolean)
//    {
//        currentTimer.isSoundActive = isActive
//    }
//
//    fun setAlarmClockSoundVolume(newSoundVolume : Int)
//    {
//        //TODO добавить проверку на корректность значения
//
//        currentTimer.soundVolume = newSoundVolume
//    }
//
//    fun setAlarmClockVibrationPatternName(newPatternName : String)
//    {
//        currentTimer.vibrationPatternName = newPatternName
//    }
//
//    fun setAlarmClockVibrationActivity(isActive : Boolean)
//    {
//        currentTimer.isVibrationActive = isActive
//    }

    fun cleanAlarmClock()
    {
        currentTimer = UserAlarmInfo()
    }
}

data class UserAlarmInfo(
    var timerName : String,
    var formattedTime: FormattedTime,

    var soundName : String,
    var isSoundActive : Boolean,
    var soundVolume : Int,

    var vibrationPatternName : String,
    var isVibrationActive : Boolean
)
{
    constructor() : this(
        "",
        FormattedTime(),
        "DefaultAlarmClockValues.",
        false,
        0,
        "",
        false
        )
}