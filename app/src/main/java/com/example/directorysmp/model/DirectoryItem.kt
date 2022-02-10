package com.example.directorysmp.model

data class DirectoryItem(
    val chapter: String,
    val diagnosisWithTacticsAndAmountOfMedicalCare: List<DiagnosisWithTacticsAndAmountOfMedicalCare>,
)

data class DiagnosisWithTacticsAndAmountOfMedicalCare(
    val diagnosisWithAmountOfMedialCare: List<DiagnosisWithAmountOfMedialCare>,
    val tactics: String
)

data class DiagnosisWithAmountOfMedialCare(
    val diagnosis: String,
    val amountOfMedicalCare: String
)