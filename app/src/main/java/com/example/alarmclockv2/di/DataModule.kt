package com.example.alarmclockv2.di

import android.content.Context
import androidx.room.Room
import com.example.alarmclockv2.db.AlarmClockDAO
import com.example.alarmclockv2.db.AlarmClockDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule
{
    @Singleton
    @Provides
    fun providesDataBase(context: Context) : AlarmClockDAO
    {
        return Room.databaseBuilder(context, AlarmClockDatabase::class.java, AlarmClockDatabase.dataBaseName).build().alarmClockDAO()
    }
}