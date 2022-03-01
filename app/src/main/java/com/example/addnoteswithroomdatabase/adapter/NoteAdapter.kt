package com.example.addnoteswithroomdatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.addnoteswithroomdatabase.R
import com.example.addnoteswithroomdatabase.model.Note

class NoteAdapter(var list: ArrayList<Note>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = list[position]
        if (holder is NoteViewHolder) {
            holder.apply {
                holder.tv_note.text = item.text
                holder.tv_time.text = item.date
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tv_note = view.findViewById<TextView>(R.id.tv_message)
        var tv_time = view.findViewById<TextView>(R.id.tv_time)
    }
}