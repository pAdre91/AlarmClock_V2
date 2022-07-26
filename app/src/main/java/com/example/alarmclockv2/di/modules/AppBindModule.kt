package com.example.alarmclockv2.di.modules

import com.example.alarmclockv2.model.AlarmClockStorage
import com.example.alarmclockv2.model.IAlarmClockStorage
import com.example.alarmclockv2.services.impl.AlarmClockService
import com.example.alarmclockv2.services.impl.SoundService
import com.example.alarmclockv2.services.impl.VibrationService
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import com.example.alarmclockv2.services.interfaces.ISoundService
import com.example.alarmclockv2.services.interfaces.IVibrationService
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule
{
    @Binds
    fun getSoundService(soundService: SoundService) : ISoundService

    @Binds
    fun getVibrationService(vibrationService: VibrationService) : IVibrationService

    @Binds
    fun getAlarmClockService(alarmClockService: AlarmClockService) : IAlarmClockService

    @Binds
    fun getAlarmClockStorage(storage: AlarmClockStorage) : IAlarmClockStorage
}