package com.example.ui.materi

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Bab
import com.example.data.model.Bookmark
import com.example.data.model.Subbab
import com.example.data.repository.MateriRepository
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.PrimaryBlue

@Composable
fun MateriListScreen(
    initialSemester: Int = 1,
    bookmarks: List<Bookmark>,
    isSubbabRead: (String) -> Boolean,
    onSubbabClick: (subbabId: String) -> Unit,
    onBookmarkToggle: (babId: Int, subbabId: String, judulBab: String, judulSubbab: String) -> Unit,
    onSearchClick: () -> Unit
) {
    var selectedSemester by remember { mutableIntStateOf(initialSemester) }
    val babs = MateriRepository.getBabsBySemester(selectedSemester)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("materi_list_screen")
    ) {
        // Semester Tabs
        TabRow(
            selectedTabIndex = selectedSemester - 1,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = PrimaryBlue
        ) {
            Tab(
                selected = selectedSemester == 1,
                onClick = { selectedSemester = 1 },
                text = { Text("Semester 1 (Ganjil)", fontWeight = FontWeight.Bold, fontSize = 13.sp) },
                modifier = Modifier.testTag("tab_semester_1")
            )
            Tab(
                selected = selectedSemester == 2,
                onClick = { selectedSemester = 2 },
                text = { Text("Semester 2 (Genap)", fontWeight = FontWeight.Bold, fontSize = 13.sp) },
                modifier = Modifier.testTag("tab_semester_2")
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Daftar Materi Pembelajaran",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        modifier = Modifier.clickable { onSearchClick() }
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Cari",
                                modifier = Modifier.size(16.dp),
                                tint = PrimaryBlue
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Cari Materi", fontSize = 11.sp, color = PrimaryBlue, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            items(babs) { bab ->
                BabMateriCard(
                    bab = bab,
                    bookmarks = bookmarks,
                    isSubbabRead = isSubbabRead,
                    onSubbabClick = onSubbabClick,
                    onBookmarkToggle = onBookmarkToggle
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun BabMateriCard(
    bab: Bab,
    bookmarks: List<Bookmark>,
    isSubbabRead: (String) -> Boolean,
    onSubbabClick: (subbabId: String) -> Unit,
    onBookmarkToggle: (babId: Int, subbabId: String, judulBab: String, judulSubbab: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("bab_card_${bab.id}"),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Bab Header
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .background(PrimaryBlue, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${bab.id}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = bab.judul,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "${bab.subbabList.size} Subbab Materi",
                        fontSize = 11.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = bab.deskripsi,
                fontSize = 11.5.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Subbab Items
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                bab.subbabList.forEach { subbab ->
                    val read = isSubbabRead(subbab.id)
                    val isBookmarked = bookmarks.any { it.subbabId == subbab.id }

                    SubbabRowItem(
                        subbab = subbab,
                        isRead = read,
                        isBookmarked = isBookmarked,
                        onSubbabClick = { onSubbabClick(subbab.id) },
                        onBookmarkClick = {
                            onBookmarkToggle(bab.id, subbab.id, bab.judul, subbab.judul)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SubbabRowItem(
    subbab: Subbab,
    isRead: Boolean,
    isBookmarked: Boolean,
    onSubbabClick: () -> Unit,
    onBookmarkClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSubbabClick() }
            .testTag("subbab_item_${subbab.id}"),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isRead) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Sudah Dibaca",
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(18.dp)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(PrimaryBlue, CircleShape)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = subbab.judul,
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = subbab.ringkasan,
                        fontSize = 10.5.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 1
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = onBookmarkClick,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                        contentDescription = "Bookmark",
                        tint = if (isBookmarked) AccentAmber else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Buka",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
