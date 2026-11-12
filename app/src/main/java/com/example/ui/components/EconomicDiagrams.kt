package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.DiagramType

@Composable
fun EconomicDiagramViewer(
    type: DiagramType,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (type) {
                DiagramType.MASLOW_PYRAMID -> MaslowPyramidDiagram()
                DiagramType.PPF_CURVE -> PpfCurveDiagram()
                DiagramType.CIRCULAR_FLOW -> CircularFlowDiagram()
                DiagramType.MARKET_EQUILIBRIUM -> MarketEquilibriumDiagram()
                DiagramType.QRIS_FLOW -> QrisFlowDiagram()
                DiagramType.PAWN_FLOW -> PawnFlowDiagram()
                DiagramType.FINANCIAL_PYRAMID -> FinancialPyramidDiagram()
            }
        }
    }
}

@Composable
fun MaslowPyramidDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hierarki Piramida Kebutuhan Maslow",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Dari kebutuhan dasar biologis hingga aktualisasi diri",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(12.dp))

        val levels = listOf(
            Triple("5. Aktualisasi Diri", "Mengembangkan bakat, potensi puncak", Color(0xFF9C27B0)),
            Triple("4. Penghargaan", "Status, prestise, rasa hormat", Color(0xFF3F51B5)),
            Triple("3. Kasih Sayang & Sosial", "Pertemanan, keluarga, komunitas", Color(0xFF009688)),
            Triple("2. Rasa Aman & Perlindungan", "Kesehatan, pekerjaan, tabungan", Color(0xFFFF9800)),
            Triple("1. Kebutuhan Fisiologis", "Pangan, sandang, tempat tinggal", Color(0xFFE53935))
        )

        levels.forEachIndexed { index, (title, desc, color) ->
            val widthPercent = 0.45f + (index * 0.13f)
            Surface(
                modifier = Modifier
                    .fillMaxWidth(widthPercent)
                    .padding(vertical = 3.dp),
                shape = RoundedCornerShape(6.dp),
                color = color.copy(alpha = 0.15f),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, color)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = color
                    )
                    Text(
                        text = desc,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun PpfCurveDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Kurva Batas Kemungkinan Produksi (PPF)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Trade-off alokasi sumber daya dan biaya peluang",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .size(260.dp, 180.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxWidth().height(140.dp)) {
                val w = size.width
                val h = size.height

                // Axes
                drawLine(
                    color = Color.Gray,
                    start = Offset(30f, 10f),
                    end = Offset(30f, h - 20f),
                    strokeWidth = 3f
                )
                drawLine(
                    color = Color.Gray,
                    start = Offset(30f, h - 20f),
                    end = Offset(w - 10f, h - 20f),
                    strokeWidth = 3f
                )

                // PPF Curve (Concave down)
                val path = Path().apply {
                    moveTo(30f, 25f)
                    quadraticTo(w * 0.55f, 35f, w - 25f, h - 20f)
                }
                drawPath(path = path, color = Color(0xFF1976D2), style = Stroke(width = 4f))

                // Points
                // Point A: Efficient (on curve)
                drawCircle(color = Color(0xFF2E7D32), radius = 6f, center = Offset(w * 0.45f, 60f))
                // Point B: Inefficient (inside curve)
                drawCircle(color = Color(0xFFFFA000), radius = 6f, center = Offset(w * 0.35f, 95f))
                // Point C: Unattainable (outside curve)
                drawCircle(color = Color(0xFFD32F2F), radius = 6f, center = Offset(w * 0.75f, 40f))
            }
        }

        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LegendItem(color = Color(0xFF2E7D32), label = "A: Efisien")
            LegendItem(color = Color(0xFFFFA000), label = "B: Menganggur")
            LegendItem(color = Color(0xFFD32F2F), label = "C: Tak Tercapai")
        }
    }
}

@Composable
fun CircularFlowDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Circular Flow Diagram (Arus Melingkar 4 Sektor)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Interaksi RTK, RTP, Pemerintah, dan Luar Negeri",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FlowEntityCard(title = "RTK (Konsumen)", subtitle = "Sedia faktor produksi,\nkonsumsi produk", color = Color(0xFF1976D2))
            FlowEntityCard(title = "RTP (Produsen)", subtitle = "Olah faktor produksi,\nhasilkan barang/jasa", color = Color(0xFF388E3C))
        }

        Spacer(modifier = Modifier.height(8.dp))
        FlowEntityCard(
            title = "Pemerintah (RTN)",
            subtitle = "Regulasi, Pajak, Subsidi, & Belanja Publik",
            color = Color(0xFFE65100),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowEntityCard(
            title = "Masyarakat Luar Negeri (MLN)",
            subtitle = "Kegiatan Ekspor & Impor (Suntikan & Bocoran)",
            color = Color(0xFF7B1FA2),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
    }
}

@Composable
fun FlowEntityCard(
    title: String,
    subtitle: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        color = color.copy(alpha = 0.12f),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, color)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = color)
            Text(text = subtitle, fontSize = 9.sp, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}

@Composable
fun MarketEquilibriumDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Keseimbangan Pasar (Market Equilibrium)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Titik potong Kurva Permintaan (D) & Penawaran (S)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .size(260.dp, 180.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Canvas(modifier = Modifier.fillMaxWidth().height(140.dp)) {
                val w = size.width
                val h = size.height

                // Axes P and Q
                drawLine(color = Color.Gray, start = Offset(30f, 10f), end = Offset(30f, h - 20f), strokeWidth = 3f)
                drawLine(color = Color.Gray, start = Offset(30f, h - 20f), end = Offset(w - 10f, h - 20f), strokeWidth = 3f)

                // Demand curve (downward)
                drawLine(color = Color(0xFFD32F2F), start = Offset(45f, 20f), end = Offset(w - 25f, h - 30f), strokeWidth = 4f)
                // Supply curve (upward)
                drawLine(color = Color(0xFF1976D2), start = Offset(45f, h - 35f), end = Offset(w - 25f, 25f), strokeWidth = 4f)

                // Intersection Point E
                val midX = (45f + w - 25f) / 2
                val midY = (20f + h - 30f) / 2
                drawCircle(color = Color(0xFFFFA000), radius = 7f, center = Offset(midX, midY))
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LegendItem(color = Color(0xFFD32F2F), label = "Permintaan (D)")
            LegendItem(color = Color(0xFF1976D2), label = "Penawaran (S)")
            LegendItem(color = Color(0xFFFFA000), label = "E(P=40, Q=120)")
        }
    }
}

@Composable
fun QrisFlowDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Alur Pembayaran Standar QRIS",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Satu kode QR untuk seluruh aplikasi pembayaran",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(10.dp))

        val steps = listOf(
            "1. Merchant Pasang QRIS" to "Toko/Kantin sediakan satu kode QR cetak/statis.",
            "2. Pembeli Pindai (Scan)" to "Buka aplikasi m-Banking/e-Wallet dan arahkan kamera.",
            "3. Input Nominal & PIN" to "Sistem routing BI-FAST / ASPI memproses verifikasi seketika.",
            "4. Notifikasi & Settlement" to "Dana masuk ke rekening merchant secara real-time."
        )

        steps.forEach { (step, desc) ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = step.take(1), color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = step, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                        Text(text = desc, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@Composable
fun PawnFlowDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Alur Layanan Gadai (Pegadaian)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Solusi pendanaan cepat dengan jaminan barang bergerak",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(10.dp))

        val stages = listOf(
            "1. Penyerahan Barang" to "Nasabah bawa barang jaminan (emas, BPKB, gawai).",
            "2. Penaksiran Nilai" to "Petugas taksir menentukan nilai intrinsik & batas pinjaman.",
            "3. Akad & Pencairan" to "Penetapan uang pinjaman + sewa modal (mu'nah). Dana cair tunai/transfer.",
            "4. Pelunasan / Tebus" to "Nasabah bayar pokok + sewa modal, barang jaminan dikembalikan utuh."
        )

        stages.forEach { (stage, desc) ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.dp),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF00897B).copy(alpha = 0.5f))
            ) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(Color(0xFF00897B), RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = stage.take(1), color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = stage, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00897B))
                        Text(text = desc, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    }
}

@Composable
fun FinancialPyramidDiagram() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Piramida Perencanaan Keuangan Sehat",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Fondasi kokoh sebelum berinvestasi agresif",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(10.dp))

        val layers = listOf(
            Triple("Tingkat 4: Distribusi Kekayaan", "Waris, hibah, wakaf, sedekah", Color(0xFF7B1FA2)),
            Triple("Tingkat 3: Akumulasi Investasi", "Saham, reksa dana, properti, emas", Color(0xFF1976D2)),
            Triple("Tingkat 2: Proteksi Risiko", "Asuransi kesehatan & jiwa (BPJS)", Color(0xFF00897B)),
            Triple("Tingkat 1: Fondasi Keamanan", "Arus kas positif & Dana darurat 3-6x", Color(0xFFFFA000))
        )

        layers.forEachIndexed { index, (title, desc, color) ->
            val widthFactor = 0.55f + (index * 0.15f)
            Surface(
                modifier = Modifier
                    .fillMaxWidth(widthFactor)
                    .padding(vertical = 3.dp),
                shape = RoundedCornerShape(6.dp),
                color = color.copy(alpha = 0.15f),
                border = androidx.compose.foundation.BorderStroke(1.5.dp, color)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = color)
                    Text(text = desc, fontSize = 9.sp, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onSurface)
                }
            }
        }
    }
}

@Composable
private fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.size(10.dp).background(color, RoundedCornerShape(2.dp)))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = label, fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurface)
    }
}
