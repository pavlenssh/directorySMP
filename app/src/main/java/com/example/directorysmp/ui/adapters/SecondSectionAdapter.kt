package com.example.directorysmp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource

class SecondSectionAdapter(private val chapter: String, context: Context) :
    RecyclerView.Adapter<SecondSectionAdapter.SecondSectionViewHolder>() {

    private val diagnosisWithTacticsAndAmountOfMedicalCare = DataSource.directoryItems.first {it.chapter == chapter}.diagnosisWithTacticsAndAmountOfMedicalCare

    class SecondSectionViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.text_view_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondSectionViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return SecondSectionViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SecondSectionViewHolder, position: Int) {
        val item = diagnosisWithTacticsAndAmountOfMedicalCare[position]

        holder.textView.text = item.diagnosis
    }

    override fun getItemCount(): Int {
        return diagnosisWithTacticsAndAmountOfMedicalCare.size
    }
}