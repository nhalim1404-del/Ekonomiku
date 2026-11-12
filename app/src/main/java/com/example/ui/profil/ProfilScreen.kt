package com.example.ui.profil

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.Badge
import com.example.data.model.BadgeData
import com.example.data.model.User
import com.example.ui.theme.AccentAmber
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SuccessGreen

@Composable
fun ProfilScreen(
    user: User?,
    darkMode: String,
    textScale: Float,
    reminderEnabled: Boolean,
    reminderHour: String,
    onUpdateProfile: (nama: String, kelas: String, avatarId: Int) -> Unit,
    onSetDarkMode: (String) -> Unit,
    onSetTextScale: (Float) -> Unit,
    onSetReminderEnabled: (Boolean) -> Unit,
    onSetReminderHour: (String) -> Unit,
    onResetData: () -> Unit
) {
    var showEditDialog by remember { mutableStateOf(false) }
    var showResetDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }

    val unlockedBadges = remember(user?.lencanaTerbuka) {
        user?.lencanaTerbuka?.split(",")?.filter { it.isNotBlank() } ?: emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag("profil_screen")
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(68.dp)
                                    .clip(CircleShape)
                                    .background(PrimaryBlue.copy(alpha = 0.15f))
                                    .border(2.dp, PrimaryBlue, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Avatar",
                                    tint = PrimaryBlue,
                                    modifier = Modifier.size(42.dp)
                                )
                            }

                            IconButton(onClick = { showEditDialog = true }) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Edit Profil",
                                    tint = PrimaryBlue
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = user?.nama ?: "Siswa SMANSA",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Kelas ${user?.kelas ?: "X Cermat"} • SMAN 1 Pangkep",
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = AccentAmber.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "${user?.xp ?: 0} XP",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFC67C00),
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = PrimaryBlue.copy(alpha = 0.15f)
                            ) {
                                Text(
                                    text = "Level ${user?.level ?: 1}",
                                    fontSize = 11.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PrimaryBlue,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

            // Badges Section (Tujuh Lencana Prestasi)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Lencana Prestasi (${unlockedBadges.size}/${BadgeData.allBadges.size})",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    BadgeData.allBadges.forEach { badge ->
                        val isUnlocked = unlockedBadges.contains(badge.id)
                        BadgeCardItem(badge = badge, isUnlocked = isUnlocked)
                    }
                }
            }

            // School & Teacher Info Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.School, contentDescription = null, tint = PrimaryBlue, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Informasi Sekolah & Pengampu",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = PrimaryBlue
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "• Sekolah: SMAN 1 Pangkajene dan Kepulauan", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurface)
                        Text(text = "• Guru Pengampu: Nur Halim, S.Pd., Gr.", fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                        Text(text = "• Kepala Sekolah: Syamsul Ardi, S.Pd., M.Pd.", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurface)
                        Text(text = "• Wali Kelas: XI Cermat", fontSize = 11.5.sp, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }

            // Settings: Mode Gelap, Ukuran Teks, Notifikasi
            item {
                Text(
                    text = "Pengaturan Aplikasi",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        // Mode Gelap
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.DarkMode, contentDescription = null, tint = PrimaryBlue, modifier = Modifier.size(20.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Tema Tampilan", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FilterChip(
                                selected = darkMode == "system",
                                onClick = { onSetDarkMode("system") },
                                label = { Text("Sistem", fontSize = 11.sp) }
                            )
                            FilterChip(
                                selected = darkMode == "light",
                                onClick = { onSetDarkMode("light") },
                                label = { Text("Terang", fontSize = 11.sp) }
                            )
                            FilterChip(
                                selected = darkMode == "dark",
                                onClick = { onSetDarkMode("dark") },
                                label = { Text("Gelap", fontSize = 11.sp) }
                            )
                        }

                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = MaterialTheme.colorScheme.outlineVariant)

                        // Ukuran Teks
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Default.FormatSize, contentDescription = null, tint = PrimaryBlue, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Ukuran Huruf Materi", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            FilterChip(
                                selected = textScale == 0.9f,
                                onClick = { onSetTextScale(0.9f) },
                                label = { Text("Kecil (0.9x)", fontSize = 11.sp) }
                            )
                            FilterChip(
                                selected = textScale == 1.0f,
                                onClick = { onSetTextScale(1.0f) },
                                label = { Text("Normal (1.0x)", fontSize = 11.sp) }
                            )
                            FilterChip(
                                selected = textScale == 1.15f,
                                onClick = { onSetTextScale(1.15f) },
                                label = { Text("Besar (1.15x)", fontSize = 11.sp) }
                            )
                        }

                        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp), color = MaterialTheme.colorScheme.outlineVariant)

                        // Notifikasi Pengingat
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Default.Notifications, contentDescription = null, tint = PrimaryBlue, modifier = Modifier.size(20.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(text = "Pengingat Belajar Harian", fontSize = 12.5.sp, fontWeight = FontWeight.SemiBold)
                                    Text(text = "Notifikasi lokal jam $reminderHour", fontSize = 10.5.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                            Switch(
                                checked = reminderEnabled,
                                onCheckedChange = { onSetReminderEnabled(it) },
                                colors = SwitchDefaults.colors(checkedThumbColor = PrimaryBlue)
                            )
                        }

                        if (reminderEnabled) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Pilih Jam Notifikasi:", fontSize = 11.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Spacer(modifier = Modifier.height(4.dp))
                            val hours = listOf("06:00", "12:00", "16:00", "19:00", "20:00", "21:00")
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                items(hours) { hr ->
                                    FilterChip(
                                        selected = reminderHour == hr,
                                        onClick = { onSetReminderHour(hr) },
                                        label = { Text(hr, fontSize = 11.sp) }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Reset Data & About App
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = { showResetDialog = true },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = ErrorRed),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Default.DeleteForever, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Reset Data", fontSize = 11.5.sp)
                    }

                    OutlinedButton(
                        onClick = { showAboutDialog = true },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Tentang App", fontSize = 11.5.sp)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

    // Dialog: Edit Profil
    if (showEditDialog) {
        var tempName by remember { mutableStateOf(user?.nama ?: "Siswa SMANSA") }
        var tempClass by remember { mutableStateOf(user?.kelas ?: "X Cermat") }

        AlertDialog(
            onDismissRequest = { showEditDialog = false },
            title = { Text("Edit Profil Siswa") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = tempName,
                        onValueChange = { tempName = it },
                        label = { Text("Nama Siswa") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = tempClass,
                        onValueChange = { tempClass = it },
                        label = { Text("Kelas (contoh: X Cermat, X.1)") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onUpdateProfile(tempName, tempClass, 1)
                        showEditDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
                ) {
                    Text("Simpan")
                }
            },
            dismissButton = {
                TextButton(onClick = { showEditDialog = false }) {
                    Text("Batal")
                }
            }
        )
    }

    // Dialog: Reset Data
    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = { Text("Konfirmasi Reset Data", color = ErrorRed) },
            text = {
                Text(
                    "Apakah Anda yakin ingin menghapus seluruh riwayat latihan soal, jawaban LKPD, bookmark, dan poin XP? Tindakan ini tidak dapat dibatalkan.",
                    fontSize = 12.5.sp
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onResetData()
                        showResetDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = ErrorRed)
                ) {
                    Text("Ya, Reset Semua")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text("Batal")
                }
            }
        )
    }

    // Dialog: Tentang Aplikasi
    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            title = { Text("Tentang EKONOMIKU") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("EKONOMIKU - Ekonomi Kelas X Interaktif", fontWeight = FontWeight.Bold, color = PrimaryBlue)
                    Text("Versi 1.0 (Offline Penuh - Tanpa Kuota)")
                    Text("Kurikulum: Fase E SMA Kurikulum Merdeka")
                    Text("Instansi: SMAN 1 Pangkajene dan Kepulauan (SMANSA PANGKEP)")
                    Text("Pengembang/Guru: Nur Halim, S.Pd., Gr.")
                    Text("Hak Cipta © 2026 SMANSA Pangkep. Seluruh data tersimpan aman secara lokal di perangkat siswa.")
                }
            },
            confirmButton = {
                Button(onClick = { showAboutDialog = false }) {
                    Text("Tutup")
                }
            }
        )
    }
}

@Composable
fun BadgeCardItem(badge: Badge, isUnlocked: Boolean) {
    val iconVector: ImageVector = when (badge.iconName) {
        "star" -> Icons.Default.Star
        "menu_book" -> Icons.Default.MenuBook
        "emoji_events" -> Icons.Default.EmojiEvents
        "timeline" -> Icons.Default.Timeline
        "security" -> Icons.Default.Security
        "assignment_turned_in" -> Icons.Default.AssignmentTurnedIn
        else -> Icons.Default.WorkspacePremium
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isUnlocked) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        ),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isUnlocked) AccentAmber else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        if (isUnlocked) AccentAmber.copy(alpha = 0.2f) else Color.Gray.copy(alpha = 0.15f),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isUnlocked) iconVector else Icons.Default.Lock,
                    contentDescription = null,
                    tint = if (isUnlocked) Color(0xFFFFA000) else Color.Gray,
                    modifier = Modifier.size(22.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = badge.nama,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isUnlocked) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    if (isUnlocked) {
                        Spacer(modifier = Modifier.width(6.dp))
                        Surface(
                            color = SuccessGreen.copy(alpha = 0.15f),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = "Terbuka",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = SuccessGreen,
                                modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = badge.deskripsi,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Syarat: ${badge.syarat}",
                    fontSize = 10.sp,
                    color = PrimaryBlue
                )
            }
        }
    }
}
