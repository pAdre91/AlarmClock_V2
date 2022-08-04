package com.example.alarmclockv2.services.interfaces

interface IVibrationService
{
    fun play(vibrationPattern : Int, delayMS : Int)
    fun stop()
    fun getPatternName(vibrationPattern : Int) : String
    suspend fun getAllVibrationPatterns() : List<String>
}