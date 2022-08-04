package com.example.alarmclockv2.ui.screens.soundSettings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alarmclockv2.databinding.SoundItemBinding

class SoundListAdapter(
    private val clickAction: ISoundItemClickAction,
    private var actualSound : String
    ) : RecyclerView.Adapter<SoundItemViewHolder>(), View.OnClickListener
{
    var soundsList : List<String> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SoundItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return SoundItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundItemViewHolder, position: Int) {
        with(holder.binding)
        {
            soundItem.text = soundsList[position]
            root.tag = soundsList[position]
            soundItem.isChecked = (actualSound == soundsList[position])
        }
    }

    override fun getItemCount(): Int {
        return soundsList.size
    }

    override fun onClick(p0: View) {
        val soundName = p0.tag as String
        actualSound = soundName

        notifyDataSetChanged()
        clickAction.onSoundItemClickAction(soundName)
    }
}

class SoundItemViewHolder(val binding : SoundItemBinding) : RecyclerView.ViewHolder(binding.root)

interface ISoundItemClickAction
{
    fun onSoundItemClickAction(soundName : String)
}