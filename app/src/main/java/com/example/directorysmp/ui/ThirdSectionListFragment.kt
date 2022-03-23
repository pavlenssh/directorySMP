package com.example.directorysmp.ui

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
import com.example.directorysmp.databinding.FragmentThirdSectionListBinding
import com.example.directorysmp.model.UnderDiagnosisWithAmountOfMedialCare
import com.example.directorysmp.ui.adapters.SecondSectionAdapter
import com.example.directorysmp.ui.adapters.ThirdSectionAdapter


class ThirdSectionListFragment : Fragment() {
    private var _binding: FragmentThirdSectionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var chapter: String
    private lateinit var diagnosis: String
    private lateinit var listOfUnderDiagnosisWithAmountOfMedialCare : List<UnderDiagnosisWithAmountOfMedialCare>
    private lateinit var tactics : String
    private lateinit var adapter : ThirdSectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            chapter = it.getString(CHAPTER_KEY).toString()
            diagnosis = it.getString(DIAGNOSIS_KEY).toString()
        }
        listOfUnderDiagnosisWithAmountOfMedialCare = DataSource.directoryItems
            .first {it.chapter == chapter}.diagnosisWithTacticsAndAmountOfMedicalCare
            .first {it.diagnosis == diagnosis}.underDiagnosisWithAmountOfMedialCare
        tactics = DataSource.directoryItems
            .first {it.chapter == chapter}.diagnosisWithTacticsAndAmountOfMedicalCare
            .first {it.diagnosis == diagnosis}.tactics
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
        searchView = binding.searchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        adapter = ThirdSectionAdapter(
            listOfUnderDiagnosisWithAmountOfMedialCare,
            tactics,
            requireContext())
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun filterList(text: String?) {
        val filteredList = mutableListOf<UnderDiagnosisWithAmountOfMedialCare>()
        for (element in listOfUnderDiagnosisWithAmountOfMedialCare) {
            if (element.underDiagnosis.lowercase().contains(text!!.lowercase())) {
                filteredList.add(element)
            }
        }
        if (filteredList.isNotEmpty()) {
            adapter = ThirdSectionAdapter(
                filteredList,
                tactics,
                requireContext())
            recyclerView.adapter = adapter
        } else {
            adapter = ThirdSectionAdapter(
                mutableListOf(),
                tactics,
                requireContext())
            recyclerView.adapter = adapter
        }
    }

    companion object {
        const val CHAPTER_KEY = "chapter"
        const val DIAGNOSIS_KEY = "diagnosis"
    }
}
