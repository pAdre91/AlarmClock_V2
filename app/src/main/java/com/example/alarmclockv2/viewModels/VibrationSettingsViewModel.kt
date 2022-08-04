package com.example.alarmclockv2.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alarmclockv2.services.interfaces.IVibrationService
import kotlinx.coroutines.launch
import javax.inject.Inject

class VibrationSettingsViewModel : ViewModel()
{
    @Inject
    lateinit var vibrationService: IVibrationService

    private val _vibratePatterns : MutableLiveData<List<String>> = MutableLiveData<List<String>>()
    val vibratePatterns : LiveData<List<String>> = _vibratePatterns

    fun vibrate(patternName : String)
    {

    }

    fun stopVibrate()
    {

    }

    fun requireVibratePatterns()
    {
        viewModelScope.launch {
            _vibratePatterns.value =  vibrationService.getAllVibrationPatterns()
        }
    }
}