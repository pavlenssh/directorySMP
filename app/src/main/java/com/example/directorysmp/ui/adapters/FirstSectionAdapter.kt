package com.example.directorysmp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
import com.example.directorysmp.model.DiagnosisWithTacticsAndAmountOfMedicalCare

class FirstSectionAdapter() :
    RecyclerView.Adapter<FirstSectionAdapter.FirstSectionViewHolder>() {

    private val chapters = DataSource.directoryItems

    class ChapterWithDiagnosisList(val chapter: String, val diagnosisList: List<DiagnosisWithTacticsAndAmountOfMedicalCare>, var isExpanded: Boolean)

    private val chapterWithDiagnosisList = mutableListOf<ChapterWithDiagnosisList>()

    init {
        for (element in chapters) {
            chapterWithDiagnosisList.add(ChapterWithDiagnosisList(element.chapter, element.diagnosisWithTacticsAndAmountOfMedicalCare, false))
        }
    }

    class FirstSectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view_item)
        val linearLayout: LinearLayout = view.findViewById(R.id.view_holder_linear_layout)
        val relativeChildLayout: RelativeLayout = view.findViewById(R.id.relative_nested_recycler_view_layout)
        val recyclerView: RecyclerView = view.findViewById(R.id.nested_recycler_view)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstSectionViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.first_section_item_view, parent, false)

        return FirstSectionViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: FirstSectionViewHolder,
        position: Int
    ) {
        val item = chapterWithDiagnosisList[position]

        holder.relativeChildLayout.visibility = if (item.isExpanded) View.VISIBLE else View.GONE

        holder.textView.text = item.chapter
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.recyclerView.adapter = FirstSectionChildAdapter(item.chapter, item.diagnosisList)

        holder.linearLayout.setOnClickListener {
            item.isExpanded = !item.isExpanded
            holder.relativeChildLayout.visibility = if (item.isExpanded) View.VISIBLE else View.GONE
        }
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

}