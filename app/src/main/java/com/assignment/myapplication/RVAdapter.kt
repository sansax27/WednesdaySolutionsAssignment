package com.assignment.myapplication

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter: RecyclerView.Adapter<RVAdapter.TestViewHolder>() {

    inner class TestViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
        fun bind() {
            val content = view.findViewById<TextView>(R.id.content)
            when {
                adapterPosition==0 -> {
                    content.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    content.text = "Alphabets"
                    content.setTypeface(null, Typeface.BOLD)
                }
                adapterPosition<=26 -> {
                    content.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                    val letter:Char = 'a'+(adapterPosition-1)
                    content.text = letter.toString()
                    content.setTypeface(null, Typeface.NORMAL)
                }
                adapterPosition==27 -> {
                    content.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    content.text = "Numbers"
                    content.setTypeface(null, Typeface.BOLD)
                }
                else -> {
                    content.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                    content.setTypeface(null, Typeface.NORMAL)
                    content.text = (adapterPosition-27).toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom, parent, false))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 54
    }
}