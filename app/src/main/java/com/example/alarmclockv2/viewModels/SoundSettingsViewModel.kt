package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.interfaces.ISoundService
import javax.inject.Inject

class SoundSettingsViewModel : ViewModel()
{
    @Inject
    lateinit var soundService : ISoundService
}