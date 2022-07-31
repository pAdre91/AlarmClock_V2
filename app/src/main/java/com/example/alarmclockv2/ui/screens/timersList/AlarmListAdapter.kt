package com.example.alarmclockv2.ui.screens.timersList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmclockv2.R
import com.example.alarmclockv2.databinding.AlarmClockItemBinding
import com.example.alarmclockv2.viewModels.DisplayTimerInfo

class AlarmListAdapter(private val clickAction : IAlarmItemClickAction) : RecyclerView.Adapter<AlarmClockItemViewHolder>(), View.OnClickListener
{
    var timersList : List<DisplayTimerInfo> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmClockItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AlarmClockItemBinding.inflate(inflater, parent, false)

        binding.isAlarmClockActive.setOnClickListener(this)
        binding.root.setOnClickListener(this)

        return AlarmClockItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmClockItemViewHolder, position: Int) {
        val timer = timersList[position]
        with(holder.binding)
        {
            alarmClockName.text = timer.name
            if(timer.name.isEmpty())
                alarmClockName.visibility = View.GONE

            val alarmTime = StringBuilder()
            alarmTime.append(timer.formattedTime.hours).append(":").append(timer.formattedTime.minutes)
            alarmClockTime.text = alarmTime

            isAlarmClockActive.isChecked = timer.isActive

            isAlarmClockActive.tag = timer
            root.tag = timer
        }
    }

    override fun getItemCount(): Int {
        return timersList.count()
    }

    override fun onClick(v: View) {
        val timer = v.tag as DisplayTimerInfo

        when(v.id)
        {
            R.id.isAlarmClockActive -> {
                clickAction.onAlarmSwitchClicked(timer.timeMS, (v as SwitchCompat).isChecked)
            }

            else -> {
                clickAction.onAlarmClicked(timer.timeMS)
            }
        }
    }
}

class AlarmClockItemViewHolder(val binding : AlarmClockItemBinding) : RecyclerView.ViewHolder(binding.root)

interface IAlarmItemClickAction
{
    fun onAlarmClicked(timeMS : Long)
    fun onAlarmSwitchClicked(timeMS : Long, isActive : Boolean)
}