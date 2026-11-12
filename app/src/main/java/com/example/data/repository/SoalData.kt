package com.example.data.repository

import com.example.data.model.Soal

object SoalData {

    val soalBab1: List<Soal> = SoalBab1Bab2.soalBab1
    val soalBab2: List<Soal> = SoalBab1Bab2.soalBab2
    val soalBab3: List<Soal> = SoalBab3Bab4.soalBab3
    val soalBab4: List<Soal> = SoalBab3Bab4.soalBab4
    val soalBab5: List<Soal> = SoalBab5Bab6.soalBab5
    val soalBab6: List<Soal> = SoalBab5Bab6.soalBab6

    val allSoal: List<Soal> = soalBab1 + soalBab2 + soalBab3 + soalBab4 + soalBab5 + soalBab6

    fun getSoalByBab(babId: Int): List<Soal> {
        return when (babId) {
            1 -> soalBab1
            2 -> soalBab2
            3 -> soalBab3
            4 -> soalBab4
            5 -> soalBab5
            6 -> soalBab6
            else -> emptyList()
        }
    }
}
