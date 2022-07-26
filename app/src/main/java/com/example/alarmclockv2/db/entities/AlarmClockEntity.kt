package com.example.alarmclockv2.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AlarmClockEntity.tableName)
data class AlarmClockEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val timeMS : Long,
    val name : String,
    val soundId : Int,
    val isVibrate : Boolean,
    val isActive : Boolean
)
{
    companion object
    {
        const val tableName = "alarm_clock_table"
    }
}