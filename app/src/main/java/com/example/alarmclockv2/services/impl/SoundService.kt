package com.example.alarmclockv2.services.impl

import com.example.alarmclockv2.services.interfaces.ISoundService
import javax.inject.Inject

class SoundService @Inject constructor() : ISoundService
{
    override fun play(soundId: Int, volume: Int) {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun getSoundName(soundId: Int): String {
        return "TODO"
    }
}