package com.example.alarmclockv2

import android.app.Application
import com.example.alarmclockv2.di.AppComponent
import com.example.alarmclockv2.di.DaggerAppComponent

class App :Application()
{
    val appComponent = DaggerAppComponent.factory().create(this)
}