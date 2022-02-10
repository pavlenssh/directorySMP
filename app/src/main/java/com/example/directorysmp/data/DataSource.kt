package com.example.directorysmp.data

import com.example.directorysmp.model.DiagnosisWithAmountOfMedialCare
import com.example.directorysmp.model.DiagnosisWithTacticsAndAmountOfMedicalCare
import com.example.directorysmp.model.DirectoryItem

object DataSource {
    val directoryItems = listOf(
        DirectoryItem(
            chapter = "АНЕСТЕЗИОЛОГИЯ и РЕАНИМАТОЛОГИЯ",
            diagnosisWithTacticsAndAmountOfMedicalCare = listOf(
                DiagnosisWithTacticsAndAmountOfMedicalCare(
                    listOf(
                        DiagnosisWithAmountOfMedialCare(
                            "Остановка сердца: внезапная потеря" +
                                    "сознания, отсутствие пульса на" +
                                    "сонной артерии, отсутствие дыхания",
                            "- Компрессии грудной клетки в комбинации с ИВЛ;\n" +
                                    "- Анализ электрической деятельности сердца с помощью\n" +
                                    "электродов дефибриллятора;\n" +
                                    "- ЭКГ – мониторинг."
                        ),
                        DiagnosisWithAmountOfMedialCare(
                            "Остановка сердца: внезапная потеря" +
                                    "сознания, отсутствие пульса на" +
                                    "сонной артерии, отсутствие дыхания",
                            "- Компрессии грудной клетки в комбинации с ИВЛ;\n" +
                                    "- Анализ электрической деятельности сердца с помощью\n" +
                                    "электродов дефибриллятора;\n" +
                                    "- ЭКГ – мониторинг."
                        )
                    ),
                    "Для фельдшерской бригады" +
                            "– начать проведение СЛР," +
                            "при необходимости вызов" +
                            "бригады АиР «на себя» или" +
                            "врачебной бригады."
                ),
                DiagnosisWithTacticsAndAmountOfMedicalCare(
                    listOf(
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        ),
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        )
                    ),
                    ""
                ),
                DiagnosisWithTacticsAndAmountOfMedicalCare(
                    listOf(
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        ),
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        )
                    ),
                    ""
                ),
                DiagnosisWithTacticsAndAmountOfMedicalCare(
                    listOf(
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        ),
                        DiagnosisWithAmountOfMedialCare(
                            "",
                            ""
                        )
                    ),
                    ""
                ),
            )

        )
    )

    val diagnosisWithAmountOfMedialCare = DiagnosisWithAmountOfMedialCare(
        "Остановка сердца: внезапная потеря" +
                "сознания, отсутствие пульса на" +
                "сонной артерии, отсутствие дыхания",
        "- Компрессии грудной клетки в комбинации с ИВЛ;\n" +
                "- Анализ электрической деятельности сердца с помощью\n" +
                "электродов дефибриллятора;\n" +
                "- ЭКГ – мониторинг."
    )


    val i = DiagnosisWithTacticsAndAmountOfMedicalCare(
        listOf(
            DiagnosisWithAmountOfMedialCare(
                "Остановка сердца: внезапная потеря" +
                        "сознания, отсутствие пульса на" +
                        "сонной артерии, отсутствие дыхания",
                "- Компрессии грудной клетки в комбинации с ИВЛ;\n" +
                        "- Анализ электрической деятельности сердца с помощью\n" +
                        "электродов дефибриллятора;\n" +
                        "- ЭКГ – мониторинг."
            ),
            DiagnosisWithAmountOfMedialCare(
                "Остановка сердца: внезапная потеря" +
                        "сознания, отсутствие пульса на" +
                        "сонной артерии, отсутствие дыхания",
                "- Компрессии грудной клетки в комбинации с ИВЛ;\n" +
                        "- Анализ электрической деятельности сердца с помощью\n" +
                        "электродов дефибриллятора;\n" +
                        "- ЭКГ – мониторинг."
            )
        ),
        "Для фельдшерской бригады" +
                "– начать проведение СЛР," +
                "при необходимости вызов" +
                "бригады АиР «на себя» или" +
                "врачебной бригады."
    )
}