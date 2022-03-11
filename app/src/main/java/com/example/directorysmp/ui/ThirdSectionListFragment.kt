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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.R
import com.example.directorysmp.data.DataSource
import com.example.directorysmp.databinding.FragmentThirdSectionListBinding
import com.example.directorysmp.ui.adapters.SecondSectionAdapter
import com.example.directorysmp.ui.adapters.ThirdSectionAdapter


class ThirdSectionListFragment : Fragment() {
    private var _binding: FragmentThirdSectionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
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
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = ThirdSectionAdapter(chapter, diagnosis, requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val CHAPTER_KEY = "chapter"
        const val DIAGNOSIS_KEY = "diagnosis"
    }
}
