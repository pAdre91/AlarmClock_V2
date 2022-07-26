package com.example.alarmclockv2.di

import android.content.Context
import com.example.alarmclockv2.di.modules.AppBindModule
import com.example.alarmclockv2.services.interfaces.IAlarmClockService
import com.example.alarmclockv2.viewModels.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppBindModule::class, DataModule::class])
interface AppComponent
{
    fun injectViewModel(viewModel : AlarmActionViewModel)
    fun injectViewModel(viewModel : AlarmInfoViewModel)
    fun injectViewModel(viewModel : AlarmListViewModel)
    fun injectViewModel(viewModel : SoundSettingsViewModel)
    fun injectViewModel(viewModel : VibrationSettingsViewModel)

    fun injectService(service : IAlarmClockService)

    @Component.Factory
    interface Factory
    {
        fun create(@BindsInstance context: Context): AppComponent
    }
}