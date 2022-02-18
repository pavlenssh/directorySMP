package com.example.directorysmp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import com.example.directorysmp.databinding.FragmentThirdSectionListBinding


class ThirdSectionListFragment : Fragment() {
    private var _binding: FragmentThirdSectionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var tableView: TableLayout

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
