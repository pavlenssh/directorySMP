package com.example.directorysmp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R

class FirstSectionAdapter() :
    RecyclerView.Adapter<FirstSectionAdapter.FirstSectionViewHolder>() {

    private val chapters: List<String> = listOf(
        "АНЕСТЕЗИОЛОГИЯ и РЕАНИМАТОЛОГИЯ",
        "Токсикология",
        "Токсикология (детская)",
        "Кардиология"
    )

    class FirstSectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text_view_item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstSectionViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return FirstSectionViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: FirstSectionViewHolder,
        position: Int
    ) {
        val item = chapters[position]

        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

}