package com.example.directorysmp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.directorysmp.databinding.FragmentDetailDiagnosisDefinitionBinding

class DetailDiagnosisDefinitionFragment : Fragment() {
    private var _binding: FragmentDetailDiagnosisDefinitionBinding? = null
    private val binding get() = _binding!!
    private lateinit var diagnosis: String
    private lateinit var tactics: String
    private lateinit var medicalCare: String
    private lateinit var diagnosisNameTextView: TextView
    private lateinit var medicalCareTextView: TextView
    private lateinit var tacticsNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            diagnosis = it.getString(DIAGNOSIS_KEY).toString()
            medicalCare = it.getString(MEDICAL_CARE_KEY).toString()
            tactics = it.getString(TACTICS_KEY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailDiagnosisDefinitionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        diagnosisNameTextView = binding.diagnosisName
        medicalCareTextView = binding.amountOfCare
        tacticsNameTextView = binding.tacticsName
        diagnosisNameTextView.text = diagnosis
        medicalCareTextView.text = medicalCare
        tacticsNameTextView.text = tactics
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val DIAGNOSIS_KEY = "diagnosis"
        const val TACTICS_KEY = "tactics"
        const val MEDICAL_CARE_KEY = "medicalCare"
    }
}