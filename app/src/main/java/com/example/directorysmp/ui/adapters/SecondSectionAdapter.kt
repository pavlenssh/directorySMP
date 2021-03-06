package com.example.directorysmp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
//import com.example.directorysmp.ui.SecondSectionListFragmentDirections

class SecondSectionAdapter(private val chapter: String, context: Context) :
    RecyclerView.Adapter<SecondSectionAdapter.SecondSectionViewHolder>() {

    private val diagnosisWithTacticsAndAmountOfMedicalCare = DataSource.directoryItems.first {it.chapter == chapter}.diagnosisWithTacticsAndAmountOfMedicalCare

    class SecondSectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text_view_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondSectionViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.first_section_item_view, parent, false)

        return SecondSectionViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SecondSectionViewHolder, position: Int) {
        val item = diagnosisWithTacticsAndAmountOfMedicalCare[position]

        holder.textView.text = item.diagnosis
        holder.textView.setOnClickListener {
            /*val action = SecondSectionListFragmentDirections
                .actionSecondSectionListFragmentToThirdSectionListFragment(chapter = chapter, diagnosis = item.diagnosis)
            holder.view.findNavController().navigate(action)
             */
        }
    }

    override fun getItemCount(): Int {
        return diagnosisWithTacticsAndAmountOfMedicalCare.size
    }
}