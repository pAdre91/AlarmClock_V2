package com.example.alarmclockv2.db

import androidx.room.Dao
import androidx.room.Query
import com.example.alarmclockv2.db.entities.AlarmClockEntity

@Dao
interface AlarmClockDAO
{
    @Query("SELECT * FROM ${AlarmClockEntity.tableName}")
    fun getAllFilms() : List<AlarmClockEntity>
}