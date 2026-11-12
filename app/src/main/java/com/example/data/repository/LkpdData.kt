package com.example.data.repository

import com.example.data.model.LkpdItem
import com.example.data.model.LkpdQuestion
import com.example.data.model.RubrikItem

object LkpdData {

    val allLkpd: List<LkpdItem> = listOf(
        LkpdItem(
            id = 1,
            babId = 1,
            judul = "LKPD 1: Skala Prioritas dan Biaya Peluang Siswa SMAN 1 Pangkep",
            deskripsi = "Menganalisis pengelolaan uang saku bulanan dan menghitung biaya peluang nyata seorang pelajar.",
            petunjuk = listOf(
                "Baca studi kasus pengelolaan uang saku siswa dengan teliti.",
                "Susun daftar skala prioritas kebutuhan primer, sekunder, dan tersier.",
                "Tentukan alternatif keputusan ekonomi terbaik dan hitung nilai biaya peluangnya.",
                "Tuliskan jawaban analisis pada kolom isian interaktif di bawah ini."
            ),
            studiKasus = "Rian, siswa kelas X di SMAN 1 Pangkep, menerima uang saku mingguan sebesar Rp100.000 dari orang tuanya. Pada hari Senin, Rian dihadapkan pada beberapa kebutuhan: (1) Membeli buku modul ringkasan ekonomi seharga Rp45.000, (2) Makan siang di kantin sekolah Rp35.000, (3) Membeli casing ponsel bergambar yang sedang viral Rp50.000, dan (4) Menabung untuk kas kelas Rp20.000. Uang sakunya tidak mencukupi untuk memenuhi seluruh keinginan tersebut.",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Identifikasi dan kelompokkan kebutuhan Rian di atas ke dalam kategori kebutuhan primer, sekunder, dan tersier!", "Pertimbangkan intensitas urgensi bagi kegiatan belajar."),
                LkpdQuestion(2, "Susunlah tabel matriks Skala Prioritas yang paling rasional untuk Rian dengan total anggaran Rp100.000!", "Urutkan dari yang paling mendesak dan beri alasan."),
                LkpdQuestion(3, "Jika Rian memutuskan membeli casing ponsel seharga Rp50.000 dan mengorbankan pembelian modul ekonomi serta tabungan kas kelas, berapakah biaya peluang yang ditanggung Rian? Jelaskan dampak jangka panjangnya!", "Jelaskan definisi biaya peluang dan konsekuensi akademiknya.")
            ),
            rubrik = listOf(
                RubrikItem("Klasifikasi Kebutuhan", 30, "Tepat membedakan primer, sekunder, dan tersier"),
                RubrikItem("Skala Prioritas", 35, "Matriks prioritas logis, seimbang, dan sesuai batas anggaran Rp100.000"),
                RubrikItem("Analisis Biaya Peluang", 35, "Perhitungan nilai kesempatan yang hilang akurat disertai dampak rasional")
            ),
            filePdfName = "lkpd_1_skala_prioritas.pdf"
        ),
        LkpdItem(
            id = 2,
            babId = 2,
            judul = "LKPD 2: Circular Flow Usaha Bandeng Tanpa Duri Pangkep",
            deskripsi = "Membedah rantai pasok dan arus interaksi pelaku ekonomi pada sentra pengolahan ikan bandeng khas Pangkep.",
            petunjuk = listOf(
                "Cermati diagram arus melingkar kegiatan ekonomi 4 sektor.",
                "Analisis keterkaitan antara nelayan tambak, UMKM pengolahan bandeng, pemerintah daerah, dan pasar luar daerah.",
                "Jelaskan aliran uang dan barang secara sistematis."
            ),
            studiKasus = "Kabupaten Pangkajene dan Kepulauan terkenal sebagai sentra bandeng berkualitas tinggi. Pak Bahar adalah petambak bandeng lokal yang menjual hasil panennya ke UMKM 'Bandeng Presto SMANSA Rasa'. UMKM tersebut mempekerjakan 10 warga sekitar, membayar pajak retribusi ke Pemda Pangkep, serta mengirimkan paket bandeng kemasan vakum ke distributor di Makassar dan Surabaya.",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Identifikasi peran masing-masing pihak dalam studi kasus di atas ke dalam 4 pelaku kegiatan ekonomi (RTK, RTP, RTN, MLN/Luar Daerah)!", "Sebutkan nama pihak dan perannya."),
                LkpdQuestion(2, "Jelaskan aliran faktor produksi dan balas jasa yang terjadi antara Pak Bahar, para pekerja warga, dan UMKM Bandeng!", "Uraikan tanah/tambak, tenaga kerja, upah, dan laba."),
                LkpdQuestion(3, "Bagaimanakah peran Pemerintah Daerah Pangkep dalam diagram arus melingkar tersebut? Sebutkan manfaat timbal balik pajak dan subsidi/fasilitas jalan yang diberikan!", "Jelaskan aspek regulasi dan barang publik.")
            ),
            rubrik = listOf(
                RubrikItem("Identifikasi Pelaku", 30, "Mampu memetakan 4 pelaku secara komprehensif"),
                RubrikItem("Arus Faktor Produksi & Pasar Output", 40, "Menguraikan alur barang dan uang secara runtut"),
                RubrikItem("Peran Pemerintah & Eksternal", 30, "Menjelaskan konsep subsidi, pajak, dan perdagangan antar wilayah")
            ),
            filePdfName = "lkpd_2_circular_flow_bandeng.pdf"
        ),
        LkpdItem(
            id = 3,
            babId = 3,
            judul = "LKPD 3: Mekanisme Harga dan Keseimbangan Pasar Ikan Bandeng Pangkep",
            deskripsi = "Menghitung persamaan fungsi matematis permintaan dan penawaran serta menentukan titik ekuilibrium pasar.",
            petunjuk = listOf(
                "Gunakan rumus matematis fungsi linear permintaan dan penawaran.",
                "Hitung nilai harga keseimbangan (P) dan kuantitas keseimbangan (Q).",
                "Analisis dampak pergeseran kurva bila terjadi musim panen raya."
            ),
            studiKasus = "Di Pasar Sentral Pangkep, survei mencatat fungsi permintaan harian konsumen terhadap ikan bandeng adalah Qd = 200 - 2P, sedangkan fungsi penawaran dari para pedagang adalah Qs = -40 + 4P (di mana P dalam ribuan rupiah per kg, dan Q dalam kg).",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Hitunglah harga keseimbangan pasar (P) dan jumlah keseimbangan (Q) ikan bandeng tersebut dengan menyamakan Qd = Qs!", "Tuliskan langkah-langkah aljabar secara lengkap."),
                LkpdQuestion(2, "Jika pemerintah daerah menetapkan harga eceran tertinggi sebesar Rp30.000 (P = 30), apakah terjadi shortage (kelebihan permintaan) atau surplus? Berapa selisihnya?", "Substitusikan P=30 ke fungsi Qd dan Qs."),
                LkpdQuestion(3, "Bila cuaca buruk melanda perairan tambak sehingga biaya pakan ikan naik tajam, bagaimana pengaruhnya terhadap kurva penawaran ikan bandeng? Gambarkan arah pergeserannya!", "Jelaskan pergeseran kurva ke kiri atau ke kanan.")
            ),
            rubrik = listOf(
                RubrikItem("Perhitungan Keseimbangan", 40, "Langkah aljabar benar menghasilkan P=40 dan Q=120"),
                RubrikItem("Analisis Ketidakseimbangan", 30, "Hitungan surplus/shortage tepat"),
                RubrikItem("Pergeseran Kurva Non-Harga", 30, "Penjelasan faktor biaya dan arah kurva tepat")
            ),
            filePdfName = "lkpd_3_keseimbangan_pasar.pdf"
        ),
        LkpdItem(
            id = 4,
            babId = 4,
            judul = "LKPD 4: Pembayaran Digital dan QRIS di Lingkungan Sekolah SMAN 1 Pangkep",
            deskripsi = "Observasi lapangan penggunaan uang tunai vs non-tunai serta penerapan QRIS di kantin sekolah.",
            petunjuk = listOf(
                "Lakukan observasi sederhana pada kebiasaan transaksi di kantin atau koperasi SMAN 1 Pangkep.",
                "Bandingkan efisiensi transaksi tunai dan QRIS.",
                "Tuliskan rekomendasi digitalisasi sistem pembayaran di lingkungan sekolah."
            ),
            studiKasus = "Koperasi Siswa dan kantin SMAN 1 Pangkep mulai melayani pembayaran dengan stiker QRIS di meja kasir. Namun, sebagian siswa dan penjual jajanan tradisional masih lebih memilih uang tunai receh dengan alasan tidak perlu kuota internet dan tidak ada jeda loading aplikasi ponsel.",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Sebutkan minimal 3 kelebihan dan 2 kendala nyata penggunaan QRIS di kantin sekolah berdasarkan hasil pengamatanmu!", "Tinjau dari sisi kebersihan, kecepatan uang kembalian, dan konektivitas."),
                LkpdQuestion(2, "Jelaskan bagaimana metode 3D (Dilihat, Diraba, Diterawang) tetap penting diterapkan oleh kasir sekolah saat menerima pembayaran uang kertas tunai!", "Kaitkan dengan pencegahan peredaran uang palsu."),
                LkpdQuestion(3, "Sebagai pelajar sadar digital, langkah inovatif apa yang kamu usulkan agar seluruh kantin sekolah bertransformasi menuju ekosistem Cashless Society yang inklusif?", "Berikan ide program edukasi atau reward bagi siswa.")
            ),
            rubrik = listOf(
                RubrikItem("Hasil Observasi Lapangan", 35, "Fakta lapangan di sekolah diuraikan objektif"),
                RubrikItem("Pemahaman Keaslian Uang & QRIS", 35, "Konsep 3D dan mekanisme QRIS dipahami baik"),
                RubrikItem("Solusi & Rekomendasi", 30, "Solusi kreatif, aplikatif, dan realistis")
            ),
            filePdfName = "lkpd_4_qris_sekolah.pdf"
        ),
        LkpdItem(
            id = 5,
            babId = 5,
            judul = "LKPD 5: OJK dan Waspada Investasi Bodong di Masyarakat Pangkep",
            deskripsi = "Studi kritis menganalisis modus penipuan berkedok arisan online dan pinjol ilegal menggunakan prinsip 2L.",
            petunjuk = listOf(
                "Pelajari kasus penipuan keuangan yang sering menyasar masyarakat dan generasi muda.",
                "Gunakan pisau analisis Prinsip 2L (Legal dan Logis) dari OJK.",
                "Susun rencana kampanye literasi anti-investasi bodong."
            ),
            studiKasus = "Beredar pesan berantai di grup obrolan warga Pangkep yang menawarkan 'Arisan Duet Kilat Berkah'. Peserta dijanjikan keuntungan 40% dalam 10 hari tanpa potongan dan tanpa risiko. Pengelola mengaku memiliki izin dari lembaga internasional namun tidak tercatat di daftar resmi OJK.",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Ujilah tawaran investasi di atas menggunakan Prinsip 2L (Legal dan Logis)! Jelaskan indikator mana saja yang dilanggar!", "Periksa legalitas izin di Indonesia dan kewajaran imbal hasil 40%."),
                LkpdQuestion(2, "Mengapa skema penipuan model Ponzi selalu runtuh pada akhirnya dan merugikan anggota yang baru bergabung?", "Jelaskan perputaran dana dari anggota lama dan baru."),
                LkpdQuestion(3, "Jika salah satu keluargamu dihubungi dan diteror oleh debt collector pinjol ilegal yang menagih utang orang lain, langkah hukum dan pengaduan apa yang harus dilakukan?", "Sebutkan nomor kontak OJK dan kanal Satgas PASTI.")
            ),
            rubrik = listOf(
                RubrikItem("Analisis Prinsip 2L", 35, "Kritisi legalitas dan kelogisan secara tajam"),
                RubrikItem("Dekomposisi Skema Ponzi", 35, "Memahami kelemahan struktural piramida dana"),
                RubrikItem("Tindakan Mitigasi & Aduan", 30, "Langkah proteksi dan kanal kontak OJK 157 tepat")
            ),
            filePdfName = "lkpd_5_ojk_investasi_bodong.pdf"
        ),
        LkpdItem(
            id = 6,
            babId = 6,
            judul = "LKPD 6: Perencanaan Keuangan dan Neraca Pribadi Siswa Kelas X",
            deskripsi = "Menyusun anggaran pribadi bulanan dengan metode 50/30/20 dan merancang neraca aset bersih masa depan.",
            petunjuk = listOf(
                "Tuliskan estimasi uang saku atau penghasilan bulananmu.",
                "Distribusikan anggaran menggunakan formula 50/30/20.",
                "Susun tabel neraca keuangan pribadi (Aset - Liabilitas = Net Worth)."
            ),
            studiKasus = "Sebagai siswa kelas X SMA, kamu ingin memiliki perencanaan keuangan yang matang agar tidak mengalami defisit uang saku di akhir bulan dan dapat membeli laptop sendiri saat masuk perguruan tinggi.",
            pertanyaanList = listOf(
                LkpdQuestion(1, "Buatlah simulasi perencanaan anggaran uang saku bulananmu (misal Rp300.000 atau nominal aslimu) dengan aturan 50/30/20! Rincikan pos Needs, Wants, dan Savings!", "Tuliskan nominal dan persentasenya secara rinci."),
                LkpdQuestion(2, "Susunlah Neraca Keuangan Pribadi sederhanamu hari ini! Daftarkan seluruh Aset (kas, tabungan, barang milik sendiri) dan Utang, lalu hitung Kekayaan Bersihmu!", "Gunakan rumus: Kekayaan Bersih = Total Aset - Total Utang."),
                LkpdQuestion(3, "Strategi apa yang akan kamu lakukan jika di pertengahan bulan terjadi kenaikan harga bensin/ongkos angkutan umum yang menggerus pos kebutuhan pokok?", "Jelaskan penyesuaian pos keinginan dan prioritas.")
            ),
            rubrik = listOf(
                RubrikItem("Penerapan Aturan 50/30/20", 40, "Pembagian proporsional dan disiplin pos"),
                RubrikItem("Penyusunan Neraca Keuangan", 35, "Format aset dan liabilitas terstruktur rapi"),
                RubrikItem("Strategi Mitigasi Arus Kas", 25, "Solusi realistis dalam menahan defisit")
            ),
            filePdfName = "lkpd_6_perencanaan_keuangan.pdf"
        )
    )

    fun getLkpdById(id: Int): LkpdItem? = allLkpd.find { it.id == id }
    fun getLkpdByBab(babId: Int): LkpdItem? = allLkpd.find { it.babId == babId }
}
