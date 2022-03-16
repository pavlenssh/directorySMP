package com.example.directorysmp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.model.DiagnosisWithTacticsAndAmountOfMedicalCare
import com.example.directorysmp.ui.FirstSectionListFragmentDirections

class FirstSectionChildAdapter(val chapter: String, private val diagnosisWithTacticsAndAmountOfMedicalCare: List<DiagnosisWithTacticsAndAmountOfMedicalCare>) :
    RecyclerView.Adapter<FirstSectionChildAdapter.FirstSectionChildViewHolder>() {

    class FirstSectionChildViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.nested_text_view)
        val linearLayout: LinearLayout = view.findViewById(R.id.nested_view_holder_linear_layout)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstSectionChildViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.first_section_child_item_view, parent, false)

        return FirstSectionChildViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: FirstSectionChildViewHolder,
        position: Int
    ) {
        val item = diagnosisWithTacticsAndAmountOfMedicalCare[position]
        holder.textView.text = item.diagnosis

        holder.linearLayout.setOnClickListener {
            val action = FirstSectionListFragmentDirections.actionFirstSectionListFragmentToThirdSectionListFragment(chapter = chapter, diagnosis = item.diagnosis)
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return diagnosisWithTacticsAndAmountOfMedicalCare.size
    }
}