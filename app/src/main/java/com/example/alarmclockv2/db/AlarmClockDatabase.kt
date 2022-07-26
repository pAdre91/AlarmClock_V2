package com.example.alarmclockv2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.alarmclockv2.db.entities.AlarmClockEntity

@Database(entities = [AlarmClockEntity::class], version = 1)
abstract class AlarmClockDatabase() : RoomDatabase()
{
    abstract fun alarmClockDAO() : AlarmClockDAO

    companion object
    {
        val dataBaseName = "alarm_clock_storage_database"
    }
}