package com.example.sofie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sofie.R
import com.example.sofie.model.Data
import com.example.sofie.model.TaskItem

class MainAdpter(private val list: TaskItem):RecyclerView.Adapter<MainAdpter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdpter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate( R.layout.task_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdpter.ViewHolder, position: Int) {
        holder.bind(list.data[position])
    }

    override fun getItemCount(): Int {
        return list.data.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(task:Data)= with(itemView) {

            findViewById<TextView>(R.id.tvTaskEmail).text = task.email
            findViewById<TextView>(R.id.tvTaskTitle).text =task.title

        }

    }

}