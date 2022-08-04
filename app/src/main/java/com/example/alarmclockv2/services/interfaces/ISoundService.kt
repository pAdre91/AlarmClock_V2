package com.example.alarmclockv2.services.interfaces

interface ISoundService
{
    fun play(soundName : String, volume : Int)
    fun stop()

    suspend fun getAllSounds() : List<String>
}