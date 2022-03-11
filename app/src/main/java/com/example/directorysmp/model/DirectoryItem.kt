package com.example.directorysmp.model

data class DirectoryItem(
    val chapter: String,
    val diagnosisWithTacticsAndAmountOfMedicalCare: List<DiagnosisWithTacticsAndAmountOfMedicalCare>,
)

data class DiagnosisWithTacticsAndAmountOfMedicalCare(
    val diagnosis: String,
    val underDiagnosisWithAmountOfMedialCare: List<UnderDiagnosisWithAmountOfMedialCare>,
    val tactics: String
)

open class UnderDiagnosisWithAmountOfMedialCare(
    val underDiagnosis: String,
    val amountOfMedicalCare: String
)