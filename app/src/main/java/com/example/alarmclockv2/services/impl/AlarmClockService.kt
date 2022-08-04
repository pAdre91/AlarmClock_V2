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
            System.currentTimeMillis()+10000,
            "name",
            1,
            1,
                isSoundActive = true,
                isVibrateActive = false,
                vibratePattern = 1,
                isActive = true
        ),
            AlarmInfo(
                System.currentTimeMillis()+1000000,
                "name",
                1,
                1,
                isSoundActive = false,
                isVibrateActive = false,
                vibratePattern = 1,
                isActive = false
            )
        )
    }

    override suspend fun getAlarmClockByTime(timeMS: Long): AlarmInfo {
        //TODO if database return null, create AlarmInfo with Default values

        return AlarmInfo(
            System.currentTimeMillis()+10000,
            "name",
            1,
            1,
            isSoundActive = true,
            isVibrateActive = true,
            vibratePattern = 1,
            isActive = true
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
    val isSoundActive : Boolean,
    val isVibrateActive : Boolean,
    val vibratePattern : Int,
    val isActive : Boolean
)