package com.example.alarmclockv2.viewModels

import androidx.lifecycle.ViewModel
import com.example.alarmclockv2.services.interfaces.IVibrationService
import javax.inject.Inject

class VibrationSettingsViewModel : ViewModel()
{
    @Inject
    lateinit var vibrationService: IVibrationService
}