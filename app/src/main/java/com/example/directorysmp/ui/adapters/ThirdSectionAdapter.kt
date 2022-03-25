package com.example.directorysmp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R

import com.example.directorysmp.model.UnderDiagnosisWithAmountOfMedialCare
import com.example.directorysmp.ui.ThirdSectionListFragmentDirections

class ThirdSectionAdapter(
    private var underDiagnosis: List<UnderDiagnosisWithAmountOfMedialCare>,
    private val tactics: String,
    context: Context) :
    RecyclerView.Adapter<ThirdSectionAdapter.ThirdSectionViewHolder>() {

    class UnderDiagnoses (val underDiagnosis: String, val amountOfMedialCare: String, var isExpanded: Boolean = false)

    private val diagnosisList = mutableListOf<UnderDiagnoses>()

    init {
        for (element in underDiagnosis) {
            diagnosisList.add(UnderDiagnoses(element.underDiagnosis, element.amountOfMedicalCare, false))
        }
    }

    class ThirdSectionViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val amountOfMedicalCareTextView: TextView = view.findViewById(R.id.amount_of_care_text_view)
        val tacticsTextView: TextView = view.findViewById(R.id.tactics_text_view)
        val diagnosisNameTextView: TextView = view.findViewById(R.id.diagnosis_name)
        val linearLayout: LinearLayout = view.findViewById(R.id.linear_layout)
        val expandableLayout: RelativeLayout = view.findViewById(R.id.expandable_relative_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdSectionViewHolder {
        val layout = LayoutInflater
                .from(parent.context)
            .inflate(R.layout.third_section_item_view, parent, false)
        return ThirdSectionViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ThirdSectionViewHolder, position: Int) {
        val item = diagnosisList[position]

        holder.amountOfMedicalCareTextView.text = item.amountOfMedialCare
        holder.tacticsTextView.text = tactics
        holder.diagnosisNameTextView.text = diagnosisList[position].underDiagnosis
        holder.expandableLayout.visibility = if (item.isExpanded) View.VISIBLE else View.GONE
        holder.linearLayout.setOnClickListener {
            item.isExpanded = !item.isExpanded
            holder.expandableLayout.visibility = if (item.isExpanded) View.VISIBLE else View.GONE
        }
        holder.expandableLayout.setOnClickListener {
            val action = ThirdSectionListFragmentDirections
                .actionThirdSectionListFragmentToDetailDiagnosisDefinitionFragment(
                    diagnosis = diagnosisList[position].underDiagnosis,
                    medicalCare = diagnosisList[position].amountOfMedialCare,
                    tactics = tactics)
            holder.view.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return underDiagnosis.size
    }
}