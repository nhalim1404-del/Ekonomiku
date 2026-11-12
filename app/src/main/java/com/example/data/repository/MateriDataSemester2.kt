package com.example.data.repository

import com.example.data.model.Bab
import com.example.data.model.DiagramType
import com.example.data.model.GlosariumItem
import com.example.data.model.HighlightType
import com.example.data.model.MateriSection
import com.example.data.model.Subbab

object MateriDataSemester2 {

    val bab4 = Bab(
        id = 4,
        semester = 2,
        judul = "Bab 4: Bank Sentral dan Sistem Pembayaran",
        deskripsi = "Mengenal wewenang Bank Indonesia, evolusi sistem pembayaran digital BI-FAST/RTGS, keaslian Rupiah 3D, dan QRIS.",
        subbabList = listOf(
            Subbab(
                id = "4.1",
                babId = 4,
                judul = "4.1 Bank Sentral (Bank Indonesia)",
                ringkasan = "Kedudukan independen Bank Indonesia, tujuan tunggal mencapai kestabilan nilai rupiah, dan tiga pilar utama.",
                sections = listOf(
                    MateriSection.Heading("Tujuan Tunggal Bank Indonesia"),
                    MateriSection.Paragraph("Berdasarkan UU Nomor 23 Tahun 1999 (yang telah disempurnakan), Bank Indonesia adalah lembaga negara yang independen dengan satu tujuan tunggal: mencapai dan memelihara kestabilan nilai Rupiah. Kestabilan ini mencakup kestabilan harga barang/jasa (tercermin dari laju inflasi) serta kestabilan nilai tukar Rupiah terhadap mata uang asing."),
                    MateriSection.Heading("Tiga Pilar Tugas Pokok Bank Indonesia"),
                    MateriSection.Bullets(
                        listOf(
                            "1. Menetapkan dan Melaksanakan Kebijakan Moneter: Mengatur jumlah uang beredar melalui instrumen suku bunga acuan (BI-Rate), operasi pasar terbuka, dan giro wajib minimum.",
                            "2. Mengatur dan Menjaga Kelancaran Sistem Pembayaran: Menerbitkan uang rupiah dan menyusun regulasi infrastruktur kliring serta transfer antarbank.",
                            "3. Menjaga Stabilitas Sistem Keuangan (Makroprudensial): Mencegah risiko sistemik pada industri perbankan dan perekonomian nasional."
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.INGAT,
                        "Lender of the Last Resort",
                        "BI bertindak sebagai penyedia likuiditas darurat terakhir bagi bank umum yang mengalami kesulitan likuiditas jangka pendek demi menjaga stabilitas nasional."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("BI-Rate", "Suku bunga kebijakan acuan yang ditetapkan secara berkala oleh Bank Indonesia."),
                    GlosariumItem("Makroprudensial", "Kebijakan pengawasan stabilitas keuangan secara agregat dan menyeluruh.")
                )
            ),
            Subbab(
                id = "4.2",
                babId = 4,
                judul = "4.2 Sistem Pembayaran di Indonesia",
                ringkasan = "Evolusi pembayaran tunai ke digital serta sistem BI-FAST, BI-RTGS, dan SKNBI.",
                sections = listOf(
                    MateriSection.Heading("Klasifikasi Sistem Kliring & Transfer"),
                    MateriSection.Table(
                        headers = listOf("Sistem", "Kepanjangan", "Karakteristik & Waktu", "Batas Nominal"),
                        rows = listOf(
                            listOf("BI-RTGS", "Real Time Gross Settlement", "Seketika per transaksi individu, untuk transaksi bernilai besar", "Di atas Rp100 juta"),
                            listOf("SKNBI", "Sistem Kliring Nasional BI", "Penyelesaian berkala per batch (hitungan jam)", "Maksimal Rp1 miliar"),
                            listOf("BI-FAST", "Bank Indonesia Fast Payment", "Real-time 24/7/365, biaya rendah (Rp2.500)", "Maksimal Rp250 juta per transaksi")
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.TAHUKAH_KAMU,
                        "Kedaulatan Sistem Pembayaran",
                        "BI-FAST diluncurkan BI untuk mempercepat inklusi keuangan digital dan memperkuat kedaulatan transaksi domestik nasional."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("BI-RTGS", "Sistem transfer dana elektronik bernilai besar yang diselesaikan seketika."),
                    GlosariumItem("BI-FAST", "Infrastruktur sistem pembayaran ritel nasional yang beroperasi 24 jam sepanjang minggu.")
                )
            ),
            Subbab(
                id = "4.3",
                babId = 4,
                judul = "4.3 Alat Pembayaran Tunai dan Non-Tunai",
                ringkasan = "Uang kartal vs giral, mengenali keaslian Rupiah dengan 3D (Dilihat, Diraba, Diterawang), serta mekanisme QRIS.",
                sections = listOf(
                    MateriSection.Heading("Uang Kartal vs Uang Giral"),
                    MateriSection.Paragraph("Uang kartal adalah uang kertas dan logam yang wajib diterima sebagai alat pembayaran sah (legal tender). Uang giral adalah tagihan simpanan di bank yang dapat dicairkan sewaktu-waktu lewat cek, bilyet giro, kartu debit, atau m-Banking."),
                    MateriSection.Heading("Metode 3D untuk Memeriksa Keaslian Uang Rupiah"),
                    MateriSection.Bullets(
                        listOf(
                            "Dilihat: Perhatikan warna uang yang cerah, benang pengaman berubah warna saat dimiringkan, serta gambar perisai logo BI tersembunyi.",
                            "Diraba: Rasakan tekstur kasar pada cetakan lambang Garuda, angka nominal, gambar pahlawan, serta kode tuna netra (blind code).",
                            "Diterawang: Arahkan ke cahaya untuk melihat tanda air (watermark) gambar pahlawan dan rectoverso (logo BI presisi bolak-balik)."
                        )
                    ),
                    MateriSection.Heading("Alur Transaksi Standar QRIS"),
                    MateriSection.InteractiveDiagram(DiagramType.QRIS_FLOW),
                    MateriSection.HighlightBox(
                        HighlightType.CONTOH,
                        "Kantin Digital SMANSA",
                        "Siswa SMAN 1 Pangkep cukup memindai satu QRIS di kantin sekolah menggunakan m-Banking atau dompet digital apa saja tanpa perlu membawa uang kembalian receh."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("QRIS", "Quick Response Code Indonesian Standard; standar kode QR pembayaran nasional."),
                    GlosariumItem("Rectoverso", "Teknik cetak gambar bolak-balik saling mengisi membentuk logo utuh saat diterawang.")
                )
            )
        )
    )

    val bab5 = Bab(
        id = 5,
        semester = 2,
        judul = "Bab 5: OJK dan Lembaga Keuangan",
        deskripsi = "Memahami wewenang OJK, prinsip 2L, industri perbankan 5C, penjaminan simpanan LPS 3T, pasar modal, dan IKNB.",
        subbabList = listOf(
            Subbab(
                id = "5.1",
                babId = 5,
                judul = "5.1 OJK (Otoritas Jasa Keuangan)",
                ringkasan = "Fungsi pengawasan mikroprudensial sektor jasa keuangan terintegrasi dan perlindungan konsumen lewat prinsip 2L.",
                sections = listOf(
                    MateriSection.Heading("Tujuan dan Wewenang OJK"),
                    MateriSection.Paragraph("OJK dibentuk berdasarkan UU No. 21 Tahun 2011 untuk menyelenggarakan sistem pengaturan dan pengawasan yang terintegrasi terhadap keseluruhan kegiatan di dalam sektor perbankan, pasar modal, perasuransian, dana pensiun, lembaga pembiayaan, dan fintech."),
                    MateriSection.HighlightBox(
                        HighlightType.WASPADA,
                        "Prinsip 2L Wajib Sebelum Bertransaksi Keuangan",
                        "1. Legal: Pastikan lembaga dan produknya memiliki izin resmi terdaftar dan diawasi oleh OJK.\n2. Logis: Keuntungan atau bunga yang dijanjikan harus masuk akal, rasional, dan memiliki model bisnis riil yang jelas."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("OJK", "Lembaga independen yang mengatur dan mengawasi seluruh industri jasa keuangan di Indonesia."),
                    GlosariumItem("Prinsip 2L", "Legal dan Logis; pedoman literasi masyarakat agar terhindar dari investasi bodong.")
                )
            ),
            Subbab(
                id = "5.2",
                babId = 5,
                judul = "5.2 Perbankan di Indonesia dan LPS",
                ringkasan = "Fungsi intermediasi perbankan, analisis kredit 5C, serta batas penjaminan simpanan LPS dan syarat 3T.",
                sections = listOf(
                    MateriSection.Heading("Prinsip 5C Analisis Kelayakan Kredit"),
                    MateriSection.Bullets(
                        listOf(
                            "Character: Watak, integritas, dan kejujuran calon peminjam untuk memenuhi kewajibannya.",
                            "Capacity: Kemampuan finansial nasabah dalam melunasi angsuran (dilihat dari pendapatan).",
                            "Capital: Modal sendiri yang dimiliki nasabah sebagai bentuk komitmen usaha.",
                            "Collateral: Jaminan atau agunan fisik yang diserahkan sebagai perlindungan bank jika macet.",
                            "Condition: Kondisi ekonomi makro dan prospek industri usaha nasabah."
                        )
                    ),
                    MateriSection.Heading("Lembaga Penjamin Simpanan (LPS)"),
                    MateriSection.Paragraph("LPS menjamin saldo simpanan nasabah di bank hingga maksimal Rp2 Miliar per nasabah per bank dengan memenuhi Syarat 3T:"),
                    MateriSection.Table(
                        headers = listOf("Syarat LPS", "Keterangan", "Tindakan Nasabah"),
                        rows = listOf(
                            listOf("Tercatat", "Tercatat pada pembukuan resmi bank", "Pastikan bukti setoran tercetak sah"),
                            listOf("Tingkat Bunga Wajar", "Tidak melebihi suku bunga penjaminan LPS", "Tolak iming-iming bunga perbankan di atas batas LPS"),
                            listOf("Tidak Merugikan", "Tidak melakukan tindakan yang merugikan bank", "Bebas dari kredit macet atau perbuatan pidana bank")
                        )
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Prinsip 5C", "Pedoman komprehensif bank dalam menilai kelayakan pemberian fasilitas pembiayaan."),
                    GlosariumItem("LPS", "Lembaga Penjamin Simpanan yang menjamin dana tabungan nasabah hingga Rp2 Miliar.")
                )
            ),
            Subbab(
                id = "5.3",
                babId = 5,
                judul = "5.3 Pasar Modal dan Investasi",
                ringkasan = "Instrumen saham, obligasi korporasi, sukuk negara, reksa dana, dan mekanisme Bursa Efek Indonesia.",
                sections = listOf(
                    MateriSection.Heading("Instrumen Utama Pasar Modal"),
                    MateriSection.Table(
                        headers = listOf("Instrumen", "Bukti Kepemilikan", "Bentuk Imbal Hasil", "Tingkat Risiko"),
                        rows = listOf(
                            listOf("Saham", "Bukti kepemilikan modal sebagian di PT", "Dividen dan Capital Gain", "Tinggi (High Risk, High Return)"),
                            listOf("Obligasi", "Surat utang jangka menengah-panjang", "Kupon bunga periodik & pokok utang", "Menengah"),
                            listOf("Sukuk", "Sertifikat kepemilikan aset riil syariah", "Ujrah / bagi hasil syariah tanpa riba", "Rendah - Menengah (dijamin negara)"),
                            listOf("Reksa Dana", "Wadah investasi kolektif dikelola Manajer Investasi", "Kenaikan Nilai Aktiva Bersih (NAB)", "Tergantung jenis (Pasar Uang sd Saham)")
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.INGAT,
                        "Diversifikasi Portofolio",
                        "Jangan menaruh semua telur dalam satu keranjang (Don't put all your eggs in one basket). Sebarkan investasi ke berbagai instrumen untuk meminimalkan risiko kerugian."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Capital Gain", "Keuntungan dari selisih harga jual saham yang lebih tinggi daripada harga belinya."),
                    GlosariumItem("Manajer Investasi", "Pihak profesional berlisensi OJK yang mengelola portofolio reksa dana.")
                )
            ),
            Subbab(
                id = "5.4",
                babId = 5,
                judul = "5.4 Lembaga Keuangan Non-Bank (IKNB)",
                ringkasan = "Layanan asuransi, dana pensiun, leasing/pembiayaan, serta alur gadai barang di Pegadaian.",
                sections = listOf(
                    MateriSection.Heading("Industri Keuangan Non-Bank"),
                    MateriSection.Bullets(
                        listOf(
                            "Asuransi: Pengalihan risiko finansial dengan pembayaran premi rutin.",
                            "Dana Pensiun: Menghimpun dana persiapan kesejahteraan hari tua.",
                            "Perusahaan Pembiayaan (Leasing): Pembiayaan pengadaan barang modal atau kendaraan bermotor."
                        )
                    ),
                    MateriSection.Heading("Alur Pelayanan Gadai di Pegadaian"),
                    MateriSection.InteractiveDiagram(DiagramType.PAWN_FLOW)
                ),
                glosarium = listOf(
                    GlosariumItem("Marhun", "Barang yang digadaikan sebagai jaminan pinjaman dalam gadai syariah (Rahn)."),
                    GlosariumItem("Premi", "Uang iuran yang dibayarkan nasabah secara berkala kepada perusahaan asuransi.")
                )
            )
        )
    )

    val bab6 = Bab(
        id = 6,
        semester = 2,
        judul = "Bab 6: Risiko dan Keuangan Pribadi",
        deskripsi = "Mengidentifikasi risiko finansial, waspada penipuan investasi & pinjol ilegal, serta menyusun neraca dan anggaran 50/30/20.",
        subbabList = listOf(
            Subbab(
                id = "6.1",
                babId = 6,
                judul = "6.1 Risiko dalam Ekonomi dan Investasi",
                ringkasan = "Membedakan risiko sistematis vs non-sistematis dan memahami kaidah Risk-Return Tradeoff.",
                sections = listOf(
                    MateriSection.Heading("Jenis-Jenis Risiko Finansial"),
                    MateriSection.Bullets(
                        listOf(
                            "Risiko Sistematis (Market Risk): Risiko eksternal yang memengaruhi seluruh pasar secara luas dan tidak dapat dihilangkan lewat diversifikasi (misal: perang, resesi global, kenaikan suku bunga bank sentral).",
                            "Risiko Non-Sistematis (Spesifik): Risiko internal perusahaan tertentu (misal: kebangkrutan manajemen, mogok kerja karyawan). Dapat diminimalisir melalui diversifikasi aset."
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.INGAT,
                        "Hukum Besi Finansial: High Risk, High Return",
                        "Semakin tinggi potensi keuntungan suatu instrumen investasi, semakin besar pula risiko kerugian modal yang harus siap ditanggung. Tidak ada investasi yang 'pasti untung besar tanpa risiko sama sekali'."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Risk-Return Tradeoff", "Prinsip bahwa potensi pengembalian berbanding lurus dengan risiko yang diambil."),
                    GlosariumItem("Risiko Sistematis", "Risiko makro yang memengaruhi semua instrumen secara serentak.")
                )
            ),
            Subbab(
                id = "6.2",
                babId = 6,
                judul = "6.2 Manajemen Risiko dan Kejahatan Keuangan",
                ringkasan = "Ciri-ciri skema Ponzi/investasi bodong, bahaya jeratan pinjaman online ilegal, dan kanal pengaduan OJK.",
                sections = listOf(
                    MateriSection.Heading("Ciri-Ciri Investasi Bodong (Skema Ponzi)"),
                    MateriSection.Bullets(
                        listOf(
                            "Menjanjikan keuntungan sangat besar, pasti, dan tetap dalam waktu singkat (misal 1% per hari).",
                            "Klaim tanpa risiko sama sekali (zero risk).",
                            "Keuntungan anggota lama dibayarkan dari uang setoran anggota baru, bukan hasil laba usaha riil.",
                            "Mewajibkan perekrutan member baru (skema piramida) dan sulit saat ingin menarik dana kembali (withdrawal)."
                        )
                    ),
                    MateriSection.Heading("Bahaya Pinjol Ilegal vs Fintech Berizin OJK"),
                    MateriSection.Table(
                        headers = listOf("Pembeda", "Pinjol Berizin OJK", "Pinjol Ilegal"),
                        rows = listOf(
                            listOf("Legalitas", "Terdaftar & diawasi resmi di situs ojk.go.id", "Tidak terdaftar / memanipulasi izin"),
                            listOf("Akses Gawai", "Hanya CAMILAN (Camera, Microphone, Location)", "Minta seluruh kontak HP, galeri, SMS, media sosial"),
                            listOf("Bunga & Biaya", "Transparan, dibatasi regulasi AFPI", "Bunga harian mencekik, denda tak terbatas"),
                            listOf("Penagihan", "Sesuai etika profesi tanpa intimidasi", "Teror psikologis, ancaman sebar data pribadi ke kontak")
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.WASPADA,
                        "Kontak Layanan Konsumen OJK",
                        "Jika menemukan tawaran mencurigakan, hubungi Kontak OJK 157 atau WhatsApp resmi Satgas PASTI di nomor 081-157-157-157."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Skema Ponzi", "Penipuan investasi dengan membayar investor memakai dana investor berikutnya."),
                    GlosariumItem("Satgas PASTI", "Satuan Tugas Pemberantasan Aktivitas Keuangan Ilegal bentukan OJK dan 16 kementerian/lembaga.")
                )
            ),
            Subbab(
                id = "6.3",
                babId = 6,
                judul = "6.3 Perencanaan dan Laporan Keuangan Pribadi",
                ringkasan = "Menyusun anggaran metode 50/30/20, neraca aset-kewajiban, dan rasio keuangan sehat bagi pelajar.",
                sections = listOf(
                    MateriSection.Heading("Metode Anggaran Keuangan 50/30/20"),
                    MateriSection.Table(
                        headers = listOf("Porsi", "Kategori Pengeluaran", "Alokasi Nyata Pelajar"),
                        rows = listOf(
                            listOf("50%", "Kebutuhan Pokok (Needs)", "Ongkos sekolah, makan siang, kuota belajar, alat tulis"),
                            listOf("30%", "Keinginan (Wants)", "Jajan santai, hobi, hiburan akhir pekan"),
                            listOf("20%", "Tabungan & Investasi (Savings)", "Tabungan SimPel, dana darurat, sedekah")
                        )
                    ),
                    MateriSection.Heading("Piramida Perencanaan Keuangan Sehat"),
                    MateriSection.InteractiveDiagram(DiagramType.FINANCIAL_PYRAMID),
                    MateriSection.Heading("Neraca Keuangan Pribadi"),
                    MateriSection.FormulaCard(
                        title = "Rumus Kekayaan Bersih (Net Worth)",
                        formula = "Kekayaan Bersih = Total Aset - Total Kewajiban (Utang)",
                        explanation = "Aset terdiri dari tabungan, barang bernilai, dan kas. Utang harus diminimalisir agar kekayaan bersih terus bertumbuh positif."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Net Worth", "Nilai kekayaan bersih yang dihitung dari total aset dikurangi seluruh utang."),
                    GlosariumItem("Dana Darurat", "Simpanan likuid yang disiapkan khusus untuk keadaan mendesak tak terduga.")
                )
            )
        )
    )
}
