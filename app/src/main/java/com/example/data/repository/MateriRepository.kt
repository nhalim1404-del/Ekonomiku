package com.example.data.repository

import com.example.data.model.Bab
import com.example.data.model.MateriSection
import com.example.data.model.Subbab

object MateriRepository {

    val allBabs: List<Bab> = listOf(
        MateriDataSemester1.bab1,
        MateriDataSemester1.bab2,
        MateriDataSemester1.bab3,
        MateriDataSemester2.bab4,
        MateriDataSemester2.bab5,
        MateriDataSemester2.bab6
    )

    fun getBabById(id: Int): Bab? {
        return allBabs.find { it.id == id }
    }

    fun getSubbabById(subbabId: String): Pair<Bab, Subbab>? {
        for (bab in allBabs) {
            val subbab = bab.subbabList.find { it.id == subbabId }
            if (subbab != null) {
                return Pair(bab, subbab)
            }
        }
        return null
    }

    fun getBabsBySemester(semester: Int): List<Bab> {
        return allBabs.filter { it.semester == semester }
    }

    data class SearchResult(
        val bab: Bab,
        val subbab: Subbab,
        val matchedSnippet: String
    )

    fun searchMateri(query: String): List<SearchResult> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        val results = mutableListOf<SearchResult>()

        for (bab in allBabs) {
            for (subbab in bab.subbabList) {
                if (subbab.judul.lowercase().contains(q) || subbab.ringkasan.lowercase().contains(q)) {
                    results.add(SearchResult(bab, subbab, subbab.ringkasan))
                    continue
                }

                // Check sections
                var foundSnippet: String? = null
                for (section in subbab.sections) {
                    when (section) {
                        is MateriSection.Paragraph -> {
                            if (section.text.lowercase().contains(q)) {
                                foundSnippet = section.text
                                break
                            }
                        }
                        is MateriSection.Heading -> {
                            if (section.text.lowercase().contains(q)) {
                                foundSnippet = section.text
                                break
                            }
                        }
                        is MateriSection.Bullets -> {
                            val match = section.items.find { it.lowercase().contains(q) }
                            if (match != null) {
                                foundSnippet = match
                                break
                            }
                        }
                        is MateriSection.HighlightBox -> {
                            if (section.title.lowercase().contains(q) || section.content.lowercase().contains(q)) {
                                foundSnippet = "${section.title}: ${section.content}"
                                break
                            }
                        }
                        is MateriSection.FormulaCard -> {
                            if (section.title.lowercase().contains(q) || section.formula.lowercase().contains(q) || section.explanation.lowercase().contains(q)) {
                                foundSnippet = "${section.title} (${section.formula})"
                                break
                            }
                        }
                        else -> {}
                    }
                }

                if (foundSnippet != null) {
                    val snippet = if (foundSnippet.length > 120) foundSnippet.take(120) + "..." else foundSnippet
                    results.add(SearchResult(bab, subbab, snippet))
                }
            }
        }
        return results
    }
}
