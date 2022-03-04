package com.example.directorysmp.ui

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
import com.example.directorysmp.databinding.FragmentThirdSectionListBinding


class ThirdSectionListFragment : Fragment() {
    private var _binding: FragmentThirdSectionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var tableView: TableLayout
    private lateinit var chapter: String
    private lateinit var diagnosis: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            chapter = it.getString(CHAPTER_KEY).toString()
            diagnosis = it.getString(DIAGNOSIS_KEY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdSectionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tableView = binding.tableView

        loadTableLayout()



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadTableLayout() {
        val diagnosisWithTacticsAndAmountOfMedicalCare = DataSource.directoryItems.first {it.chapter == chapter}.diagnosisWithTacticsAndAmountOfMedicalCare
        val diagnosisWithAmountOfMedialCare = diagnosisWithTacticsAndAmountOfMedicalCare.first {it.diagnosis == diagnosis}.underDiagnosisWithAmountOfMedialCare

        val tableRow = TableRow(this.context)
        tableRow.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val firstLinearLayout = LinearLayout(this.context)
        firstLinearLayout.apply {
            layoutParams = TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT)
            (layoutParams as TableRow.LayoutParams).weight = 1F
            (layoutParams as TableRow.LayoutParams).setMargins(12,12,12,12)
            setBackgroundResource(R.drawable.background_table_item)
        }

        val firstTextView = TextView(this.context)
        firstTextView.apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            (layoutParams as LinearLayout.LayoutParams).setMargins(24,24,24,24)
            text = diagnosisWithAmountOfMedialCare[0].underDiagnosis
        }
        firstLinearLayout.addView(firstTextView)

        val secondLinearLayout = LinearLayout(this.context)
        secondLinearLayout.apply {
            layoutParams = TableRow.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT)
            (layoutParams as TableRow.LayoutParams).weight = 1F
            (layoutParams as TableRow.LayoutParams).setMargins(12,12,12,12)
            setBackgroundResource(R.drawable.background_table_item)
        }

        val secondTextView = TextView(this.context)
        secondTextView.apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            (layoutParams as LinearLayout.LayoutParams).setMargins(24,24,24,24)
            text = diagnosisWithAmountOfMedialCare[0].amountOfMedicalCare
        }
        secondLinearLayout.addView(secondTextView)

        tableRow.addView(firstLinearLayout)
        tableRow.addView(secondLinearLayout)

        tableView.addView(tableRow)
    }

    companion object {
        const val CHAPTER_KEY = "chapter"
        const val DIAGNOSIS_KEY = "diagnosis"
    }
}
