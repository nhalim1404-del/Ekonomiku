package com.example.data.repository

data class FraudScenario(
    val id: Int,
    val judul: String,
    val tawaran: String,
    val isLegalLogis: Boolean, // true = Legal & Logis, false = Waspada/Fraud
    val alasan: String,
    val tipsOjk: String
)

object LabData {
    val fraudScenarios = listOf(
        FraudScenario(
            id = 1,
            judul = "Investasi Titip Modal Emas Berkah",
            tawaran = "Menjanjikan keuntungan pasti 1% per hari (30% sebulan) tanpa risiko modal berkurang. Ada bonus komisi 10% jika berhasil merekrut teman baru bergabung.",
            isLegalLogis = false,
            alasan = "Tidak logis dan berindikasi kuat skema Ponzi. Tidak ada bisnis riil yang mampu memberikan keuntungan pasti 30% per bulan tanpa risiko. Uang keuntungan anggota lama berasal dari setoran anggota baru.",
            tipsOjk = "Ingat prinsip 2L: Cek izin legalitas entitas di situs ojk.go.id, dan tolak tawaran yang menjanjikan bunga tinggi yang tidak logis."
        ),
        FraudScenario(
            id = 2,
            judul = "Surat Berharga Negara (SBN) Ritel Seri ORI",
            tawaran = "Investasi obligasi negara yang diterbitkan pemerintah melalui Kementerian Keuangan. Kupon bunga tetap 6,2% per tahun dibayar tiap bulan, dijamin undang-undang.",
            isLegalLogis = true,
            alasan = "Legal dan Logis. Diterbitkan langsung oleh Pemerintah Republik Indonesia melalui Kementerian Keuangan dan dijamin penuh pelunasan pokok beserta bunganya oleh APBN.",
            tipsOjk = "SBN Ritel adalah instrumen investasi resmi yang aman bagi pemula untuk membantu pembiayaan pembangunan nasional."
        ),
        FraudScenario(
            id = 3,
            judul = "Aplikasi Dana Kilat Langsung Cair",
            tawaran = "Pinjaman tanpa syarat KTP dan tanpa slip gaji, 5 menit cair ke rekening. Namun saat instalasi aplikasi meminta izin akses seluruh kontak telepon, galeri foto, dan riwayat panggilan.",
            isLegalLogis = false,
            alasan = "Ini adalah ciri mutlak pinjol ilegal! Pinjol berizin OJK dilarang keras meminta izin kontak telepon dan galeri foto. Data tersebut disalahgunakan untuk teror intimidasi penagihan.",
            tipsOjk = "Fintech berizin OJK hanya diizinkan mengakses CAMILAN (Camera, Microphone, Location). Jangan pernah menginstal aplikasi pinjol tak berizin."
        ),
        FraudScenario(
            id = 4,
            judul = "Fintech P2P Lending Berizin Resmi OJK",
            tawaran = "Aplikasi pinjaman mikro produktif UMKM berizin resmi OJK. Bunga transparan dan patuh batas asosiasi AFPI, syarat KTP jelas, dan penagihan tunduk pada kode etik profesional.",
            isLegalLogis = true,
            alasan = "Legal dan Logis. Penyelenggara terdaftar resmi dan diawasi oleh OJK. Seluruh biaya, denda, dan bunga dibuka secara transparan kepada calon peminjam.",
            tipsOjk = "Selalu periksa daftar terkini fintech lending berizin di website resmi OJK atau hubungi Kontak OJK 157 sebelum mengajukan pinjaman."
        ),
        FraudScenario(
            id = 5,
            judul = "Grup Telegram Trading VIP Auto Profit",
            tawaran = "Titip dana modal Rp1.000.000 dijanjikan berkembang menjadi Rp10.000.000 dalam 6 jam. Setelah mentransfer modal, admin meminta transfer tambahan dana aktivasi akun dan pajak pencairan.",
            isLegalLogis = false,
            alasan = "Modus penipuan klasik pig butchering scam! Pelaku memanipulasi tangkapan layar saldo palsu dan terus meminta setoran dana tambahan hingga korban kehabisan uang.",
            tipsOjk = "Waspadai tawaran investasi melalui media sosial dan grup perpesanan instan yang tidak jelas pengelolanya."
        )
    )
}
