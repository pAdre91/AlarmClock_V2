package com.example.alarmclockv2.services

import java.text.DateFormatSymbols
import java.text.SimpleDateFormat

class Utils
{
    companion object
    {
        private val MILLISECONDS_IN_DAY = 86400000

        fun getTimeFromMS(timeMS: Long) : FormattedTime
        {
            if(timeMS < 0) return FormattedTime()

            val formattedMonth = SimpleDateFormat("MM").format(timeMS)
            val formattedDay = SimpleDateFormat("dd").format(timeMS)
            val formattedHours = SimpleDateFormat("HH").format(timeMS)
            val formattedMinutes = SimpleDateFormat("mm").format(timeMS)

            val month = DateFormatSymbols().months[formattedMonth.toInt()]

            return FormattedTime(
                getFormatTime(formattedMinutes),
                getFormatTime(formattedHours),
                formattedDay,
                month
            )
        }

        private fun getFormatTime(time : String) : String
        {
            if(time.length > 1)
                return time

            return "0$time"
        }

        fun getActualDate(timeMS: Long) : Long
        {
            var result = timeMS

            while (result < System.currentTimeMillis())
            {
                result += MILLISECONDS_IN_DAY
            }

            return result
        }
    }
}

data class FormattedTime(
    val minutes : String,
    val hours : String,
    val day : String,
    val month : String
)
{
    constructor() : this("", "", "", "")
}