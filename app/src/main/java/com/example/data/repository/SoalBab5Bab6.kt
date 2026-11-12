package com.example.data.repository

import com.example.data.model.Soal

object SoalBab5Bab6 {

    val soalBab5: List<Soal> = listOf(
        Soal(
            id = 501, babId = 5, nomorSoal = 1,
            pertanyaan = "Lembaga independen yang bertugas mengatur, mengawasi, memeriksa, dan menyidik industri jasa keuangan di Indonesia berdasarkan UU No. 21 Tahun 2011 adalah...",
            opsi = listOf("Otoritas Jasa Keuangan (OJK)", "Bank Indonesia", "Lembaga Penjamin Simpanan (LPS)", "Badan Pengawas Keuangan (BPK)", "Komisi Pengawas Persaingan Usaha (KPPU)"),
            jawabanBenar = 0,
            pembahasan = "Otoritas Jasa Keuangan (OJK) adalah regulator independen yang mengawasi perbankan, pasar modal, dan IKNB secara terintegrasi."
        ),
        Soal(
            id = 502, babId = 5, nomorSoal = 2,
            pertanyaan = "Prinsip 2L yang disosialisasikan OJK kepada masyarakat sebagai benteng utama menghindari penipuan investasi bodong adalah...",
            opsi = listOf("Lancar dan Langsung", "Legal dan Logis", "Laba dan Luas", "Lengkap dan Loyal", "Lugas dan Lincah"),
            jawabanBenar = 1,
            pembahasan = "Prinsip 2L mensyaratkan izin entitas harus Legal terdaftar di OJK, dan imbal hasil yang dijanjikan harus Logis (rasional)."
        ),
        Soal(
            id = 503, babId = 5, nomorSoal = 3,
            pertanyaan = "Fungsi utama bank umum dalam sistem perekonomian nasional adalah sebagai lembaga intermediasi, yang bermakna...",
            opsi = listOf("Mencetak mata uang rupiah baru", "Menetapkan vonis pailit bagi perusahaan", "Menghimpun dana dari pihak yang surplus dana dan menyalurkannya kepada pihak yang defisit dana", "Mengatur tarif pajak bea cukai", "Menyediakan layanan tiket perjalanan gratis"),
            jawabanBenar = 2,
            pembahasan = "Intermediasi keuangan adalah menjembatani masyarakat yang memiliki kelebihan dana (penabung) dengan pihak yang membutuhkan modal usaha (debitur)."
        ),
        Soal(
            id = 504, babId = 5, nomorSoal = 4,
            pertanyaan = "Dalam penilaian kelayakan kredit perbankan menggunakan prinsip 5C, aspek yang menilai kepribadian, integritas, dan kejujuran calon debitur adalah...",
            opsi = listOf("Capacity", "Capital", "Collateral", "Character", "Condition"),
            jawabanBenar = 3,
            pembahasan = "Character menilai komitmen moral, rekam jejak, dan kemauan jujur nasabah dalam melunasi kewajiban pinjamannya."
        ),
        Soal(
            id = 505, babId = 5, nomorSoal = 5,
            pertanyaan = "Aspek Collateral dalam analisis kredit perbankan mengacu pada ketersediaan...",
            opsi = listOf("Jumlah modal sendiri yang disetor debitur", "Gelar akademik calon peminjam", "Kondisi stabilitas politik nasional", "Kemampuan arus kas pendapatan bulanan", "Agunan atau barang jaminan fisik yang diserahkan sebagai pelindung kredit macet"),
            jawabanBenar = 4,
            pembahasan = "Collateral adalah barang jaminan (seperti sertifikat tanah, BPKB kendaraan) yang dapat dieksekusi bank jika debitur cidera janji."
        ),
        Soal(
            id = 506, babId = 5, nomorSoal = 6,
            pertanyaan = "Lembaga Penjamin Simpanan (LPS) menjamin saldo simpanan nasabah perbankan hingga nilai maksimal sebesar...",
            opsi = listOf("Rp2 miliar per nasabah per bank", "Rp1 miliar per nasabah per bank", "Rp500 juta per nasabah per bank", "Rp5 miliar per nasabah per bank", "Rp10 miliar per nasabah per bank"),
            jawabanBenar = 0,
            pembahasan = "Sesuai ketentuan undang-undang, LPS menjamin saldo simpanan nasabah di bank hingga maksimal Rp2 Miliar per nasabah per bank."
        ),
        Soal(
            id = 507, babId = 5, nomorSoal = 7,
            pertanyaan = "Berikut ini yang BUKAN merupakan salah satu dari Syarat 3T agar simpanan nasabah dijamin oleh LPS adalah...",
            opsi = listOf("Tercatat dalam pembukuan resmi bank", "Terdaftar sebagai nasabah prioritas dengan saldo minimal Rp10 miliar", "Tidak melakukan tindakan yang merugikan bank (kredit macet)", "Tingkat bunga simpanan tidak melebihi tingkat bunga penjaminan LPS", "Menjaga kepatuhan aturan perbankan"),
            jawabanBenar = 1,
            pembahasan = "LPS tidak mensyaratkan status nasabah prioritas; tabungan kecil masyarakat dijamin penuh asalkan memenuhi syarat 3T."
        ),
        Soal(
            id = 508, babId = 5, nomorSoal = 8,
            pertanyaan = "Bukti kepemilikan modal sebagian pada suatu perseroan terbatas (PT) yang diperdagangkan di Bursa Efek Indonesia dinamakan...",
            opsi = listOf("Obligasi", "Bilyet Deposito", "Saham", "Surat Berharga Syariah", "Polis Asuransi"),
            jawabanBenar = 2,
            pembahasan = "Saham adalah tanda penyertaan modal seseorang atau badan usaha pada suatu perseroan terbatas."
        ),
        Soal(
            id = 509, babId = 5, nomorSoal = 9,
            pertanyaan = "Bagian keuntungan perusahaan yang dibagikan kepada para pemegang saham secara periodik disebut...",
            opsi = listOf("Capital Gain", "Ujrah", "Kupon Bunga", "Dividen", "Premi"),
            jawabanBenar = 3,
            pembahasan = "Dividen adalah bagian laba bersih perseroan yang diputuskan dalam Rapat Umum Pemegang Saham (RUPS) untuk dibagikan ke investor."
        ),
        Soal(
            id = 510, babId = 5, nomorSoal = 10,
            pertanyaan = "Seorang investor membeli saham pada harga Rp3.000 per lembar dan menjualnya setahun kemudian seharga Rp3.800 per lembar. Keuntungan Rp800 per lembar tersebut disebut...",
            opsi = listOf("Dividen tunai", "Capital Loss", "Bunga anuitas", "Kupon diskonto", "Capital Gain"),
            jawabanBenar = 4,
            pembahasan = "Capital gain adalah selisih keuntungan positif antara harga jual yang lebih tinggi dibandingkan harga beli suatu aset efek."
        ),
        Soal(
            id = 511, babId = 5, nomorSoal = 11,
            pertanyaan = "Surat utang jangka menengah maupun panjang yang diterbitkan oleh korporasi atau negara dengan janji pembayaran bunga berkala disebut...",
            opsi = listOf("Obligasi", "Saham preferen", "Waran", "Right issue", "Cek kliring"),
            jawabanBenar = 0,
            pembahasan = "Obligasi adalah surat pengakuan utang dari penerbit kepada pemegang obligasi disertai pembayaran kupon bunga periodik."
        ),
        Soal(
            id = 512, babId = 5, nomorSoal = 12,
            pertanyaan = "Efek syariah berupa sertifikat kepemilikan bersama atas suatu aset dasar riil (underlying asset) tanpa unsur riba dinamakan...",
            opsi = listOf("Saham derivatif", "Sukuk", "Obligasi konversi", "Option", "Forex futures"),
            jawabanBenar = 1,
            pembahasan = "Sukuk (obligasi syariah) adalah sertifikat kepemilikan bernilai sama atas aset nyata yang disewakan atau dikelola secara syariah."
        ),
        Soal(
            id = 513, babId = 5, nomorSoal = 13,
            pertanyaan = "Wadah yang digunakan untuk menghimpun dana dari masyarakat pemodal untuk selanjutnya diinvestasikan dalam portofolio efek oleh Manajer Investasi disebut...",
            opsi = listOf("Pegadaian", "Bank Perkreditan Rakyat", "Reksa Dana", "Pasar Valuta Asing", "Fintech Lending"),
            jawabanBenar = 2,
            pembahasan = "Reksa dana mengumpulkan modal kolektif dari investor pemula/ritel yang dikelola secara profesional oleh Manajer Investasi berizin OJK."
        ),
        Soal(
            id = 514, babId = 5, nomorSoal = 14,
            pertanyaan = "Pihak berlisensi OJK yang bertanggung jawab mengelola portofolio investasi pada produk reksa dana adalah...",
            opsi = listOf("Pialang asuransi", "Wali amanat bank", "Notaris pasar modal", "Manajer Investasi", "Auditor pajak"),
            jawabanBenar = 3,
            pembahasan = "Manajer Investasi mengelola penempatan alokasi dana reksa dana ke saham, obligasi, atau pasar uang."
        ),
        Soal(
            id = 515, babId = 5, nomorSoal = 15,
            pertanyaan = "Lembaga keuangan yang memberikan fasilitas pinjaman uang dengan kewajiban nasabah menyerahkan jaminan barang bergerak disebut...",
            opsi = listOf("Perusahaan Asuransi", "Leasing Alat Berat", "Dana Pensiun", "Bursa Berjangka Komoditi", "Pegadaian"),
            jawabanBenar = 4,
            pembahasan = "Pegadaian menyalurkan pembiayaan berdasar hukum gadai dengan agunan barang bergerak seperti emas, gawai, atau kendaraan."
        ),
        Soal(
            id = 516, babId = 5, nomorSoal = 16,
            pertanyaan = "Dalam perjanjian asuransi, sejumlah uang yang wajib dibayarkan secara rutin oleh pemegang polis kepada perusahaan asuransi disebut...",
            opsi = listOf("Premi", "Uang pertanggungan", "Klaim santunan", "Dividen polis", "Biaya emisi"),
            jawabanBenar = 0,
            pembahasan = "Premi adalah iuran berkala yang disetor nasabah tertanggung sebagai imbalan atas pengalihan risiko finansial kepada penanggung."
        ),
        Soal(
            id = 517, babId = 5, nomorSoal = 17,
            pertanyaan = "Lembaga Keuangan Bukan Bank (LKNB) yang menghimpun dana dari iuran pekerja dan pemberi kerja untuk dipersiapkan bagi masa purnabakti adalah...",
            opsi = listOf("Pegadaian", "Dana Pensiun", "Perusahaan Modal Ventura", "Koperasi Simpan Pinjam", "Perusahaan Efek"),
            jawabanBenar = 1,
            pembahasan = "Lembaga Dana Pensiun mengelola dana tabungan hari tua untuk memberikan kesinambungan penghasilan setelah pensiun."
        ),
        Soal(
            id = 518, babId = 5, nomorSoal = 18,
            pertanyaan = "Perusahaan sewa guna usaha (Leasing) biasanya membantu pengusaha UMKM dalam hal...",
            opsi = listOf("Mencetak sertifikat deposito", "Menjamin tabungan nasabah di bank", "Pengadaan barang modal mesin atau armada operasional secara angsuran berkala", "Mengaudit pembukuan pajak tahunan", "Menjual saham di bursa efek"),
            jawabanBenar = 2,
            pembahasan = "Leasing (sewa guna usaha) mendanai pengadaan barang modal atau armada kendaraan yang pembayarannya dicicil berkala."
        ),
        Soal(
            id = 519, babId = 5, nomorSoal = 19,
            pertanyaan = "Dalam mekanisme gadai, jika peminjam tidak mampu melunasi pinjaman hingga batas waktu jatuh tempo dan perpanjangan terlampaui, langkah yang ditempuh Pegadaian adalah...",
            opsi = listOf("Memenjarakan nasabah", "Menyita seluruh rumah debitur", "Menghapus utang tanpa tindak lanjut", "Melakukan lelang resmi atas barang jaminan untuk menutup sisa pinjaman", "Mengalihkan utang ke anggota keluarga"),
            jawabanBenar = 3,
            pembahasan = "Barang jaminan gadai akan dilelang secara transparan; kelebihan hasil lelang setelah dikurangi pokok dan biaya wajib dikembalikan ke nasabah."
        ),
        Soal(
            id = 520, babId = 5, nomorSoal = 20,
            pertanyaan = "Bank Perkreditan Rakyat (BPR) menurut undang-undang perbankan dilarang melakukan kegiatan...",
            opsi = listOf("Menerima tabungan masyarakat", "Memberikan pinjaman kepada pedagang kecil", "Menjalankan pembiayaan dengan prinsip bagi hasil", "Menerima deposito berjangka", "Menerima simpanan giro dan ikut serta dalam lalu lintas pembayaran kliring"),
            jawabanBenar = 4,
            pembahasan = "BPR tidak boleh melayani simpanan giro, kliring, dan transaksi valuta asing demi fokus pada pembiayaan mikro."
        ),
        Soal(
            id = 521, babId = 5, nomorSoal = 21,
            pertanyaan = "Prinsip asuransi yang menyatakan bahwa tertanggung wajib mengungkapkan fakta material secara jujur dan transparan tanpa menyembunyikan riwayat kesehatan adalah...",
            opsi = listOf("Utmost Good Faith (Itikad Baik Sempurna)", "Insurable Interest", "Indemnity", "Subrogation", "Proximate Cause"),
            jawabanBenar = 0,
            pembahasan = "Utmost good faith mewajibkan kedua pihak saling jujur dan terbuka mengenai segala fakta material objek asuransi."
        ),
        Soal(
            id = 522, babId = 5, nomorSoal = 22,
            pertanyaan = "Pasar primer (Pasar Perdana) dalam transaksi pasar modal adalah tempat di mana...",
            opsi = listOf("Saham diperjualbelikan antar investor di bursa efek", "Efek pertama kali ditawarkan dan dijual oleh emiten kepada publik (IPO)", "Investor menjual kembali obligasi negara", "Pialang saling menukar valuta asing", "Masyarakat menggadaikan emas"),
            jawabanBenar = 1,
            pembahasan = "Pasar perdana terjadi saat emiten pertama kali menjual efeknya kepada masyarakat pemodal sebelum dicatatkan di bursa efek."
        ),
        Soal(
            id = 523, babId = 5, nomorSoal = 23,
            pertanyaan = "Istilah IPO dalam dunia pasar modal merupakan singkatan dari...",
            opsi = listOf("Internal Payment Operation", "International Price Organization", "Initial Public Offering (Penawaran Umum Perdana)", "Interbank Processing Order", "Investment Profit Output"),
            jawabanBenar = 2,
            pembahasan = "Initial Public Offering (IPO) adalah penawaran umum perdana saham perusahaan kepada publik untuk menjadi perusahaan terbuka."
        ),
        Soal(
            id = 524, babId = 5, nomorSoal = 24,
            pertanyaan = "Layanan pembiayaan yang menyediakan modal awal bagi usaha rintisan (startup) yang berpotensi tumbuh pesat namun berisiko tinggi disebut...",
            opsi = listOf("Koperasi Konsumsi", "Pegadaian Syariah", "Bank Indonesia", "Modal Ventura (Venture Capital)", "Pasar Uang Antar Bank"),
            jawabanBenar = 3,
            pembahasan = "Perusahaan modal ventura berinvestasi berupa penyertaan modal langsung pada perusahaan rintisan inovatif."
        ),
        Soal(
            id = 525, babId = 5, nomorSoal = 25,
            pertanyaan = "Kanal resmi pengaduan konsumen jasa keuangan yang disediakan OJK melalui nomor sambungan telepon adalah...",
            opsi = listOf("110", "112", "123", "119", "157"),
            jawabanBenar = 4,
            pembahasan = "Kontak OJK 157 adalah saluran resmi aduan, konsultasi, dan verifikasi legalitas lembaga keuangan bagi masyarakat Indonesia."
        )
    )

    val soalBab6: List<Soal> = listOf(
        Soal(
            id = 601, babId = 6, nomorSoal = 1,
            pertanyaan = "Prinsip dasar dalam dunia investasi yang menyatakan bahwa semakin tinggi potensi keuntungan suatu aset, semakin tinggi pula risiko kerugiannya disebut...",
            opsi = listOf("Risk-Return Tradeoff", "Time Value of Money", "Law of One Price", "Purchasing Power Parity", "Capital Adequacy Ratio"),
            jawabanBenar = 0,
            pembahasan = "Risk-return tradeoff menegaskan bahwa potensi imbal hasil berbanding lurus dengan derajat risiko yang harus ditanggung investor."
        ),
        Soal(
            id = 602, babId = 6, nomorSoal = 2,
            pertanyaan = "Risiko yang dipicu oleh faktor makro eksternal seperti krisis ekonomi global, perang, atau kenaikan suku bunga acuan dan tidak dapat dihilangkan dengan diversifikasi disebut...",
            opsi = listOf("Risiko Non-Sistematis (Spesifik)", "Risiko Sistematis (Pasar)", "Risiko Operasional Internal", "Risiko Likuiditas Perusahaan", "Risiko Kredit Individu"),
            jawabanBenar = 1,
            pembahasan = "Risiko sistematis (systematic/market risk) melanda seluruh pasar secara serentak sehingga tidak bisa dihindari hanya dengan diversifikasi."
        ),
        Soal(
            id = 603, babId = 6, nomorSoal = 3,
            pertanyaan = "Risiko non-sistematis atau risiko spesifik (misalnya kasus kebakaran pabrik milik emiten tertentu) dapat diminimalisir investor dengan cara...",
            opsi = listOf("Menaruh seluruh modal pada satu saham emiten tersebut", "Meminjam dana dari pinjol ilegal", "Melakukan diversifikasi portofolio ke beberapa sektor industri yang berbeda", "Menarik seluruh dana tunai dari bank", "Menolak membayar asuransi pabrik"),
            jawabanBenar = 2,
            pembahasan = "Diversifikasi aset (menyebar modal ke beragam instrumen/sektor) efektif meredam risiko kerugian akibat masalah satu perusahaan spesifik."
        ),
        Soal(
            id = 604, babId = 6, nomorSoal = 4,
            pertanyaan = "Ciri paling mencolok dari tawaran investasi bodong yang menerapkan skema Ponzi adalah...",
            opsi = listOf("Memiliki izin terdaftar resmi di situs ojk.go.id", "Membebankan pajak penghasilan sesuai ketentuan negara", "Menjelaskan portofolio bisnis dan prospektus secara transparan", "Menjanjikan keuntungan sangat besar, pasti, dan tanpa risiko sama sekali", "Diawasi oleh Dewan Syariah Nasional"),
            jawabanBenar = 3,
            pembahasan = "Klaim keuntungan fantastis, pasti cair, dan bebas risiko (zero risk) adalah indikasi klasik penipuan investasi skema Ponzi."
        ),
        Soal(
            id = 605, babId = 6, nomorSoal = 5,
            pertanyaan = "Dalam skema Ponzi, pembayaran keuntungan kepada investor lama sesungguhnya berasal dari...",
            opsi = listOf("Laba riil dari penjualan komoditas ekspor", "Subsidi pemerintah", "Bunga obligasi negara", "Hasil dividen bursa saham", "Uang setoran modal dari investor baru yang direkrut"),
            jawabanBenar = 4,
            pembahasan = "Skema Ponzi tidak memiliki model bisnis riil; keuntungan fiktif investor terdahulu dibayarkan murni dari aliran setoran peserta baru."
        ),
        Soal(
            id = 606, babId = 6, nomorSoal = 6,
            pertanyaan = "Fintech lending legal yang berizin resmi OJK hanya diizinkan mengakses tiga fitur pada gawai ponsel pengguna yang dikenal dengan singkatan CAMILAN, yaitu...",
            opsi = listOf("Camera, Microphone, dan Location", "Contact, Message, dan Instagram", "Camera, Media, dan Call History", "Card, Memory, dan Location", "Contact, Audio, dan Media"),
            jawabanBenar = 0,
            pembahasan = "OJK menetapkan batas ketat izin akses aplikasi fintech lending hanya untuk CAMILAN (Camera, Microphone, Location)."
        ),
        Soal(
            id = 607, babId = 6, nomorSoal = 7,
            pertanyaan = "Ciri khas penagihan dari aplikasi pinjaman online (pinjol) ilegal yang sangat meresahkan masyarakat adalah...",
            opsi = listOf("Mengirim surat peringatan resmi sesuai etika profesi", "Melakukan teror psikologis, ancaman sebar data pribadi, dan menelpon seluruh nomor kontak di HP peminjam", "Memberikan keringanan perpanjangan jatuh tempo secara kekeluargaan", "Membatasi bunga maksimal sesuai regulasi asosiasi", "Melibatkan mediasi OJK"),
            jawabanBenar = 1,
            pembahasan = "Pinjol ilegal menyadap seluruh daftar kontak ponsel korban dan melancarkan intimidasi, teror, serta pencemaran nama baik saat menagih."
        ),
        Soal(
            id = 608, babId = 6, nomorSoal = 8,
            pertanyaan = "Satuan tugas lintas kementerian dan lembaga yang bertugas memberantas pinjol ilegal dan investasi bodong di Indonesia dinamakan...",
            opsi = listOf("Satgas COVID-19", "Satgas Antimafia Bola", "Satgas PASTI (Pemberantasan Aktivitas Keuangan Ilegal)", "Komite Stabilitas Sistem Keuangan", "Badan Arbitrase Nasional"),
            jawabanBenar = 2,
            pembahasan = "Satgas PASTI (dahulu Satgas Waspada Investasi) merupakan forum koordinasi 16 kementerian/lembaga untuk menindak kejahatan keuangan ilegal."
        ),
        Soal(
            id = 609, babId = 6, nomorSoal = 9,
            pertanyaan = "Metode perencanaan keuangan pribadi yang membagi pendapatan bersih menjadi 50 persen kebutuhan pokok, 30 persen keinginan, dan 20 persen tabungan/investasi dipopulerkan dengan nama aturan...",
            opsi = listOf("Aturan 70/20/10", "Aturan 80/20", "Aturan 40/30/20/10", "Aturan 50/30/20", "Aturan 60/40"),
            jawabanBenar = 3,
            pembahasan = "Aturan 50/30/20 mengalokasikan 50% untuk kebutuhan pokok (needs), 30% untuk keinginan (wants), dan 20% untuk tabungan/investasi (savings)."
        ),
        Soal(
            id = 610, babId = 6, nomorSoal = 10,
            pertanyaan = "Seorang siswa SMA memiliki uang saku bulanan Rp300.000. Berdasarkan prinsip aturan 50/30/20, porsi yang idealnya disisihkan untuk tabungan dan investasi adalah...",
            opsi = listOf("Rp30.000", "Rp200.000", "Rp90.000", "Rp150.000", "Rp60.000"),
            jawabanBenar = 4,
            pembahasan = "Porsi tabungan 20% dari Rp300.000 adalah 0,20 x 300.000 = Rp60.000."
        ),
        Soal(
            id = 611, babId = 6, nomorSoal = 11,
            pertanyaan = "Rumus dasar untuk menghitung nilai Kekayaan Bersih (Net Worth) seseorang dalam neraca keuangan pribadi adalah...",
            opsi = listOf("Total Aset dikurangi Total Kewajiban (Utang)", "Total Pendapatan kotor dikurangi Pajak", "Total Pengeluaran dikurangi Total Tabungan", "Jumlah Uang Tunai dikali Suku Bunga", "Biaya Hidup dibagi Jumlah Tanggungan"),
            jawabanBenar = 0,
            pembahasan = "Kekayaan Bersih (Net Worth) dihitung dari Total Aset (harta kepemilikan) dikurangi Total Kewajiban (seluruh utang)."
        ),
        Soal(
            id = 612, babId = 6, nomorSoal = 12,
            pertanyaan = "Berikut ini yang dikelompokkan sebagai Aset Lancar (likuid) dalam neraca keuangan pribadi adalah...",
            opsi = listOf("Sertifikat tanah perkebunan keluarga", "Uang tunai di dompet dan saldo tabungan rekening bank", "Sepeda motor yang dipakai sehari-hari", "Perhiasan emas pusaka yang tidak dijual", "Gedung ruko sewaan"),
            jawabanBenar = 1,
            pembahasan = "Aset lancar/likuid adalah aset kas atau setara kas yang dapat segera digunakan untuk transaksi tanpa penurunan nilai."
        ),
        Soal(
            id = 613, babId = 6, nomorSoal = 13,
            pertanyaan = "Dana cadangan likuid yang wajib dipersiapkan untuk mengantisipasi kejadian mendadak seperti sakit, kecelakaan, atau kehilangan pendapatan disebut...",
            opsi = listOf("Uang jajan", "Dana Liburan", "Dana Darurat (Emergency Fund)", "Kredit Konsumtif", "Uang Muka Rumah"),
            jawabanBenar = 2,
            pembahasan = "Dana darurat berfungsi sebagai bantalan pengaman finansial saat menghadapi kondisi darurat tak terduga."
        ),
        Soal(
            id = 614, babId = 6, nomorSoal = 14,
            pertanyaan = "Bagi seseorang yang belum menikah dan belum memiliki tanggungan, besaran ideal dana darurat yang disarankan para perencana keuangan adalah setara...",
            opsi = listOf("1 kali pengeluaran bulanan", "Nol rupiah", "12 sampai 24 kali pengeluaran bulanan", "3 sampai 6 kali pengeluaran bulanan", "Seluruh gaji tahunan"),
            jawabanBenar = 3,
            pembahasan = "Untuk individu lajang, cadangan 3 hingga 6 bulan pengeluaran rutin dinilai cukup memadai untuk menjaga ketahanan finansial."
        ),
        Soal(
            id = 615, babId = 6, nomorSoal = 15,
            pertanyaan = "Batas maksimal rasio cicilan utang bulanan (Debt Service Ratio) yang tergolong sehat terhadap total penghasilan bersih adalah tidak melebihi...",
            opsi = listOf("10 persen", "100 persen", "60 persen", "80 persen", "30 persen"),
            jawabanBenar = 4,
            pembahasan = "Rasio cicilan utang yang aman adalah maksimal 30% dari penghasilan agar tidak mengganggu pemenuhan kebutuhan pokok."
        ),
        Soal(
            id = 616, babId = 6, nomorSoal = 16,
            pertanyaan = "Fondasi paling dasar dalam piramida perencanaan keuangan sehat sebelum seseorang mulai berinvestasi saham agresif adalah...",
            opsi = listOf("Arus kas positif dan ketersediaan dana darurat yang mencukupi", "Membeli mobil sport mewah", "Berpartisipasi dalam lelang karya seni", "Membeli kripto spekulatif", "Membuat surat warisan"),
            jawabanBenar = 0,
            pembahasan = "Fondasi piramida keuangan adalah keamanan finansial berupa arus kas yang sehat (pendapatan > pengeluaran) dan dana darurat."
        ),
        Soal(
            id = 617, babId = 6, nomorSoal = 17,
            pertanyaan = "Manakah dari perilaku berikut ini yang mencerminkan sikap literasi keuangan yang bijak pada seorang pelajar SMA...",
            opsi = listOf("Membeli gawai mahal demi mengikuti tren teman dengan berutang", "Mencatat arus kas masuk dan keluar secara disiplin setiap pekan", "Menaruh uang jajan pada situs judi online dengan harapan untung cepat", "Meminjam identitas KTP orang tua untuk mendaftar pinjol ilegal", "Menghabiskan seluruh uang beasiswa dalam sehari"),
            jawabanBenar = 1,
            pembahasan = "Disiplin mencatat pemasukan dan pengeluaran adalah wujud nyata literasi keuangan dasar bagi pelajar."
        ),
        Soal(
            id = 618, babId = 6, nomorSoal = 18,
            pertanyaan = "Dalam neraca keuangan pribadi, cicilan sepeda motor yang harus dibayar setiap bulan dicatat pada sisi...",
            opsi = listOf("Aset Tetap", "Modal Hibah", "Kewajiban (Liabilitas / Utang)", "Pendapatan Pasif", "Penerimaan Negara"),
            jawabanBenar = 2,
            pembahasan = "Kewajiban cicilan kredit merupakan utang yang wajib dilunasi, sehingga dicatat pada kolom liabilitas."
        ),
        Soal(
            id = 619, babId = 6, nomorSoal = 19,
            pertanyaan = "Arus kas bersih (Net Cash Flow) bernilai defisit jika kondisi yang dialami seseorang adalah...",
            opsi = listOf("Jumlah tabungan bertambah dua kali lipat", "Total pemasukan lebih besar daripada total pengeluaran", "Total pemasukan sama persis dengan total pengeluaran", "Total pengeluaran lebih besar daripada total pemasukan", "Seluruh utang telah lunas"),
            jawabanBenar = 3,
            pembahasan = "Defisit arus kas terjadi ketika uang yang dibelanjakan melebihi penerimaan yang didapatkan."
        ),
        Soal(
            id = 620, babId = 6, nomorSoal = 20,
            pertanyaan = "Kejahatan rekayasa sosial (social engineering) di mana pelaku menyamar sebagai pihak bank untuk mencuri data OTP atau PIN nasabah disebut...",
            opsi = listOf("Arbitrage", "Diversifikasi", "Hedging", "Underwriting", "Phishing / Smishing"),
            jawabanBenar = 4,
            pembahasan = "Phishing/smishing adalah teknik penipuan siber untuk memancing korban memberikan kata sandi, PIN, atau OTP rahasia."
        ),
        Soal(
            id = 621, babId = 6, nomorSoal = 21,
            pertanyaan = "Tindakan pengamanan data pribadi yang benar agar akun perbankan digital tidak mudah diretas adalah...",
            opsi = listOf("Membuat kata sandi yang kuat dan tidak pernah membagikan kode OTP atau PIN kepada pihak manapun", "Membagikan kode OTP kepada siapa saja yang mengaku petugas bank", "Menuliskan PIN kartu ATM di balik kartu ATM", "Menggunakan jaringan Wi-Fi publik tanpa enkripsi saat transfer", "Menyimpan foto kartu identitas di media sosial"),
            jawabanBenar = 0,
            pembahasan = "Kode OTP dan PIN bersifat rahasia mutlak pribadi dan tidak boleh dibagikan kepada siapapun, termasuk oknum yang mengaku pegawai bank."
        ),
        Soal(
            id = 622, babId = 6, nomorSoal = 22,
            pertanyaan = "Dalam piramida perencanaan keuangan, fungsi kepemilikan asuransi kesehatan (seperti BPJS Kesehatan) berada pada tingkatan...",
            opsi = listOf("Fondasi keamanan likuiditas", "Proteksi risiko (Risk Management)", "Akumulasi aset investasi", "Distribusi warisan", "Spekulasi pasar"),
            jawabanBenar = 1,
            pembahasan = "Asuransi bertindak sebagai proteksi risiko agar tabungan tidak habis terkuras saat jatuh sakit atau mengalami musibah."
        ),
        Soal(
            id = 623, babId = 6, nomorSoal = 23,
            pertanyaan = "Siti memiliki uang tunai Rp500.000, tabungan bank Rp1.500.000, laptop senilai Rp4.000.000, dan utang kepada teman sebesar Rp200.000. Nilai kekayaan bersih Siti adalah...",
            opsi = listOf("Rp6.200.000", "Rp6.000.000", "Rp5.800.000", "Rp4.000.000", "Rp2.000.000"),
            jawabanBenar = 2,
            pembahasan = "Total Aset = 500.000 + 1.500.000 + 4.000.000 = Rp6.000.000. Total Utang = Rp200.000. Kekayaan Bersih = 6.000.000 - 200.000 = Rp5.800.000."
        ),
        Soal(
            id = 624, babId = 6, nomorSoal = 24,
            pertanyaan = "Menabung di awal saat menerima uang saku (Pay Yourself First) lebih efektif dibandingkan menabung di akhir bulan karena...",
            opsi = listOf("Uang tabungan akan berkurang nilainya", "Menabung di awal tidak dikenakan pajak", "Bank melarang menabung di akhir bulan", "Memastikan alokasi tabungan sudah tersisihkan sebelum uang habis terpakai untuk keinginan sesaat", "Uang saku pasti akan bertambah"),
            jawabanBenar = 3,
            pembahasan = "Prinsip Pay Yourself First menjamin porsi tabungan aman di awal sehingga terhindar dari pemborosan sisa belanja."
        ),
        Soal(
            id = 625, babId = 6, nomorSoal = 25,
            pertanyaan = "Jika seorang teman mengajak bergabung ke dalam bisnis titip dana dengan janji imbal hasil 30 persen per minggu tanpa risiko, sikap bijak yang tepat adalah...",
            opsi = listOf("Langsung menyetorkan seluruh uang saku", "Mengajak seluruh anggota keluarga ikut berinvestasi", "Menunggu hingga teman tersebut kaya baru ikut", "Meminjam dana ke pinjol untuk ikut modal", "Menolak dengan tegas karena tidak logis dan berpotensi kuat sebagai skema penipuan"),
            jawabanBenar = 4,
            pembahasan = "Berdasarkan prinsip 2L OJK, janji keuntungan 30% per minggu tanpa risiko adalah tidak logis dan merupakan tanda nyata penipuan."
        )
    )
}
