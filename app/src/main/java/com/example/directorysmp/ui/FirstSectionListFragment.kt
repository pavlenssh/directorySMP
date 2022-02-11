package com.example.directorysmp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.directorysmp.databinding.FragmentFirstSectionListBinding
import com.example.directorysmp.ui.adapters.FirstSectionAdapter

class FirstSectionListFragment : Fragment() {
    private var _binding: FragmentFirstSectionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstSectionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = FirstSectionAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}