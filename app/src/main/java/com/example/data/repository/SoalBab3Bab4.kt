package com.example.data.repository

import com.example.data.model.Soal

object SoalBab3Bab4 {

    val soalBab3: List<Soal> = listOf(
        Soal(
            id = 301, babId = 3, nomorSoal = 1,
            pertanyaan = "Hukum permintaan menyatakan bahwa jika harga suatu barang naik, maka jumlah barang yang diminta akan berkurang. Asumsi yang mendasari berlakunya hukum ini adalah...",
            opsi = listOf("Ceteris Paribus", "Laissez Faire", "Diminishing Utility", "Zero Sum Game", "Time Preference"),
            jawabanBenar = 0,
            pembahasan = "Ceteris paribus adalah asumsi bahwa faktor-faktor lain di luar harga barang itu sendiri dianggap konstan atau tidak berubah."
        ),
        Soal(
            id = 302, babId = 3, nomorSoal = 2,
            pertanyaan = "Hubungan antara harga suatu barang dengan jumlah barang yang ditawarkan oleh produsen berbanding lurus. Hal ini berarti kurva penawaran memiliki...",
            opsi = listOf("Kemiringan (slope) negatif dari kiri atas ke kanan bawah", "Kemiringan (slope) positif dari kiri bawah ke kanan atas", "Bentuk horizontal sejajar sumbu kuantitas", "Bentuk vertikal tegak lurus sumbu harga", "Bentuk lingkaran simetris"),
            jawabanBenar = 1,
            pembahasan = "Kurva penawaran memiliki slope positif karena kenaikan harga memotivasi produsen menambah jumlah barang yang ditawarkan."
        ),
        Soal(
            id = 303, babId = 3, nomorSoal = 3,
            pertanyaan = "Diketahui fungsi permintaan Qd = 200 - 2P dan fungsi penawaran Qs = -40 + 4P. Harga keseimbangan pasar (P) yang terbentuk adalah...",
            opsi = listOf("Rp20", "Rp30", "Rp40", "Rp50", "Rp60"),
            jawabanBenar = 2,
            pembahasan = "Qd = Qs => 200 - 2P = -40 + 4P => 240 = 6P => P = 40."
        ),
        Soal(
            id = 304, babId = 3, nomorSoal = 4,
            pertanyaan = "Berdasarkan fungsi permintaan Qd = 200 - 2P dan fungsi penawaran Qs = -40 + 4P, jumlah kuantitas keseimbangan (Q) di pasar adalah...",
            opsi = listOf("80 unit", "100 unit", "140 unit", "120 unit", "160 unit"),
            jawabanBenar = 3,
            pembahasan = "Dengan P = 40, substitusikan ke Qd = 200 - 2(40) = 200 - 80 = 120 unit (atau Qs = -40 + 4(40) = 120 unit)."
        ),
        Soal(
            id = 305, babId = 3, nomorSoal = 5,
            pertanyaan = "Jika pada fungsi Qd = 200 - 2P dan Qs = -40 + 4P harga pasar saat ini ditetapkan sebesar Rp50, maka kondisi yang terjadi di pasar adalah...",
            opsi = listOf("Keseimbangan pasar sempurna", "Kekurangan barang (shortage) sebesar 60 unit", "Kekurangan penawaran sebesar 160 unit", "Kelebihan permintaan sebesar 100 unit", "Kelebihan penawaran (surplus) sebesar 60 unit"),
            jawabanBenar = 4,
            pembahasan = "Pada P = 50, Qd = 200 - 2(50) = 100, sedangkan Qs = -40 + 4(50) = 160. Terjadi kelebihan penawaran (surplus) sebesar 160 - 100 = 60 unit."
        ),
        Soal(
            id = 306, babId = 3, nomorSoal = 6,
            pertanyaan = "Pergeseran kurva permintaan ke sebelah kanan (shift to the right) dapat disebabkan oleh...",
            opsi = listOf("Kenaikan pendapatan rata-rata masyarakat", "Penurunan harga barang itu sendiri", "Penurunan selera masyarakat terhadap barang", "Kenaikan harga barang komplementer", "Pajak barang mewah dinaikkan"),
            jawabanBenar = 0,
            pembahasan = "Peningkatan daya beli dan pendapatan masyarakat menggeser seluruh kurva permintaan ke kanan."
        ),
        Soal(
            id = 307, babId = 3, nomorSoal = 7,
            pertanyaan = "Perubahan pada harga barang itu sendiri akan mengakibatkan terjadinya...",
            opsi = listOf("Pergeseran kurva ke kanan", "Pergerakan di sepanjang kurva yang sama (movement along the curve)", "Pergeseran kurva ke kiri", "Perubahan elastisitas menjadi tak terhingga", "Kurva menjadi vertikal"),
            jawabanBenar = 1,
            pembahasan = "Perubahan harga barang itu sendiri hanya menimbulkan pergerakan dari satu titik ke titik lain di sepanjang kurva yang sama."
        ),
        Soal(
            id = 308, babId = 3, nomorSoal = 8,
            pertanyaan = "Jika harga suatu barang naik 10 persen dan mengakibatkan jumlah barang yang diminta turun sebesar 25 persen, maka koefisien elastisitas permintaannya adalah...",
            opsi = listOf("0,4 (Inelastis)", "1,0 (Uniter)", "2,5 (Elastis)", "0,0 (Inelastis sempurna)", "Tak terhingga"),
            jawabanBenar = 2,
            pembahasan = "Ed = |%ΔQ / %ΔP| = 25% / 10% = 2,5. Karena Ed > 1, maka permintaan tergolong elastis."
        ),
        Soal(
            id = 309, babId = 3, nomorSoal = 9,
            pertanyaan = "Barang-barang kebutuhan pokok seperti beras dan garam dapur pada umumnya memiliki sifat elastisitas permintaan...",
            opsi = listOf("Elastis (Ed > 1)", "Elastis sempurna (Ed = tak hingga)", "Elastis uniter (Ed = 1)", "Inelastis (Ed < 1)", "Nol mutlak"),
            jawabanBenar = 3,
            pembahasan = "Kebutuhan pokok mutlak dibutuhkan sehingga konsumen tidak banyak mengurangi pembelian meskipun harganya melonjak (inelastis)."
        ),
        Soal(
            id = 310, babId = 3, nomorSoal = 10,
            pertanyaan = "Kondisi di mana koefisien elastisitas bernilai nol (Ed = 0) disebut inelastis sempurna. Hal ini berarti...",
            opsi = listOf("Konsumen sangat sensitif terhadap perubahan harga sekecil apapun", "Produsen menguasai seluruh pasokan pasar", "Pada harga tertentu kuantitas barang tidak terhingga", "Persentase perubahan harga sama persis dengan perubahan kuantitas", "Perubahan harga sama sekali tidak memengaruhi jumlah barang yang diminta"),
            jawabanBenar = 4,
            pembahasan = "Ed = 0 berarti berapapun fluktuasi harga yang terjadi, kuantitas permintaan tetap sama persis (misal obat penyelamat jiwa)."
        ),
        Soal(
            id = 311, babId = 3, nomorSoal = 11,
            pertanyaan = "Pasar di mana terdapat sangat banyak penjual dan pembeli, serta barang yang diperdagangkan bersifat homogen (seragam) disebut...",
            opsi = listOf("Pasar Persaingan Sempurna", "Pasar Oligopoli", "Pasar Monopoli", "Pasar Monopolistik", "Pasar Monopsoni"),
            jawabanBenar = 0,
            pembahasan = "Ciri utama pasar persaingan sempurna adalah banyak pelaku, barang homogen, bebas keluar-masuk pasar, dan penjual berstatus price taker."
        ),
        Soal(
            id = 312, babId = 3, nomorSoal = 12,
            pertanyaan = "Dalam pasar persaingan sempurna, produsen bertindak sebagai price taker. Artinya...",
            opsi = listOf("Produsen bebas menentukan harga setinggi-tingginya", "Produsen menerima harga yang telah terbentuk di pasar tanpa daya mengubahnya", "Pemerintah yang menentukan kuota produksi harian", "Pembeli tidak memiliki hak memilih barang", "Harga ditentukan melalui perundingan rahasia kartel"),
            jawabanBenar = 1,
            pembahasan = "Karena kontribusi output satu produsen sangat kecil terhadap total pasar, produsen hanya menerima harga ekuilibrium pasar (price taker)."
        ),
        Soal(
            id = 313, babId = 3, nomorSoal = 13,
            pertanyaan = "Struktur pasar di mana hanya ada satu produsen tunggal yang menguasai penyediaan barang tanpa ada barang substitusi dekat disebut...",
            opsi = listOf("Monopsoni", "Oligopoli", "Monopoli", "Persaingan bebas", "Oligopsoni"),
            jawabanBenar = 2,
            pembahasan = "Pasar monopoli dikuasai oleh satu penjual tunggal sebagai penentu harga (price maker), contohnya PLN untuk kelistrikan nasional."
        ),
        Soal(
            id = 314, babId = 3, nomorSoal = 14,
            pertanyaan = "Industri semen di Indonesia, industri penerbangan, dan operator seluler merupakan contoh nyata struktur pasar...",
            opsi = listOf("Monopoli murni", "Persaingan sempurna", "Monopsoni", "Oligopoli", "Pasar gelap"),
            jawabanBenar = 3,
            pembahasan = "Pasar oligopoli dikuasai oleh segelintir (beberapa) produsen besar yang saling memperhitungkan keputusan pesaingnya."
        ),
        Soal(
            id = 315, babId = 3, nomorSoal = 15,
            pertanyaan = "Karakteristik khas dari pasar persaingan monopolistik yang membedakannya dari persaingan sempurna adalah...",
            opsi = listOf("Jumlah penjual hanya satu", "Barang tidak memiliki kegunaan nyata", "Tidak boleh ada iklan promosi", "Pemerintah menetapkan harga mati", "Adanya diferensiasi produk (perbedaan merek, kemasan, aroma)"),
            jawabanBenar = 4,
            pembahasan = "Pasar monopolistik memiliki banyak penjual yang menawarkan produk serupa namun terdiferensiasi (berbeda merek, kemasan, atau mutu)."
        ),
        Soal(
            id = 316, babId = 3, nomorSoal = 16,
            pertanyaan = "Keberadaan platform e-commerce dan aplikasi pasar digital memberikan manfaat ekonomi berupa disintermediasi, yaitu...",
            opsi = listOf("Pemotongan mata rantai distribusi antara produsen dan konsumen akhir", "Penambahan jumlah perantara spekulan di pasar", "Kenaikan biaya sewa lapak fisik di pasar tradisional", "Penurunan kualitas barang yang diperdagangkan", "Monopoli perdagangan oleh pemerintah"),
            jawabanBenar = 0,
            pembahasan = "Disintermediasi adalah penghapusan perantara atau calo berlebih sehingga produsen daerah bisa menjual langsung ke pembeli dengan harga efisien."
        ),
        Soal(
            id = 317, babId = 3, nomorSoal = 17,
            pertanyaan = "Ketika harga barang X naik menyebabkan permintaan terhadap barang Y meningkat, maka hubungan antara barang X dan Y adalah...",
            opsi = listOf("Komplementer", "Substitusi", "Inferior", "Giffen", "Bebas"),
            jawabanBenar = 1,
            pembahasan = "Barang substitusi (pengganti) memiliki elastisitas silang positif: kenaikan harga barang X membuat konsumen beralih membeli barang Y."
        ),
        Soal(
            id = 318, babId = 3, nomorSoal = 18,
            pertanyaan = "Kenaikan harga bensin yang drastis mengakibatkan penurunan jumlah pembelian sepeda motor. Hal ini menunjukkan bahwa bensin dan motor adalah...",
            opsi = listOf("Barang substitusi", "Barang bebas", "Barang komplementer", "Barang mewah", "Barang publik"),
            jawabanBenar = 2,
            pembahasan = "Barang komplementer adalah barang pelengkap yang pemakaiannya berpasangan; kenaikan harga satu barang menurunkan permintaan pasangannya."
        ),
        Soal(
            id = 319, babId = 3, nomorSoal = 19,
            pertanyaan = "Pemberian subsidi oleh pemerintah kepada para petani tambak bandeng di Pangkep akan mengakibatkan kurva penawaran bandeng...",
            opsi = listOf("Berubah menjadi garis vertikal tegak", "Bergeser ke kiri atas karena harga naik", "Tetap diam di posisi semula", "Bergeser ke kanan bawah karena biaya produksi berkurang", "Saling berpotongan dengan kurva pajak"),
            jawabanBenar = 3,
            pembahasan = "Subsidi meringankan beban biaya produksi sehingga produsen terdorong memproduksi lebih banyak, menggeser kurva penawaran ke kanan."
        ),
        Soal(
            id = 320, babId = 3, nomorSoal = 20,
            pertanyaan = "Penetapan harga batas maksimum (Ceiling Price) oleh pemerintah pada komoditas sembako bertujuan untuk...",
            opsi = listOf("Melindungi produsen agar tidak merugi", "Menciptakan kelangkaan barang yang disengaja", "Mendorong peningkatan volume impor", "Menambah pemasukan kas negara dari pajak", "Melindungi konsumen dari lonjakan harga yang terlampau tinggi"),
            jawabanBenar = 4,
            pembahasan = "Kebijakan harga tertinggi (ceiling price) ditetapkan di bawah harga pasar bebas guna melindungi daya beli konsumen masyarakat luas."
        ),
        Soal(
            id = 321, babId = 3, nomorSoal = 21,
            pertanyaan = "Sebaliknya, penetapan harga dasar terendah (Floor Price) misalnya pada gabah petani bertujuan untuk...",
            opsi = listOf("Melindungi petani agar harga jual gabah tidak jatuh terlampau murah", "Membuat beras langka di pasaran", "Mengurangi upah buruh tani", "Menghapus peran bulog dalam distribusi", "Menurunkan pendapatan petani"),
            jawabanBenar = 0,
            pembahasan = "Floor price ditetapkan di atas harga pasar bebas demi melindungi produsen/petani dari kejatuhan harga saat panen raya."
        ),
        Soal(
            id = 322, babId = 3, nomorSoal = 22,
            pertanyaan = "Jika fungsi permintaan adalah P = 100 - 0,5Q, maka jumlah barang yang diminta saat harga P = 60 adalah...",
            opsi = listOf("40 unit", "80 unit", "60 unit", "100 unit", "120 unit"),
            jawabanBenar = 1,
            pembahasan = "60 = 100 - 0,5Q => 0,5Q = 40 => Q = 80 unit."
        ),
        Soal(
            id = 323, babId = 3, nomorSoal = 23,
            pertanyaan = "Faktor berikut ini yang BUKAN merupakan faktor pemengaruh pergeseran kurva penawaran suatu produk adalah...",
            opsi = listOf("Biaya faktor produksi", "Kemajuan teknologi mesin", "Pendapatan konsumen per kapita", "Pajak dan subsidi pemerintah", "Ekspektasi harga masa depan produsen"),
            jawabanBenar = 2,
            pembahasan = "Pendapatan konsumen adalah faktor yang memengaruhi pergeseran kurva permintaan, bukan kurva penawaran."
        ),
        Soal(
            id = 324, babId = 3, nomorSoal = 24,
            pertanyaan = "Di pasar tradisional Pangkep, ketika pasokan ikan melimpah ruah akibat cuaca laut tenang namun jumlah pembeli tetap, harga ikan akan cenderung...",
            opsi = listOf("Melesat naik tinggi", "Menjadi tak terhingga", "Tetap tidak berubah sama sekali", "Turun menuju ekuilibrium baru", "Ditutup oleh pengelola"),
            jawabanBenar = 3,
            pembahasan = "Peningkatan penawaran dengan permintaan konstan menimbulkan kelebihan pasokan, menekan harga bergerak turun ke ekuilibrium baru."
        ),
        Soal(
            id = 325, babId = 3, nomorSoal = 25,
            pertanyaan = "Struktur pasar monopsoni ditandai oleh ciri khas yaitu...",
            opsi = listOf("Produk selalu diimpor dari luar negeri", "Hanya ada satu penjual yang menghadapi banyak pembeli", "Semua penjual bersepakat membentuk harga kartel", "Tidak ada barang yang diperdagangkan", "Hanya terdapat satu pembeli tunggal yang menghadapi banyak penjual"),
            jawabanBenar = 4,
            pembahasan = "Pasar monopsoni adalah kondisi pasar di mana hanya ada satu pihak pembeli tunggal yang menguasai penerimaan komoditas."
        )
    )

    val soalBab4: List<Soal> = listOf(
        Soal(
            id = 401, babId = 4, nomorSoal = 1,
            pertanyaan = "Berdasarkan undang-undang perbankan sentral di Indonesia, tujuan tunggal dari Bank Indonesia adalah...",
            opsi = listOf("Mencapai dan memelihara kestabilan nilai Rupiah", "Menghimpun dana masyarakat seluas-luasnya", "Memberikan pinjaman modal bagi UMKM di daerah", "Membiayai proyek pembangunan gedung pemerintah", "Mengelola penerimaan pajak pusat dan daerah"),
            jawabanBenar = 0,
            pembahasan = "Tujuan tunggal BI sebagaimana diamanatkan undang-undang adalah mencapai dan memelihara kestabilan nilai Rupiah."
        ),
        Soal(
            id = 402, babId = 4, nomorSoal = 2,
            pertanyaan = "Kestabilan nilai Rupiah yang dijaga oleh Bank Indonesia mengandung dua aspek utama yaitu kestabilan terhadap...",
            opsi = listOf("Harga tanah dan harga emas batangan", "Harga barang/jasa (inflasi) dan mata uang negara lain (kurs)", "Bunga pinjaman swasta dan dividen saham", "Penerimaan ekspor migas dan nonmigas", "Gaji pegawai negeri dan upah buruh"),
            jawabanBenar = 1,
            pembahasan = "Dua aspek kestabilan rupiah adalah kestabilan internal (harga barang/inflasi) dan kestabilan eksternal (nilai tukar valuta asing)."
        ),
        Soal(
            id = 403, babId = 4, nomorSoal = 3,
            pertanyaan = "Berikut ini yang BUKAN merupakan salah satu dari tiga pilar tugas pokok Bank Indonesia adalah...",
            opsi = listOf("Menetapkan dan melaksanakan kebijakan moneter", "Mengatur dan menjaga kelancaran sistem pembayaran", "Menetapkan vonis hukum atas sengketa perdata nasabah", "Menjaga stabilitas sistem keuangan (makroprudensial)", "Mengatur peredaran uang rupiah"),
            jawabanBenar = 2,
            pembahasan = "Menetapkan vonis hukum perdata adalah wewenang pengadilan/yudikatif, bukan wewenang bank sentral."
        ),
        Soal(
            id = 404, babId = 4, nomorSoal = 4,
            pertanyaan = "Ketika laju inflasi melonjak tinggi di atas target, kebijakan moneter kontraktif (tight money policy) yang diambil Bank Indonesia adalah...",
            opsi = listOf("Menurunkan suku bunga acuan BI-Rate", "Menurunkan cadangan kas minimum bank", "Membeli Surat Berharga Negara dari pasar", "Menaikkan suku bunga acuan BI-Rate", "Mempermudah syarat penyaluran kredit perbankan"),
            jawabanBenar = 3,
            pembahasan = "Kenaikan suku bunga BI-Rate akan mendorong masyarakat menabung dan mengerem konsumsi berlebih sehingga laju inflasi melandai."
        ),
        Soal(
            id = 405, babId = 4, nomorSoal = 5,
            pertanyaan = "Peran Bank Indonesia sebagai lender of the last resort memiliki arti bahwa BI...",
            opsi = listOf("Merupakan tempat peminjaman uang pertama bagi masyarakat umum", "Pengelola tunggal dana pensiun nasional", "Satu-satunya lembaga yang berhak menyita aset debitur macet", "Penjamin simpanan nasabah bangkrut", "Pemberi pinjaman likuiditas terakhir bagi bank umum yang mengalami krisis likuiditas"),
            jawabanBenar = 4,
            pembahasan = "Lender of the last resort adalah fungsi BI sebagai penyedia pinjaman darurat terakhir untuk mencegah kegagalan sistemik perbankan."
        ),
        Soal(
            id = 406, babId = 4, nomorSoal = 6,
            pertanyaan = "Sistem transfer dana elektronik antarbank yang diselesaikan seketika secara real-time untuk transaksi bernilai besar (di atas Rp100 juta) adalah...",
            opsi = listOf("BI-RTGS", "SKNBI", "BI-FAST", "ATM Bersama", "POS"),
            jawabanBenar = 0,
            pembahasan = "BI-RTGS (Real Time Gross Settlement) melayani transaksi bernilai besar secara seketika dan tidak dapat dibatalkan (irrevocable)."
        ),
        Soal(
            id = 407, babId = 4, nomorSoal = 7,
            pertanyaan = "Infrastruktur sistem pembayaran ritel nasional yang diluncurkan Bank Indonesia dan beroperasi tanpa henti 24 jam sehari, 7 hari seminggu dengan biaya murah adalah...",
            opsi = listOf("BI-RTGS", "BI-FAST", "Wesel Pos", "Cek Bank Garansi", "Bilyet Giro Kliring"),
            jawabanBenar = 1,
            pembahasan = "BI-FAST adalah layanan pembayaran ritel nasional yang beroperasi 24/7/365 dengan tarif murah Rp2.500 per transaksi."
        ),
        Soal(
            id = 408, babId = 4, nomorSoal = 8,
            pertanyaan = "Penyelesaian transaksi kliring antarbank yang dilakukan secara periodik terjadwal dalam hitungan beberapa jam (batch system) diselenggarakan melalui...",
            opsi = listOf("BI-FAST", "BI-RTGS", "SKNBI", "Pasar Uang Antar Bank", "SWIFT"),
            jawabanBenar = 2,
            pembahasan = "SKNBI (Sistem Kliring Nasional BI) memproses transaksi transfer dana dan warkat debit secara berkala dalam batch terjadwal."
        ),
        Soal(
            id = 409, babId = 4, nomorSoal = 9,
            pertanyaan = "Uang kartal yang beredar di masyarakat dan wajib diterima sebagai alat pembayaran yang sah terdiri atas...",
            opsi = listOf("Saldo dompet digital dan kripto", "Kartu kredit dan kartu debit", "Cek dan bilyet giro", "Uang kertas dan uang logam", "Obligasi dan saham"),
            jawabanBenar = 3,
            pembahasan = "Uang kartal secara hukum terdiri atas uang kertas dan uang logam rupiah yang dikeluarkan oleh Bank Indonesia."
        ),
        Soal(
            id = 410, babId = 4, nomorSoal = 10,
            pertanyaan = "Alat pembayaran berupa surat perintah nasabah kepada bank untuk memindahbukukan sejumlah dana ke rekening penerima tanpa ditarik tunai disebut...",
            opsi = listOf("Uang kartal", "Cek tunai", "Saham preferen", "Kupon obligasi", "Bilyet giro"),
            jawabanBenar = 4,
            pembahasan = "Bilyet giro adalah surat perintah pemindahbukuan dana dari rekening penarik ke rekening penerima tanpa pencairan uang tunai."
        ),
        Soal(
            id = 411, babId = 4, nomorSoal = 11,
            pertanyaan = "Gerakan cinta rupiah yang disosialisasikan Bank Indonesia untuk mengenali keaslian uang kertas rupiah dikenal dengan slogan...",
            opsi = listOf("3D (Dilihat, Diraba, Diterawang)", "3M (Melihat, Mengingat, Menjaga)", "5C (Cek, Cocok, Catat, Cair, Cepat)", "2L (Legal, Logis)", "4P (Price, Product, Place, Promotion)"),
            jawabanBenar = 0,
            pembahasan = "Metode 3D (Dilihat, Diraba, Diterawang) adalah panduan praktis masyarakat dalam memeriksa fitur pengaman uang rupiah."
        ),
        Soal(
            id = 412, babId = 4, nomorSoal = 12,
            pertanyaan = "Saat memeriksa uang kertas rupiah pecahan Rp100.000 dengan cara 'Diraba', ciri keaslian yang dapat dirasakan adalah...",
            opsi = listOf("Permukaan uang terasa licin mengkilap sempurna", "Tekstur kasar pada gambar lambang Garuda, angka nominal, dan gambar pahlawan", "Warna uang berubah menjadi gelap pekat", "Uang mengeluarkan aroma wangi kimia", "Kertas terasa tipis seperti plastik pembungkus"),
            jawabanBenar = 1,
            pembahasan = "Uang rupiah asli menggunakan cetak intaglio yang menghasilkan tekstur rabaan kasar pada gambar utama dan nominal."
        ),
        Soal(
            id = 413, babId = 4, nomorSoal = 13,
            pertanyaan = "Teknik cetak gambar pengaman saling isi yang membentuk logo utuh Bank Indonesia secara presisi saat diterawang ke arah cahaya disebut...",
            opsi = listOf("Watermark", "Blind Code", "Rectoverso", "Microtext", "Hologram"),
            jawabanBenar = 2,
            pembahasan = "Rectoverso adalah gambar saling mengisi di sisi muka dan belakang yang membentuk logo BI secara utuh saat diterawang."
        ),
        Soal(
            id = 414, babId = 4, nomorSoal = 14,
            pertanyaan = "Standar nasional kode respons cepat pembayaran non-tunai di Indonesia yang ditetapkan oleh Bank Indonesia bersama ASPI dinamakan...",
            opsi = listOf("EDC", "NFC Payment", "GPN", "QRIS", "QuickPay"),
            jawabanBenar = 3,
            pembahasan = "QRIS (Quick Response Code Indonesian Standard) menyatukan berbagai QR pembayaran ke dalam satu kode standar nasional."
        ),
        Soal(
            id = 415, babId = 4, nomorSoal = 15,
            pertanyaan = "Manfaat utama implementasi QRIS bagi pelaku usaha mikro dan pedagang kantin sekolah adalah...",
            opsi = listOf("Bebas dari segala kewajiban hukum usaha", "Pasti terbebas dari pajak seumur hidup", "Diberikan modal tunai cuma-cuma oleh bank", "Tidak perlu mencatat transaksi sama sekali", "Cukup menyediakan satu kode QR untuk menerima pembayaran dari berbagai aplikasi dompet digital dan m-Banking"),
            jawabanBenar = 4,
            pembahasan = "Dengan konsep interkoneksi QRIS, pedagang cukup memajang satu QR untuk menerima pembayaran dari semua aplikasi PJSP."
        ),
        Soal(
            id = 416, babId = 4, nomorSoal = 16,
            pertanyaan = "Salah satu fungsi turunan dari uang dalam kehidupan perekonomian masyarakat adalah sebagai...",
            opsi = listOf("Alat penimbun atau penyimpan kekayaan", "Satuan hitung nilai", "Alat tukar umum", "Alat pemuas kebutuhan biologis", "Barang konsumsi primer"),
            jawabanBenar = 0,
            pembahasan = "Fungsi asli uang adalah alat tukar dan satuan hitung, sedangkan fungsi turunannya meliputi penyimpan nilai/kekayaan, alat pembayaran utang, dan pemindah kekayaan."
        ),
        Soal(
            id = 417, babId = 4, nomorSoal = 17,
            pertanyaan = "Kelemahan utama dari sistem pertukaran barter sebelum ditemukannya uang sebagai alat tukar adalah...",
            opsi = listOf("Uang terlalu berat untuk dibawa bepergian", "Sulitnya menemukan keselarasan kebutuhan timbal balik (double coincidence of wants)", "Barang dagangan tidak dapat diproduksi", "Pemerintah melarang perdagangan antar desa", "Nilai barang selalu stabil"),
            jawabanBenar = 1,
            pembahasan = "Sistem barter membutuhkan kecocokan ganda antara barang yang dimiliki dan barang yang diinginkan (double coincidence of wants)."
        ),
        Soal(
            id = 418, babId = 4, nomorSoal = 18,
            pertanyaan = "Syarat teknis suatu benda dapat disepakati dan difungsikan sebagai uang adalah...",
            opsi = listOf("Mudah rusak dan cepat membusuk", "Jumlahnya tidak terbatas dan mudah diduplikasi siapa saja", "Tahan lama, mudah dibawa (portability), dan nilainya relatif stabil", "Berukuran sangat besar dan berbobot berat", "Hanya berlaku dalam satu keluarga"),
            jawabanBenar = 2,
            pembahasan = "Syarat benda uang: acceptability, durability, portability, divisibility, uniformity, dan scarcity yang terjaga."
        ),
        Soal(
            id = 419, babId = 4, nomorSoal = 19,
            pertanyaan = "Uang yang nilai intrinsik bahan pembuatnya sama persis dengan nilai nominal yang tertera pada uang tersebut disebut uang...",
            opsi = listOf("Uang giral bank", "Token money (Uang tanda)", "Uang elektronik", "Full bodied money (Uang bernilai penuh)", "Uang kuasi"),
            jawabanBenar = 3,
            pembahasan = "Full bodied money bernilai penuh, contohnya koin emas murni di mana nilai logamnya sama dengan nominalnya."
        ),
        Soal(
            id = 420, babId = 4, nomorSoal = 20,
            pertanyaan = "Lembaga yang berwenang mencetak uang kertas dan uang logam Rupiah atas pesanan dan standar dari Bank Indonesia adalah...",
            opsi = listOf("PT Bank Rakyat Indonesia", "Badan Usaha Milik Desa", "Otoritas Jasa Keuangan", "Kementerian Keuangan RI", "Perum Percetakan Uang Republik Indonesia (Peruri)"),
            jawabanBenar = 4,
            pembahasan = "Perum Peruri adalah BUMN yang ditugaskan negara untuk mencetak uang Rupiah sesuai spesifikasi Bank Indonesia."
        ),
        Soal(
            id = 421, babId = 4, nomorSoal = 21,
            pertanyaan = "Prinsip 5C yang menjadi pedoman Cinta, Bangga, Paham Rupiah mencakup sikap Paham Rupiah yaitu memahami fungsi rupiah dalam...",
            opsi = listOf("Bertransaksi, Berbelanja, dan Berhemat", "Konsumsi barang mewah luar negeri", "Menimbun kekayaan di luar negeri", "Membuat kerajinan tangan dari uang asli", "Mengirim uang tanpa verifikasi"),
            jawabanBenar = 0,
            pembahasan = "Paham Rupiah adalah memahami peran rupiah sebagai alat bertransaksi, sarana berbelanja bijak, dan instrumen berhemat/investasi."
        ),
        Soal(
            id = 422, babId = 4, nomorSoal = 22,
            pertanyaan = "Dalam kebijakan sistem pembayaran, prinsip safety (keamanan) yang diwajibkan oleh Bank Indonesia bertujuan untuk...",
            opsi = listOf("Memastikan biaya transaksi semahal mungkin", "Mencegah risiko kebocoran data, kecurangan sistem, dan kerugian dana pengguna", "Membatasi masyarakat membuka rekening bank", "Meniadakan transaksi transfer antarbank", "Mengharuskan transaksi tunai saja"),
            jawabanBenar = 1,
            pembahasan = "Prinsip keamanan sistem pembayaran memastikan seluruh infrastruktur terlindung dari risiko operasional, fraud, dan kebocoran dana."
        ),
        Soal(
            id = 423, babId = 4, nomorSoal = 23,
            pertanyaan = "Uang elektronik berbasis chip (chip-based) yang biasa digunakan untuk membayar tol dan transportasi umum contohnya adalah...",
            opsi = listOf("Bilyet giro pos", "Aplikasi dompet digital berbasis server", "E-Money / Flazz", "Cek perjalanan wisata", "Surat utang negara"),
            jawabanBenar = 2,
            pembahasan = "Kartu uang elektronik seperti e-Money dan Flazz menyimpan saldo langsung pada chip kartu tanpa perlu koneksi internet saat tapping."
        ),
        Soal(
            id = 424, babId = 4, nomorSoal = 24,
            pertanyaan = "Apabila Bank Indonesia menetapkan penurunan Giro Wajib Minimum (GWM) perbankan, dampak yang diharapkan terjadi pada likuiditas perekonomian adalah...",
            opsi = listOf("Penyaluran kredit bank semakin menyusut", "Uang rupiah ditarik dari peredaran", "Tingkat suku bunga pinjaman melonjak tinggi", "Dana yang dapat disalurkan bank ke masyarakat bertambah banyak", "Masyarakat dilarang menabung"),
            jawabanBenar = 3,
            pembahasan = "Penurunan GWM melonggarkan likuiditas bank sehingga bank memiliki kapasitas lebih besar untuk menyalurkan kredit ke dunia usaha."
        ),
        Soal(
            id = 425, babId = 4, nomorSoal = 25,
            pertanyaan = "Tindakan merusak, mencoret, melipat-lipat hingga lusuh, atau meremas uang Rupiah kertas merupakan pelanggaran undang-undang karena uang Rupiah merupakan...",
            opsi = listOf("Barang pribadi yang bebas diperlakukan apa saja", "Kertas daur ulang biasa", "Barang komersial yang bernilai rendah", "Alat mainan anak di sekolah", "Simbol kedaulatan negara Republik Indonesia yang wajib dihormati"),
            jawabanBenar = 4,
            pembahasan = "UU No. 7 Tahun 2011 tentang Mata Uang menegaskan Rupiah adalah lambang kedaulatan negara yang wajib dijaga kehormatannya."
        )
    )
}
