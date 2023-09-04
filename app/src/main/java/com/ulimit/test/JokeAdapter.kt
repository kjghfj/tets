package com.ulimit.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private val jokes: List<String>) : RecyclerView.Adapter<JokeAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jokeTextView: TextView = itemView.findViewById(R.id.txt_jokedata)
        val jokeDateTime: TextView = itemView.findViewById(R.id.txt_datetime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joke_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jokeTextView.text = jokes[position]
    }

    override fun getItemCount(): Int {
        return jokes.size
    }
}

