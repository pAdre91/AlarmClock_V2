package com.example.alarmclockv2.services.impl

import com.example.alarmclockv2.services.interfaces.IVibrationService
import javax.inject.Inject

class VibrationService @Inject constructor() : IVibrationService
{
    override fun play(vibrationPattern: Int, delayMS: Int) {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun getPatternName(vibrationPattern: Int): String {
        return "TODO"
    }
}