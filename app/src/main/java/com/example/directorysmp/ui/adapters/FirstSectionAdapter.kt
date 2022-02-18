package com.example.directorysmp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
import com.example.directorysmp.ui.FirstSectionListFragmentDirections

class FirstSectionAdapter() :
    RecyclerView.Adapter<FirstSectionAdapter.FirstSectionViewHolder>() {

    private val chapters = DataSource.directoryItems

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

        holder.textView.text = item.chapter
        holder.textView.setOnClickListener {
            val action =
                FirstSectionListFragmentDirections.actionFirstSectionListFragmentToSecondSectionListFragment(chapter = holder.textView.text.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

}