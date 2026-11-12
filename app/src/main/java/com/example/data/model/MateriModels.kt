package com.example.data.model

enum class HighlightType {
    TAHUKAH_KAMU,
    INGAT,
    WASPADA,
    CONTOH,
    ANALOGI
}

enum class DiagramType {
    MASLOW_PYRAMID,
    PPF_CURVE,
    CIRCULAR_FLOW,
    MARKET_EQUILIBRIUM,
    QRIS_FLOW,
    PAWN_FLOW,
    FINANCIAL_PYRAMID
}

sealed class MateriSection {
    data class Paragraph(val text: String) : MateriSection()
    data class Heading(val text: String) : MateriSection()
    data class Bullets(val items: List<String>) : MateriSection()
    data class Table(val headers: List<String>, val rows: List<List<String>>) : MateriSection()
    data class FormulaCard(val title: String, val formula: String, val explanation: String) : MateriSection()
    data class HighlightBox(val type: HighlightType, val title: String, val content: String) : MateriSection()
    data class InteractiveDiagram(val type: DiagramType) : MateriSection()
}

data class GlosariumItem(
    val istilah: String,
    val definisi: String
)

data class Subbab(
    val id: String, // e.g. "1.1"
    val babId: Int,
    val judul: String,
    val ringkasan: String,
    val sections: List<MateriSection>,
    val glosarium: List<GlosariumItem> = emptyList()
)

data class Bab(
    val id: Int, // 1..6
    val semester: Int, // 1 or 2
    val judul: String,
    val deskripsi: String,
    val subbabList: List<Subbab>,
    val glosariumBab: List<GlosariumItem> = emptyList()
)

data class Soal(
    val id: Int,            // babId*100 + nomor, misalnya 101..125, 201..225
    val babId: Int,
    val nomorSoal: Int,     // 1..25 berurutan
    val pertanyaan: String,
    val opsi: List<String>, // tepat 5 opsi, A sampai E, tidak ada yang kembar
    val jawabanBenar: Int,  // 0=A, 1=B, 2=C, 3=D, 4=E
    val pembahasan: String  // 1-2 kalimat, menjelaskan mengapa jawabannya benar
)

data class LkpdQuestion(
    val id: Int,
    val pertanyaan: String,
    val hint: String = ""
)

data class RubrikItem(
    val kriteria: String,
    val skorMaks: Int,
    val deskripsi: String
)

data class LkpdItem(
    val id: Int,
    val babId: Int,
    val judul: String,
    val deskripsi: String,
    val petunjuk: List<String>,
    val studiKasus: String,
    val pertanyaanList: List<LkpdQuestion>,
    val rubrik: List<RubrikItem>,
    val filePdfName: String = ""
)
