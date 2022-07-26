package com.example.alarmclockv2.services.interfaces

interface ISoundService
{
    fun play(soundId : Int, volume : Int)
    fun stop()
    fun getSoundName(soundId : Int) : String
}