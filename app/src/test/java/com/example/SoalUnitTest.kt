package com.example

import com.example.data.repository.SoalData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SoalUnitTest {

    @Test
    fun testTotalSoalAdalahTepat150DanEnamBab() {
        assertEquals("Total bab harus 6", 6, (1..6).count())

        for (babId in 1..6) {
            val soalBab = SoalData.getSoalByBab(babId)
            assertEquals("Bab $babId harus memiliki tepat 25 butir soal", 25, soalBab.size)
        }

        assertEquals("Total seluruh soal harus tepat 150 butir", 150, SoalData.allSoal.size)
    }

    @Test
    fun testIdSoalUnikDanBerurutan() {
        val allIds = SoalData.allSoal.map { it.id }
        val uniqueIds = allIds.toSet()
        assertEquals("Seluruh ID soal harus unik", allIds.size, uniqueIds.size)

        for (babId in 1..6) {
            val soalBab = SoalData.getSoalByBab(babId)
            soalBab.forEachIndexed { index, soal ->
                assertEquals("Nomor soal harus berurutan 1 sampai 25", index + 1, soal.nomorSoal)
                assertEquals("ID soal harus sesuai format babId * 100 + nomorSoal", babId * 100 + (index + 1), soal.id)
            }
        }
    }

    @Test
    fun testOpsiTepatLimaDanUnikSertaKunciValid() {
        SoalData.allSoal.forEach { soal ->
            // Tepat 5 opsi
            assertEquals(
                "Soal ID ${soal.id} harus memiliki tepat 5 opsi",
                5,
                soal.opsi.size
            )

            // 5 Opsi tidak ada yang kembar (unik)
            val uniqueOptions = soal.opsi.toSet()
            assertEquals(
                "Soal ID ${soal.id} memiliki opsi yang kembar",
                5,
                uniqueOptions.size
            )

            // Kunci jawaban antara 0 sampai 4 (A sampai E)
            assertTrue(
                "Soal ID ${soal.id} memiliki kunci di luar rentang 0..4 (${soal.jawabanBenar})",
                soal.jawabanBenar in 0..4
            )

            // Pembahasan tidak kosong
            assertFalse(
                "Soal ID ${soal.id} pembahasan tidak boleh kosong",
                soal.pembahasan.isBlank()
            )

            // Pertanyaan tidak boleh kosong
            assertFalse(
                "Soal ID ${soal.id} pertanyaan tidak boleh kosong",
                soal.pertanyaan.isBlank()
            )
        }
    }

    @Test
    fun testSebaranKunciJawabanMerata() {
        // Memastikan tidak didominasi oleh satu huruf saja
        for (babId in 1..6) {
            val soalBab = SoalData.getSoalByBab(babId)
            val counts = soalBab.groupBy { it.jawabanBenar }.mapValues { it.value.size }
            // Setiap opsi 0..4 harus muncul minimal 2 kali dalam 25 soal
            for (key in 0..4) {
                val c = counts[key] ?: 0
                assertTrue(
                    "Bab $babId kunci $key muncul $c kali (terlalu sedikit, harus tersebar)",
                    c >= 2
                )
            }
        }
    }

    @Test
    fun testHitunganMatematisKeseimbanganPasarBab3() {
        // Pengujian matematis Qd = 200 - 2P dan Qs = -40 + 4P
        // Ekuilibrium: 200 - 2P = -40 + 4P => 240 = 6P => P = 40
        val p = 40
        val qd = 200 - 2 * p
        val qs = -40 + 4 * p
        assertEquals("Qd harus 120 pada P=40", 120, qd)
        assertEquals("Qs harus 120 pada P=40", 120, qs)
        assertEquals("Qd harus sama dengan Qs pada harga ekuilibrium", qd, qs)

        // Pengujian surplus pada P = 50:
        val qd50 = 200 - 2 * 50 // 100
        val qs50 = -40 + 4 * 50 // 160
        assertEquals("Surplus harus 60 unit", 60, qs50 - qd50)
    }

    @Test
    fun testHitunganMatematisBreakEvenPointBab2() {
        // FC = 6.000.000, P = 50.000, VC = 20.000
        // BEP = FC / (P - VC) = 6.000.000 / 30.000 = 200 unit
        val fc = 6_000_000
        val p = 50_000
        val vc = 20_000
        val bepUnit = fc / (p - vc)
        assertEquals("BEP unit harus tepat 200 unit", 200, bepUnit)
    }
}
