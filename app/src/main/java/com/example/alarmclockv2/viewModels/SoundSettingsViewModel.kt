package com.example.alarmclockv2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockv2.services.interfaces.ISoundService
import kotlinx.coroutines.launch
import javax.inject.Inject

class SoundSettingsViewModel : ViewModel()
{
    @Inject
    lateinit var soundService : ISoundService

    private val _songs : MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    val songs : LiveData<List<String>> = _songs

    fun requireSongsList()
    {
        viewModelScope.launch {
            _songs.value = soundService.getAllSounds()
        }
    }

    fun playSong(name : String, volume : Int)
    {
        //soundService.play(name, volume)
    }

    fun stopPlaying()
    {
        //soundService.stop()
    }
}