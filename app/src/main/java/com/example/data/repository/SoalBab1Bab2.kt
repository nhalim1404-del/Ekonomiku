package com.example.data.repository

import com.example.data.model.Soal

object SoalBab1Bab2 {

    val soalBab1: List<Soal> = listOf(
        Soal(
            id = 101, babId = 1, nomorSoal = 1,
            pertanyaan = "Secara etimologi, kata ekonomi berasal dari bahasa Yunani oikonomia, yang terbentuk dari kata oikos dan nomos. Arti kata oikos adalah...",
            opsi = listOf("Rumah tangga atau keluarga", "Pasar atau tempat berniaga", "Aturan atau hukum", "Pemerintah atau negara", "Masyarakat atau komunitas"),
            jawabanBenar = 0,
            pembahasan = "Oikos berarti rumah tangga atau keluarga, sedangkan nomos berarti tata aturan atau kaidah hukum pengelolaan."
        ),
        Soal(
            id = 102, babId = 1, nomorSoal = 2,
            pertanyaan = "Buku monumental The Wealth of Nations karya Adam Smith terbit pada tahun 1776 dan memperkenalkan konsep kekuatan tak terlihat yang disebut...",
            opsi = listOf("The Iron Cage", "The Invisible Hand", "The Golden Rule", "The Comparative Advantage", "The Marginal Principle"),
            jawabanBenar = 1,
            pembahasan = "The Invisible Hand adalah konsep tangan tak terlihat yang mengarahkan kepentingan pribadi individu menuju kemakmuran masyarakat melalui mekanisme pasar."
        ),
        Soal(
            id = 103, babId = 1, nomorSoal = 3,
            pertanyaan = "Inti masalah ekonomi yang mendasari munculnya seluruh aktivitas ekonomi manusia adalah...",
            opsi = listOf("Jumlah uang beredar yang terus berkurang", "Teknologi produksi yang terlampau lambat berkembang", "Kebutuhan manusia tidak terbatas sementara alat pemuasnya terbatas", "Kenaikan harga barang pokok akibat inflasi", "Kelebihan pasokan barang konsumsi di pasar"),
            jawabanBenar = 2,
            pembahasan = "Kelangkaan (scarcity) terjadi karena kesenjangan mutlak antara kebutuhan manusia yang tanpa batas dan sumber daya pemuas yang terbatas."
        ),
        Soal(
            id = 104, babId = 1, nomorSoal = 4,
            pertanyaan = "Berdasarkan intensitas pemenuhannya, kebutuhan manusia diklasifikasikan menjadi tiga tingkatan yaitu...",
            opsi = listOf("Jasmani, rohani, dan sosial", "Individu, kelompok, dan publik", "Sekarang, masa depan, dan mendesak", "Primer, sekunder, dan tersier", "Lokal, regional, dan internasional"),
            jawabanBenar = 3,
            pembahasan = "Intensitas urgensi mengelompokkan kebutuhan menjadi kebutuhan primer (pokok), sekunder (pelengkap), dan tersier (kemewahan)."
        ),
        Soal(
            id = 105, babId = 1, nomorSoal = 5,
            pertanyaan = "Tingkatan tertinggi dalam hierarki piramida kebutuhan Abraham Maslow adalah...",
            opsi = listOf("Kebutuhan fisiologis", "Kebutuhan rasa aman", "Kebutuhan sosial dan kasih sayang", "Kebutuhan penghargaan status", "Kebutuhan aktualisasi diri"),
            jawabanBenar = 4,
            pembahasan = "Aktualisasi diri berada di puncak piramida Maslow, yaitu dorongan untuk mewujudkan segenap bakat dan potensi tertinggi manusia."
        ),
        Soal(
            id = 106, babId = 1, nomorSoal = 6,
            pertanyaan = "Berikut ini yang merupakan contoh pemenuhan kebutuhan yang didasarkan pada waktu sekarang adalah...",
            opsi = listOf("Minum obat resep dokter saat terserang flu", "Membeli polis asuransi jiwa jangka panjang", "Menabung di bank untuk biaya kuliah anak", "Membeli lahan perkebunan untuk hari tua", "Mengikuti program dana pensiun hari tua"),
            jawabanBenar = 0,
            pembahasan = "Kebutuhan sekarang sifatnya mendesak dan tidak dapat ditunda, contohnya minum obat ketika mendadak sakit."
        ),
        Soal(
            id = 107, babId = 1, nomorSoal = 7,
            pertanyaan = "Masalah pokok ekonomi modern berfokus pada tiga pertanyaan mendasar yaitu...",
            opsi = listOf("Kapan, di mana, dan oleh siapa", "What, How, dan For Whom", "Berapa modal, keuntungan, dan labanya", "Produksi, distribusi, dan konsumsi", "Legal, logis, dan syariah"),
            jawabanBenar = 1,
            pembahasan = "Tiga masalah pokok ekonomi modern adalah barang apa yang diproduksi (What), bagaimana cara memproduksinya (How), dan untuk siapa barang diproduksi (For Whom)."
        ),
        Soal(
            id = 108, babId = 1, nomorSoal = 8,
            pertanyaan = "Produsen keripik di Pangkep memutuskan memakai mesin perajang otomatis bertenaga listrik agar biaya lebih hemat. Hal ini menjawab masalah modern...",
            opsi = listOf("What", "For Whom", "How", "When", "Where"),
            jawabanBenar = 2,
            pembahasan = "How berkaitan dengan teknik, teknologi, dan metode pengorganisasian produksi yang paling efisien."
        ),
        Soal(
            id = 109, babId = 1, nomorSoal = 9,
            pertanyaan = "Ahmad lulus dari SMAN 1 Pangkep dan memiliki tiga pilihan: bekerja di pabrik semen dengan gaji Rp3.500.000, menjadi staf toko bergaji Rp2.800.000, atau kuliah. Jika ia memilih kuliah, biaya peluang Ahmad adalah...",
            opsi = listOf("Rp2.800.000", "Rp700.000", "Rp6.300.000", "Rp3.500.000", "Nol rupiah"),
            jawabanBenar = 3,
            pembahasan = "Biaya peluang adalah nilai dari alternatif terbaik yang dikorbankan. Alternatif terbaik yang ditinggalkan Ahmad adalah gaji terbesar yaitu Rp3.500.000."
        ),
        Soal(
            id = 110, babId = 1, nomorSoal = 10,
            pertanyaan = "Kurva batas kemungkinan produksi (Production Possibility Frontier atau PPF) yang berbentuk cembung ke arah luar (concave) mencerminkan...",
            opsi = listOf("Tidak adanya biaya peluang dalam perekonomian", "Kondisi di mana produsen selalu merugi", "Kelangkaan sumber daya yang telah lenyap", "Adanya pengangguran sumber daya yang permanen", "Biaya peluang yang semakin meningkat (increasing opportunity cost)"),
            jawabanBenar = 4,
            pembahasan = "Bentuk kurva PPF yang concave mencerminkan hukum kenaikan biaya peluang saat sumber daya dialihkan memproduksi barang lain."
        ),
        Soal(
            id = 111, babId = 1, nomorSoal = 11,
            pertanyaan = "Titik yang berada di dalam kurva batas kemungkinan produksi (PPF) mengindikasikan bahwa perekonomian berada pada kondisi...",
            opsi = listOf("Sumber daya belum dimanfaatkan secara optimal (tidak efisien)", "Tercapai efisiensi alokasi sumber daya maksimum", "Target produksi yang mustahil dicapai", "Keseimbangan pasar sempurna", "Ketiadaan campur tangan pemerintah"),
            jawabanBenar = 0,
            pembahasan = "Titik di dalam kurva PPF menunjukkan inefisiensi atau adanya faktor produksi yang menganggur (idle resources)."
        ),
        Soal(
            id = 112, babId = 1, nomorSoal = 12,
            pertanyaan = "Cabang ilmu ekonomi yang bertugas mengumpulkan fakta empiris dan angka-angka nyata tentang fenomena perekonomian adalah...",
            opsi = listOf("Ekonomi terapan", "Ekonomi deskriptif", "Ekonomi normatif", "Ekonomi makro", "Ekonomi moneter"),
            jawabanBenar = 1,
            pembahasan = "Ekonomi deskriptif memaparkan gambaran faktual dan data nyata suatu keadaan ekonomi, seperti laporan inflasi BPS."
        ),
        Soal(
            id = 113, babId = 1, nomorSoal = 13,
            pertanyaan = "Perbedaan mendasar antara fokus kajian ekonomi mikro dan ekonomi makro terletak pada...",
            opsi = listOf("Mikro mengkaji agregat nasional, makro mengkaji pasar individu", "Mikro mempelajari kebijakan APBN, makro mempelajari biaya produksi", "Mikro mengkaji unit ekonomi tunggal, makro mengkaji perekonomian secara keseluruhan", "Mikro dipelajari negara maju, makro dipelajari negara berkembang", "Mikro tidak menggunakan kurva, makro wajib menggunakan kurva"),
            jawabanBenar = 2,
            pembahasan = "Ekonomi mikro fokus pada unit kecil (perilaku konsumen, harga produk tertentu), sedangkan makro fokus pada variabel agregat nasional (PDB, inflasi)."
        ),
        Soal(
            id = 114, babId = 1, nomorSoal = 14,
            pertanyaan = "Berikut ini yang merupakan variabel utama kajian ekonomi makro adalah...",
            opsi = listOf("Tingkat laba usaha warung bandeng di Pangkep", "Harga eceran satu kilogram cabai merah", "Biaya marjinal percetakan buku tulis", "Tingkat pengangguran dan inflasi nasional", "Upah minimum satu orang pelayan toko"),
            jawabanBenar = 3,
            pembahasan = "Tingkat pengangguran nasional, laju inflasi, dan produk domestik bruto adalah kajian utama ekonomi makro."
        ),
        Soal(
            id = 115, babId = 1, nomorSoal = 15,
            pertanyaan = "Prinsip ekonomi syariah melarang keras transaksi yang mengandung unsur riba. Yang dimaksud dengan riba adalah...",
            opsi = listOf("Bagi hasil atas keuntungan bisnis yang transparan", "Penyertaan modal saham syariah", "Pengurangan timbangan barang dagangan di pasar", "Biaya sewa toko yang dibayar di muka", "Penetapan tambahan pembayaran utang tanpa kompensasi pengganti yang sah"),
            jawabanBenar = 4,
            pembahasan = "Riba adalah tambahan nominal yang disyaratkan secara sepihak atas pokok pinjaman tanpa imbalan sah menurut syariat."
        ),
        Soal(
            id = 116, babId = 1, nomorSoal = 16,
            pertanyaan = "Transaksi jual beli ikan di mana jenis, mutu, dan jumlah barang tidak pasti atau sengaja disamarkan bertentangan dengan prinsip syariah karena mengandung...",
            opsi = listOf("Gharar", "Riba fadhl", "Mudharabah", "Ijarah", "Wakaf"),
            jawabanBenar = 0,
            pembahasan = "Gharar adalah ketidakjelasan atau spekulasi merugikan mengenai barang, harga, maupun waktu penyerahan transaksi."
        ),
        Soal(
            id = 117, babId = 1, nomorSoal = 17,
            pertanyaan = "Praktik perjudian atau bertaruh tebak angka skor sepak bola dengan imbalan uang melanggar syariat Islam karena termasuk kategori...",
            opsi = listOf("Gharar", "Maisir", "Murabahah", "Qardh", "Zakat"),
            jawabanBenar = 1,
            pembahasan = "Maisir adalah perjudian atau permainan untung-untungan yang memindahkan harta tanpa ada aktivitas produktif nyata."
        ),
        Soal(
            id = 118, babId = 1, nomorSoal = 18,
            pertanyaan = "Akad kerja sama bisnis syariah di mana pemilik modal menyetor 100 persen dana dan pengelola mengoperasikan usaha dengan pembagian laba disepakati disebut...",
            opsi = listOf("Murabahah", "Ijarah", "Mudharabah", "Wadiah", "Rahn"),
            jawabanBenar = 2,
            pembahasan = "Mudharabah adalah kemitraan antara pemilik modal (shahibul mal) dan pengelola usaha (mudharib) dengan nisbah bagi hasil yang disepakati."
        ),
        Soal(
            id = 119, babId = 1, nomorSoal = 19,
            pertanyaan = "Bank syariah membeli sepeda motor seharga Rp20.000.000 kemudian menjualnya kepada nasabah dengan harga Rp22.000.000 secara angsuran. Akad ini adalah...",
            opsi = listOf("Ijarah", "Istishna", "Musyarakah", "Murabahah", "Salam"),
            jawabanBenar = 3,
            pembahasan = "Murabahah adalah akad jual beli dengan memberitahukan harga perolehan dan margin keuntungan yang disepakati bersama."
        ),
        Soal(
            id = 120, babId = 1, nomorSoal = 20,
            pertanyaan = "Instrumen filantropi Islam yang menahan hak milik atas suatu harta benda produktif untuk diserahkan manfaatnya bagi kepentingan umum secara abadi adalah...",
            opsi = listOf("Gharim", "Zakat fitrah", "Fidyah", "Infak sesaat", "Wakaf"),
            jawabanBenar = 4,
            pembahasan = "Wakaf adalah menahan aset pokok yang tidak habis pakai untuk dimanfaatkan hasilnya demi kepentingan kemaslahatan umat."
        ),
        Soal(
            id = 121, babId = 1, nomorSoal = 21,
            pertanyaan = "Urutan prioritas kebutuhan manusia yang paling tepat disusun oleh seorang pelajar SMA adalah...",
            opsi = listOf("Buku teks pelajaran, makan siang, tiket bioskop", "Membeli sepatu bermerek, jajan kafe, buku pelajaran", "Paket liburan, pakaian seragam, gawai terbaru", "Tiket konser, tabungan, iuran sekolah", "Kamera digital, buku catatan, pulsa hiburan"),
            jawabanBenar = 0,
            pembahasan = "Buku teks dan makan siang merupakan kebutuhan primer penunjang belajar yang mendesak, sedangkan tiket bioskop adalah hiburan sekunder/tersier."
        ),
        Soal(
            id = 122, babId = 1, nomorSoal = 22,
            pertanyaan = "Benda yang jumlahnya sangat banyak sehingga untuk memperolehnya tidak memerlukan pengorbanan ekonomi disebut benda...",
            opsi = listOf("Ekonomi", "Bebas", "Substitusi", "Komplementer", "Ilith"),
            jawabanBenar = 1,
            pembahasan = "Benda bebas (seperti udara untuk bernapas dan sinar matahari) tersedia melimpah tanpa membutuhkan pengorbanan finansial."
        ),
        Soal(
            id = 123, babId = 1, nomorSoal = 23,
            pertanyaan = "Jas hujan dan payung saat musim hujan tiba memiliki kegunaan yang meningkat drastis. Hal ini mencerminkan kegunaan...",
            opsi = listOf("Bentuk (Form utility)", "Tempat (Place utility)", "Waktu (Time utility)", "Kepemilikan (Ownership utility)", "Pelayanan (Service utility)"),
            jawabanBenar = 2,
            pembahasan = "Time utility adalah peningkatan kegunaan suatu barang ketika dipakai pada waktu yang tepat, seperti payung saat hujan."
        ),
        Soal(
            id = 124, babId = 1, nomorSoal = 24,
            pertanyaan = "Beras dengan jagung, atau teh dengan kopi, dalam hubungannya sebagai alat pemuas kebutuhan manusia termasuk barang...",
            opsi = listOf("Komplementer", "Giffen", "Inferior", "Substitusi", "Prestige"),
            jawabanBenar = 3,
            pembahasan = "Barang substitusi adalah barang yang saling menggantikan fungsi pemenuhan kebutuhan satu sama lain."
        ),
        Soal(
            id = 125, babId = 1, nomorSoal = 25,
            pertanyaan = "Pernyataan ekonomi berikut ini yang tergolong pernyataan ekonomi normatif adalah...",
            opsi = listOf("Tingkat inflasi tahun ini sebesar 2,8 persen", "Produksi beras nasional mencapai 31 juta ton", "Jumlah pengangguran terbuka tercatat 5,2 juta jiwa", "Penerimaan pajak meningkat 10 persen dari tahun lalu", "Pemerintah seharusnya menaikkan alokasi anggaran beasiswa pendidikan"),
            jawabanBenar = 4,
            pembahasan = "Pernyataan normatif memuat pertimbangan nilai etika atau saran kebijakan yang diawali kata seharusnya (ought to be)."
        )
    )

    val soalBab2: List<Soal> = listOf(
        Soal(
            id = 201, babId = 2, nomorSoal = 1,
            pertanyaan = "Pemilik faktor produksi tenaga kerja akan memperoleh balas jasa dari produsen dalam bentuk...",
            opsi = listOf("Upah atau gaji (Wage)", "Sewa (Rent)", "Bunga modal (Interest)", "Laba usaha (Profit)", "Pajak dividen"),
            jawabanBenar = 0,
            pembahasan = "Tenaga kerja mencurahkan tenaga jasmani dan pikiran, sehingga berhak memperoleh balas jasa upah atau gaji (wage)."
        ),
        Soal(
            id = 202, babId = 2, nomorSoal = 2,
            pertanyaan = "Balas jasa yang diterima oleh pemilik faktor produksi modal berupa uang atau mesin adalah...",
            opsi = listOf("Rent", "Interest", "Wage", "Profit", "Subsidi"),
            jawabanBenar = 1,
            pembahasan = "Bunga modal (interest) merupakan kompensasi balas jasa atas pemakaian modal dalam proses produksi."
        ),
        Soal(
            id = 203, babId = 2, nomorSoal = 3,
            pertanyaan = "The Law of Diminishing Marginal Returns yang dikemukakan oleh David Ricardo menjelaskan bahwa...",
            opsi = listOf("Konsumen selalu merasa puas jika mengonsumsi barang terus-menerus", "Keseimbangan harga terbentuk saat kurva penawaran bergeser ke kiri", "Penambahan faktor variabel secara terus-menerus pada faktor tetap akan menurunkan tambahan hasil", "Semakin tinggi pendapatan, semakin kecil porsi konsumsi pangan", "Harga barang modal selalu stabil sepanjang masa"),
            jawabanBenar = 2,
            pembahasan = "Hukum tambahan hasil yang semakin menurun menyatakan pertambahan output marjinal akan menurun jika faktor variabel terus ditambah pada faktor tetap."
        ),
        Soal(
            id = 204, babId = 2, nomorSoal = 4,
            pertanyaan = "Sebuah UMKM bandeng memiliki biaya tetap Rp6.000.000. Biaya variabel per bungkus bandeng Rp20.000 dan harga jualnya Rp50.000. Jumlah unit bandeng yang harus dijual agar mencapai Break Even Point (BEP) adalah...",
            opsi = listOf("100 unit", "150 unit", "300 unit", "200 unit", "400 unit"),
            jawabanBenar = 3,
            pembahasan = "BEP = FC / (P - VC) = 6.000.000 / (50.000 - 20.000) = 6.000.000 / 30.000 = 200 unit."
        ),
        Soal(
            id = 205, babId = 2, nomorSoal = 5,
            pertanyaan = "Kondisi Break Even Point (BEP) mencerminkan posisi keuangan usaha di mana...",
            opsi = listOf("Total Penerimaan lebih besar dari Total Biaya", "Perusahaan membagikan dividen tertinggi", "Total Penerimaan lebih kecil dari Total Biaya", "Biaya Variabel bernilai nol", "Total Penerimaan sama persis dengan Total Biaya"),
            jawabanBenar = 4,
            pembahasan = "Titik impas BEP terjadi saat Total Revenue (TR) sama dengan Total Cost (TC), sehingga laba bersih adalah nol."
        ),
        Soal(
            id = 206, babId = 2, nomorSoal = 6,
            pertanyaan = "Penyaluran ikan bandeng dari nelayan langsung kepada pembeli di dermaga pelabuhan tanpa melewati pedagang perantara termasuk jenis saluran...",
            opsi = listOf("Distribusi langsung", "Distribusi tidak langsung", "Distribusi semi langsung", "Distribusi perantara tunggal", "Distribusi konsinyasi"),
            jawabanBenar = 0,
            pembahasan = "Distribusi langsung terjadi ketika produsen menyerahkan barang langsung kepada konsumen pemakai akhir tanpa perantara."
        ),
        Soal(
            id = 207, babId = 2, nomorSoal = 7,
            pertanyaan = "Perantara dagang yang membeli barang dalam jumlah besar dari produsen untuk dijual kembali kepada para pengecer (retailer) disebut...",
            opsi = listOf("Konsumen akhir", "Wholesaler (Grosir)", "Pialang saham", "Komisioner", "Konsultan bisnis"),
            jawabanBenar = 1,
            pembahasan = "Grosir atau wholesaler bertindak sebagai perantara dagang partai besar yang menghubungkan produsen dengan pengecer."
        ),
        Soal(
            id = 208, babId = 2, nomorSoal = 8,
            pertanyaan = "Pendekatan perilaku konsumen yang mengasumsikan bahwa tingkat kepuasan dapat diukur secara kuantitatif dengan satuan util adalah pendekatan...",
            opsi = listOf("Pendekatan Ordinal", "Pendekatan Indiferensi", "Pendekatan Kardinal", "Pendekatan Budget Line", "Pendekatan Moneter"),
            jawabanBenar = 2,
            pembahasan = "Pendekatan kardinal mengasumsikan kepuasan utilitas dapat dinyatakan dengan angka kuantitatif."
        ),
        Soal(
            id = 209, babId = 2, nomorSoal = 9,
            pertanyaan = "Hukum Gossen I yang dikenal pula sebagai hukum kepuasan yang semakin menurun berbunyi...",
            opsi = listOf("Setiap manusia berusaha memenuhi beragam kebutuhan hingga tingkat intensitas yang sama", "Semakin langka suatu barang, semakin tinggi nilai gunanya", "Tingkat konsumsi selalu berbanding lurus dengan tabungan", "Jika pemenuhan kebutuhan dilakukan berulang-ulang, tambahan kepuasannya lama-lama akan menurun", "Barang komplementer harus dikonsumsi bersamaan"),
            jawabanBenar = 3,
            pembahasan = "Hukum Gossen I menyatakan bahwa konsumsi berulang atas satu barang akan mendatangkan tambahan kepuasan (Marginal Utility) yang makin berkurang."
        ),
        Soal(
            id = 210, babId = 2, nomorSoal = 10,
            pertanyaan = "Seseorang yang memiliki uang Rp100.000 berusaha membaginya untuk membeli makanan, kuota internet, dan alat tulis hingga merasakan kepuasan seimbang. Hal ini mencerminkan...",
            opsi = listOf("Hukum Gossen I", "Hukum Engel", "Hukum Permintaan", "Hukum Penawaran", "Hukum Gossen II"),
            jawabanBenar = 4,
            pembahasan = "Hukum Gossen II menyatakan manusia memenuhi berbagai macam kebutuhan sampai mencapai tingkat intensitas kepuasan yang sama."
        ),
        Soal(
            id = 211, babId = 2, nomorSoal = 11,
            pertanyaan = "Dalam Circular Flow Diagram perekonomian 2 sektor, arus yang mengalir dari Rumah Tangga Produsen (RTP) ke Rumah Tangga Konsumen (RTK) pada pasar output adalah...",
            opsi = listOf("Barang dan jasa pemuas kebutuhan", "Faktor produksi lahan dan tenaga kerja", "Uang sewa, upah, dan bunga modal", "Penerimaan pajak dan retribusi", "Subsidi pendidikan"),
            jawabanBenar = 0,
            pembahasan = "Di pasar barang dan jasa (output), RTP menyalurkan barang dan jasa kepada RTK sebagai pembeli."
        ),
        Soal(
            id = 212, babId = 2, nomorSoal = 12,
            pertanyaan = "Pada Circular Flow Diagram, pihak yang berperan menyediakan faktor produksi seperti tanah, tenaga kerja, dan modal di pasar faktor produksi adalah...",
            opsi = listOf("Rumah Tangga Produsen (RTP)", "Rumah Tangga Konsumen (RTK)", "Bank Sentral", "Lembaga Kliring", "Pialang Internasional"),
            jawabanBenar = 1,
            pembahasan = "RTK adalah pemilik sah atas faktor-faktor produksi yang diserahkan kepada RTP melalui pasar input."
        ),
        Soal(
            id = 213, babId = 2, nomorSoal = 13,
            pertanyaan = "Dalam perekonomian 4 sektor, hubungan antara perekonomian domestik dengan masyarakat luar negeri diwujudkan melalui transaksi...",
            opsi = listOf("Pemungutan pajak bumi dan bangunan", "Pemberian subsidi pupuk lokal", "Ekspor dan impor barang serta jasa", "Penerbitan uang kartal rupiah", "Operasi pasar beras lokal"),
            jawabanBenar = 2,
            pembahasan = "Masyarakat Luar Negeri (MLN) berinteraksi dengan perekonomian dalam negeri melalui perdagangan internasional ekspor dan impor."
        ),
        Soal(
            id = 214, babId = 2, nomorSoal = 14,
            pertanyaan = "Dalam konsep arus pendapatan makro ekonomi, komponen yang tergolong sebagai suntikan (injections) adalah...",
            opsi = listOf("Tabungan (S), Pajak (T), dan Impor (M)", "Pajak (T), Investasi (I), dan Impor (M)", "Tabungan (S), Pengeluaran Pemerintah (G), dan Impor (M)", "Investasi (I), Pengeluaran Pemerintah (G), dan Ekspor (X)", "Konsumsi (C) dan Tabungan (S) saja"),
            jawabanBenar = 3,
            pembahasan = "Suntikan (injections) ke dalam arus perekonomian adalah Investasi (I), Pengeluaran Pemerintah (G), dan Ekspor (X)."
        ),
        Soal(
            id = 215, babId = 2, nomorSoal = 15,
            pertanyaan = "Aliran dana yang keluar dari siklus arus melingkar pendapatan domestik (leakages/bocoran) terdiri atas...",
            opsi = listOf("Investasi, Ekspor, dan Subsidi", "Konsumsi pangan dan Sandang", "Gaji pegawai, Bunga modal, dan Laba", "Ekspor, Belanja negara, dan Modal", "Tabungan, Pajak, dan Impor"),
            jawabanBenar = 4,
            pembahasan = "Bocoran (leakages) adalah dana yang tidak dibelanjakan kembali ke produk domestik: Tabungan (S), Pajak (T), dan Impor (M)."
        ),
        Soal(
            id = 216, babId = 2, nomorSoal = 16,
            pertanyaan = "Peran utama Rumah Tangga Negara (Pemerintah) dalam kegiatan perekonomian suatu negara adalah...",
            opsi = listOf("Membuat regulasi, menarik pajak, dan menyediakan barang publik", "Menghabiskan nilai guna barang mewah impor", "Menguasai seluruh laba sektor swasta", "Menetapkan kuota ekspor tanpa batas", "Menyalurkan pinjaman berbunga tinggi"),
            jawabanBenar = 0,
            pembahasan = "Pemerintah bertindak sebagai regulator, pemungut pajak, pemberi subsidi, dan penyedia fasilitas publik bagi rakyat."
        ),
        Soal(
            id = 217, babId = 2, nomorSoal = 17,
            pertanyaan = "Kurva indiferensi (Indifference Curve) dalam teori perilaku konsumen pendekatan ordinal menggambarkan...",
            opsi = listOf("Batasan jumlah pendapatan yang dapat dibelanjakan oleh konsumen", "Kombinasi dua barang yang memberikan tingkat kepuasan yang sama bagi konsumen", "Kenaikan biaya marjinal seiring pertambahan produksi", "Titik impas antara pendapatan dan pengeluaran", "Tingkat harga maksimum yang sanggup dibayar konsumen"),
            jawabanBenar = 1,
            pembahasan = "Kurva indiferensi menghubungkan titik-titik kombinasi konsumsi dua barang yang menghasilkan tingkat kepuasan yang identik."
        ),
        Soal(
            id = 218, babId = 2, nomorSoal = 18,
            pertanyaan = "Karakteristik penting dari garis anggaran (Budget Line) pada analisis perilaku konsumen adalah...",
            opsi = listOf("Menunjukkan tingkat kepuasan psikologis yang terus meningkat", "Tidak dipengaruhi oleh perubahan harga barang di pasar", "Menunjukkan kombinasi konsumsi barang yang dapat dibeli dengan pendapatan tertentu", "Memiliki kemiringan (slope) selalu bernilai positif", "Saling berpotongan dengan kurva penawaran produsen"),
            jawabanBenar = 2,
            pembahasan = "Budget line mencerminkan batas kemampuan belanja konsumen berdasarkan alokasi anggaran dan harga barang."
        ),
        Soal(
            id = 219, babId = 2, nomorSoal = 19,
            pertanyaan = "Seorang produsen menambah tenaga kerja dari 4 menjadi 5 orang, sehingga total produksi meningkat dari 100 unit menjadi 130 unit. Nilai produk marjinal (Marginal Product) tenaga kerja kelima adalah...",
            opsi = listOf("10 unit", "20 unit", "130 unit", "30 unit", "230 unit"),
            jawabanBenar = 3,
            pembahasan = "Marginal Product (MP) = ΔTP / ΔL = (130 - 100) / (5 - 4) = 30 unit."
        ),
        Soal(
            id = 220, babId = 2, nomorSoal = 20,
            pertanyaan = "Kegiatan berikut yang secara langsung mencerminkan fungsi produksi dalam ilmu ekonomi adalah...",
            opsi = listOf("Membeli pakaian seragam di pasar malam", "Membayar tagihan rekening air PDAM", "Menyimpan uang tabungan di celengan plastik", "Menghabiskan makanan di restoran cepat saji", "Mengubah bijih marmer Pangkep menjadi lantai ubin marmer bernilai jual"),
            jawabanBenar = 4,
            pembahasan = "Produksi adalah kegiatan menambah faedah atau menciptakan nilai guna baru pada suatu barang melalui pengolahan."
        ),
        Soal(
            id = 221, babId = 2, nomorSoal = 21,
            pertanyaan = "Dalam analisis biaya produksi, biaya yang jumlah totalnya tetap sama dan tidak dipengaruhi oleh banyak sedikitnya barang yang diproduksi disebut...",
            opsi = listOf("Biaya Tetap (Fixed Cost)", "Biaya Variabel (Variable Cost)", "Biaya Marjinal (Marginal Cost)", "Biaya Rata-Rata (Average Cost)", "Biaya Implisit"),
            jawabanBenar = 0,
            pembahasan = "Fixed Cost (FC) adalah biaya yang nominalnya tidak berubah meskipun volume output bertambah atau nol (misal sewa tempat)."
        ),
        Soal(
            id = 222, babId = 2, nomorSoal = 22,
            pertanyaan = "Jika Biaya Tetap (FC) sebuah usaha adalah Rp2.000.000 dan Biaya Variabel Total (TVC) untuk memproduksi 100 porsi makanan adalah Rp1.000.000, maka Total Biaya (TC) adalah...",
            opsi = listOf("Rp1.000.000", "Rp3.000.000", "Rp2.000.000", "Rp20.000", "Rp30.000"),
            jawabanBenar = 1,
            pembahasan = "Total Cost (TC) = FC + TVC = Rp2.000.000 + Rp1.000.000 = Rp3.000.000."
        ),
        Soal(
            id = 223, babId = 2, nomorSoal = 23,
            pertanyaan = "Faktor produksi turunan yang berperan mengombinasikan faktor alam, tenaga kerja, dan modal agar proses produksi berjalan efisien adalah...",
            opsi = listOf("Tenaga kerja kasar", "Kekayaan tanah dan air", "Keahlian kewirausahaan (Entrepreneurship)", "Bahan baku mentah", "Alat angkut logistik"),
            jawabanBenar = 2,
            pembahasan = "Kewirausahaan adalah faktor produksi turunan yang mengelola, mengorganisasi, dan mengambil risiko bisnis."
        ),
        Soal(
            id = 224, babId = 2, nomorSoal = 24,
            pertanyaan = "Perilaku konsumen rasional senantiasa berpedoman pada prinsip...",
            opsi = listOf("Membeli barang karena tergiur potongan harga sesaat", "Menghabiskan seluruh pendapatan tanpa menyisakan tabungan", "Mengutamakan gengsi merek di hadapan teman sebaya", "Memilih barang yang memberikan kepuasan optimal sesuai kemampuan finansial", "Membeli barang tiruan demi terlihat mewah"),
            jawabanBenar = 3,
            pembahasan = "Konsumen rasional mendasarkan pilihan pada utilitas optimal barang dan batas anggaran yang dimiliki."
        ),
        Soal(
            id = 225, babId = 2, nomorSoal = 25,
            pertanyaan = "Dalam diagram arus melingkar 3 sektor, penerimaan yang didapatkan pemerintah dari RTK dan RTP berupa...",
            opsi = listOf("Uang sewa tanah dan upah kerja", "Pinjaman luar negeri", "Hasil ekspor migas", "Laba dividen swasta", "Pembayaran pajak"),
            jawabanBenar = 4,
            pembahasan = "Dalam sistem 3 sektor, pemerintah memungut pajak (tax) dari rumah tangga konsumen dan produsen."
        )
    )
}
