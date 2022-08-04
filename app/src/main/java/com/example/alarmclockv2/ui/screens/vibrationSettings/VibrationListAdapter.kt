package com.example.alarmclockv2.ui.screens.vibrationSettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmclockv2.databinding.SelectListItemBinding

class VibrationListAdapter(
    private val clickAction: IVibrateItemClickAction,
    private var actualPattern : String
) : RecyclerView.Adapter<VibrateItemViewHolder>(), View.OnClickListener
{
    var patternsList : List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VibrateItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SelectListItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return VibrateItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VibrateItemViewHolder, position: Int) {
        with(holder.binding)
        {
            item.text = patternsList[position]
            root.tag = patternsList[position]
            item.isChecked = (actualPattern == patternsList[position])
        }
    }

    override fun getItemCount(): Int {
        return patternsList.size
    }

    override fun onClick(p0: View) {
        val soundName = p0.tag as String
        actualPattern = soundName

        notifyDataSetChanged()
        clickAction.onVibrateItemClickAction(soundName)
    }
}

class VibrateItemViewHolder(val binding : SelectListItemBinding) : RecyclerView.ViewHolder(binding.root)

interface IVibrateItemClickAction
{
    fun onVibrateItemClickAction(patternName : String)
}