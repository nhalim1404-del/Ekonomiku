package com.example.ui.materi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Bookmark
import com.example.data.model.GlosariumItem
import com.example.data.model.HighlightType
import com.example.data.model.MateriSection
import com.example.data.repository.MateriRepository
import com.example.ui.components.EconomicDiagramViewer
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.PrimaryBlue

@Composable
fun MateriDetailScreen(
    subbabId: String,
    textScale: Float,
    bookmarks: List<Bookmark>,
    onSubbabOpened: (String) -> Unit,
    onBookmarkToggle: (babId: Int, subbabId: String, judulBab: String, judulSubbab: String) -> Unit,
    onNavigateToSubbab: (String) -> Unit,
    onBackToContents: () -> Unit
) {
    val result = MateriRepository.getSubbabById(subbabId)
    if (result == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Materi tidak ditemukan")
        }
        return
    }

    val (bab, subbab) = result
    val isBookmarked = bookmarks.any { it.subbabId == subbabId }
    var selectedGlosarium by remember { mutableStateOf<GlosariumItem?>(null) }

    LaunchedEffect(subbabId) {
        onSubbabOpened(subbabId)
    }

    // Find Previous & Next Subbabs
    val allSubbabs = MateriRepository.allBabs.flatMap { it.subbabList }
    val currentIndex = allSubbabs.indexOfFirst { it.id == subbabId }
    val prevSubbab = if (currentIndex > 0) allSubbabs[currentIndex - 1] else null
    val nextSubbab = if (currentIndex in 0 until allSubbabs.size - 1) allSubbabs[currentIndex + 1] else null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("materi_detail_screen")
    ) {
        // Detail Toolbar
        Surface(
            tonalElevation = 2.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onBackToContents,
                        modifier = Modifier.testTag("materi_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali ke Daftar Isi"
                        )
                    }
                    Text(
                        text = "Bab ${bab.id}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = PrimaryBlue
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                            onBookmarkToggle(bab.id, subbab.id, bab.judul, subbab.judul)
                        },
                        modifier = Modifier.testTag("materi_bookmark_button")
                    ) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (isBookmarked) AccentAmber else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = subbab.judul,
                    fontSize = (20 * textScale).sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    lineHeight = (26 * textScale).sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    color = PrimaryBlue.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "+20 XP untuk membaca materi ini",
                        fontSize = (11 * textScale).sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            }

            // Render all sections
            items(subbab.sections) { section ->
                when (section) {
                    is MateriSection.Heading -> {
                        Text(
                            text = section.text,
                            fontSize = (16 * textScale).sp,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    is MateriSection.Paragraph -> {
                        Text(
                            text = section.text,
                            fontSize = (14 * textScale).sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            lineHeight = (21 * textScale).sp
                        )
                    }
                    is MateriSection.Bullets -> {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            section.items.forEach { bullet ->
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Text(
                                        text = "•",
                                        fontSize = (16 * textScale).sp,
                                        fontWeight = FontWeight.Bold,
                                        color = PrimaryBlue,
                                        modifier = Modifier.padding(end = 8.dp)
                                    )
                                    Text(
                                        text = bullet,
                                        fontSize = (13.5 * textScale).sp,
                                        color = MaterialTheme.colorScheme.onBackground,
                                        lineHeight = (20 * textScale).sp
                                    )
                                }
                            }
                        }
                    }
                    is MateriSection.Table -> {
                        TableSection(table = section, textScale = textScale)
                    }
                    is MateriSection.FormulaCard -> {
                        FormulaCardSection(card = section, textScale = textScale)
                    }
                    is MateriSection.HighlightBox -> {
                        HighlightBoxSection(box = section, textScale = textScale)
                    }
                    is MateriSection.InteractiveDiagram -> {
                        EconomicDiagramViewer(type = section.type)
                    }
                }
            }

            // Clickable Glossary Section
            if (subbab.glosarium.isNotEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Glosarium Istilah (Ketuk untuk Penjelasan)",
                        fontSize = (14 * textScale).sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        subbab.glosarium.forEach { item ->
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                border = androidx.compose.foundation.BorderStroke(1.dp, PrimaryBlue.copy(alpha = 0.4f)),
                                modifier = Modifier.clickable { selectedGlosarium = item }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = "Info",
                                        tint = PrimaryBlue,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = item.istilah,
                                        fontSize = (11 * textScale).sp,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Bottom Navigation (Sebelumnya, Daftar Isi, Berikutnya)
            item {
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (prevSubbab != null) {
                        OutlinedButton(
                            onClick = { onNavigateToSubbab(prevSubbab.id) },
                            modifier = Modifier.testTag("btn_prev_subbab")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Sebelumnya",
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Sebelumnya", fontSize = 11.sp)
                        }
                    } else {
                        Spacer(modifier = Modifier.width(40.dp))
                    }

                    OutlinedButton(
                        onClick = onBackToContents,
                        modifier = Modifier.testTag("btn_contents_subbab")
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "Daftar Isi",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Daftar Isi", fontSize = 11.sp)
                    }

                    if (nextSubbab != null) {
                        Button(
                            onClick = { onNavigateToSubbab(nextSubbab.id) },
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            modifier = Modifier.testTag("btn_next_subbab")
                        ) {
                            Text("Berikutnya", fontSize = 11.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Berikutnya",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.width(40.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

    // Glossary Dialog
    selectedGlosarium?.let { glos ->
        AlertDialog(
            onDismissRequest = { selectedGlosarium = null },
            title = {
                Text(
                    text = glos.istilah,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )
            },
            text = {
                Text(
                    text = glos.definisi,
                    fontSize = 13.sp,
                    lineHeight = 19.sp
                )
            },
            confirmButton = {
                TextButton(onClick = { selectedGlosarium = null }) {
                    Text("Tutup", fontWeight = FontWeight.Bold)
                }
            },
            shape = RoundedCornerShape(12.dp)
        )
    }
}

@Composable
fun HighlightBoxSection(box: MateriSection.HighlightBox, textScale: Float) {
    val (color, label) = when (box.type) {
        HighlightType.TAHUKAH_KAMU -> Color(0xFF0288D1) to "💡 TAHUKAH KAMU?"
        HighlightType.INGAT -> Color(0xFF388E3C) to "📌 INGAT!"
        HighlightType.WASPADA -> Color(0xFFD32F2F) to "⚠️ WASPADA!"
        HighlightType.CONTOH -> Color(0xFF7B1FA2) to "🔍 CONTOH NYATA"
        HighlightType.ANALOGI -> Color(0xFFF57C00) to "⚖️ ANALOGI SEDERHANA"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.08f)),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, color.copy(alpha = 0.5f))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = label,
                fontSize = (11 * textScale).sp,
                fontWeight = FontWeight.ExtraBold,
                color = color
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = box.title,
                fontSize = (13.5 * textScale).sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = box.content,
                fontSize = (12.5 * textScale).sp,
                color = MaterialTheme.colorScheme.onSurface,
                lineHeight = (18 * textScale).sp
            )
        }
    }
}

@Composable
fun FormulaCardSection(card: MateriSection.FormulaCard, textScale: Float) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF263238))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = "📐 ${card.title}",
                fontSize = (12 * textScale).sp,
                fontWeight = FontWeight.Bold,
                color = AccentAmber
            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                color = Color.Black.copy(alpha = 0.4f),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = card.formula,
                    fontFamily = FontFamily.Monospace,
                    fontSize = (13 * textScale).sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = card.explanation,
                fontSize = (11 * textScale).sp,
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}

@Composable
fun TableSection(table: MateriSection.Table, textScale: Float) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PrimaryBlue.copy(alpha = 0.12f), RoundedCornerShape(4.dp))
                    .padding(vertical = 6.dp, horizontal = 4.dp)
            ) {
                table.headers.forEach { header ->
                    Text(
                        text = header,
                        fontSize = (11 * textScale).sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryBlue,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            // Body Rows
            table.rows.forEachIndexed { idx, row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            if (idx % 2 == 1) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f)
                            else Color.Transparent
                        )
                        .padding(vertical = 6.dp, horizontal = 4.dp)
                ) {
                    row.forEach { cell ->
                        Text(
                            text = cell,
                            fontSize = (10.5 * textScale).sp,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}
