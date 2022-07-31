package com.example.alarmclockv2.services.impl

import android.content.Intent
import com.example.alarmclockv2.model.IAlarmClockStorage
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import javax.inject.Inject

class AlarmClockService @Inject constructor() : IAlarmClockService
{
    @Inject
    lateinit var storage : IAlarmClockStorage


    override suspend fun getAllAlarmClocks(): List<AlarmInfo> {
        return listOf(
            AlarmInfo(
            System.currentTimeMillis(),
            "name",
            1,
            1,
            false,
            1,
            false
        ),
            AlarmInfo(
                System.currentTimeMillis(),
                "name",
                1,
                1,
                false,
                1,
                true
            )
        )
    }

    override suspend fun getNearestAlarmClock(): AlarmInfo {
        return  AlarmInfo(
            System.currentTimeMillis(),
            "name",
            1,
            1,
            false,
            1,
            true
        )
    }

    override suspend fun setTimer(timeMS: Long, intent: Intent, alarmInfo: AlarmInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun switchTimerActive(timeMS: Long, isActive: Boolean) {
        //TODO
    }

    override suspend fun removeTimer(timeMS: Long) {
        TODO("Not yet implemented")
    }
}

data class AlarmInfo(
    val timeMS : Long,
    val name : String,
    val soundId : Int,
    val volume : Int,
    val isVibrate : Boolean,
    val vibratePattern : Int,
    val isActive : Boolean
)