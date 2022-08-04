package com.example.alarmclockv2.services.impl

import com.example.alarmclockv2.services.interfaces.ISoundService
import javax.inject.Inject

class SoundService @Inject constructor() : ISoundService
{
    override fun play(soundName: String, volume: Int) {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    //NOTE список может быть большим, лучше сделать постепенное получение через Flow
    override suspend fun getAllSounds(): List<String> {
        return listOf("firstSong", "SecondSong", "ThirdSong")
    }
}