package com.example.data.repository

import com.example.data.model.Bab
import com.example.data.model.DiagramType
import com.example.data.model.GlosariumItem
import com.example.data.model.HighlightType
import com.example.data.model.MateriSection
import com.example.data.model.Subbab

object MateriDataSemester1 {

    val bab1 = Bab(
        id = 1,
        semester = 1,
        judul = "Bab 1: Konsep Ilmu Ekonomi",
        deskripsi = "Memahami hakikat ilmu ekonomi, kelangkaan, kebutuhan manusia, biaya peluang, dan dasar ekonomi syariah.",
        subbabList = listOf(
            Subbab(
                id = "1.1",
                babId = 1,
                judul = "1.1 Pengertian dan Sejarah Singkat Ilmu Ekonomi",
                ringkasan = "Etimologi kata ekonomi berasal dari bahasa Yunani (Oikos dan Nomos) dan perkembangannya sejak era Adam Smith.",
                sections = listOf(
                    MateriSection.Heading("Etimologi Kata Ekonomi"),
                    MateriSection.Paragraph("Secara etimologis, kata ekonomi berasal dari bahasa Yunani, yaitu Oikos yang berarti rumah tangga atau keluarga, dan Nomos yang berarti tata aturan, hukum, atau kaidah. Dengan demikian, oikonomia pada awalnya bermakna aturan pengelolaan rumah tangga demi mencukupi kebutuhan hidup berkeluarga."),
                    MateriSection.HighlightBox(
                        HighlightType.TAHUKAH_KAMU,
                        "Bapak Ilmu Ekonomi Modern",
                        "Adam Smith menerbitkan karya monumentalnya 'The Wealth of Nations' pada tahun 1776, yang menandai kelahiran ilmu ekonomi sebagai disiplin ilmu mandiri yang sistematis dengan gagasan 'The Invisible Hand'."
                    ),
                    MateriSection.Heading("Definisi Ilmu Ekonomi Menurut Para Ahli"),
                    MateriSection.Bullets(
                        listOf(
                            "Adam Smith: Ilmu yang mempelajari tingkah laku manusia dalam usahanya mengalokasikan sumber daya terbatas untuk mencapai tujuan tertentu.",
                            "Paul A. Samuelson: Studi tentang bagaimana masyarakat memanfaatkan sumber daya langka untuk memproduksi komoditas berharga dan mendistribusikannya.",
                            "M. Manullang: Ilmu yang mempelajari cara manusia memenuhi kebutuhan jasmani dan rohani menggunakan alat pemuas yang terbatas."
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.ANALOGI,
                        "Analogi Pengelolaan Dompet",
                        "Bayangkan kamu memiliki uang saku Rp50.000 untuk satu minggu di SMAN 1 Pangkep. Kamu harus memilih antara membeli buku catatan, jajan di kantin, atau menabung transport. Itulah inti pengambilan keputusan ekonomi!"
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Oikos", "Rumah tangga atau keluarga dalam bahasa Yunani kuno."),
                    GlosariumItem("Nomos", "Hukum, aturan, atau kaidah pengelolaan."),
                    GlosariumItem("Invisible Hand", "Kekuatan pasar tak terlihat yang mendorong efisiensi alokasi sumber daya.")
                )
            ),
            Subbab(
                id = "1.2",
                babId = 1,
                judul = "1.2 Kebutuhan dan Alat Pemuas Kebutuhan",
                ringkasan = "Klasifikasi kebutuhan manusia berdasarkan intensitas, waktu, sifat, dan subjek, serta hierarki Maslow.",
                sections = listOf(
                    MateriSection.Heading("Klasifikasi Kebutuhan Manusia"),
                    MateriSection.Paragraph("Kebutuhan manusia pada dasarnya tidak terbatas, sedangkan alat pemuas kebutuhan yang tersedia di alam sangat terbatas. Kebutuhan dibedakan berdasarkan:"),
                    MateriSection.Table(
                        headers = listOf("Kategori", "Jenis", "Contoh Nyata"),
                        rows = listOf(
                            listOf("Intensitas", "Primer, Sekunder, Tersier", "Makanan pokok, gawai belajar, mobil mewah"),
                            listOf("Waktu Pemenuhan", "Sekarang, Akan Datang", "Obat saat sakit, tabungan kuliah"),
                            listOf("Sifat", "Jasmani, Rohani", "Olahraga & makan, ibadah & rekreasi"),
                            listOf("Subjek", "Individu, Kolektif", "Kacamata baca, jalan raya & jembatan Pangkep")
                        )
                    ),
                    MateriSection.Heading("Hierarki Piramida Kebutuhan Abraham Maslow"),
                    MateriSection.Paragraph("Psikolog Abraham Maslow merumuskan bahwa manusia memenuhi kebutuhan secara bertingkat dari yang paling mendasar:"),
                    MateriSection.InteractiveDiagram(DiagramType.MASLOW_PYRAMID),
                    MateriSection.HighlightBox(
                        HighlightType.INGAT,
                        "Inti Kebutuhan",
                        "Kebutuhan primer wajib dipenuhi terlebih dahulu agar manusia dapat bertahan hidup secara layak (survive)."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Kebutuhan Primer", "Kebutuhan pokok mutlak seperti sandang, pangan, dan papan."),
                    GlosariumItem("Kebutuhan Tersier", "Kebutuhan akan kemewahan untuk prestise atau status sosial.")
                )
            ),
            Subbab(
                id = "1.3",
                babId = 1,
                judul = "1.3 Kelangkaan dan Masalah Pokok Ekonomi",
                ringkasan = "Konsep scarcity dan tiga masalah pokok ekonomi klasik vs modern (What, How, for Whom).",
                sections = listOf(
                    MateriSection.Heading("Hakikat Kelangkaan (Scarcity)"),
                    MateriSection.Paragraph("Kelangkaan timbul karena ketimpangan antara kebutuhan manusia yang tidak berbatas dengan ketersediaan sumber daya (alam, tenaga kerja, modal, dan kewirausahaan). Kelangkaan bukan berarti barang tidak ada sama sekali, melainkan memerlukan pengorbanan untuk memperolehnya."),
                    MateriSection.Heading("Perbandingan Masalah Pokok Ekonomi"),
                    MateriSection.Table(
                        headers = listOf("Sudut Pandang", "Masalah Pokok", "Fokus Utama"),
                        rows = listOf(
                            listOf("Teori Klasik", "Produksi", "Bagaimana barang/jasa dibuat untuk mencukupi kebutuhan"),
                            listOf("Teori Klasik", "Distribusi", "Menyalurkan barang dari produsen ke konsumen secara tepat"),
                            listOf("Teori Klasik", "Konsumsi", "Apakah barang tersebut benar-benar dihabiskan nilainya"),
                            listOf("Teori Modern", "WHAT", "Barang apa yang akan diproduksi dan berapa banyak jumlahnya?"),
                            listOf("Teori Modern", "HOW", "Bagaimana teknik memproduksi secara efisien (padat modal/karya)?"),
                            listOf("Teori Modern", "FOR WHOM", "Untuk siapa barang diproduksi dan bagaimana distribusinya?")
                        )
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.CONTOH,
                        "Studi Kasus Pangkep",
                        "Pelaku UMKM Bandeng Tanpa Duri di Pangkep memutuskan memproduksi bandeng beku presto (WHAT), memakai mesin pencabut duri higienis (HOW), untuk menyuplai minimarket dan wisatawan Makassar (FOR WHOM)."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Scarcity", "Kondisi kelangkaan sumber daya relatif terhadap kebutuhan yang tak terbatas."),
                    GlosariumItem("What, How, for Whom", "Tiga pilar masalah alokasi ekonomi modern.")
                )
            ),
            Subbab(
                id = "1.4",
                babId = 1,
                judul = "1.4 Skala Prioritas, Biaya Peluang, dan Kurva PPF",
                ringkasan = "Menentukan skala prioritas, menghitung opportunity cost, dan analisis kurva batas kemungkinan produksi.",
                sections = listOf(
                    MateriSection.Heading("Skala Prioritas"),
                    MateriSection.Paragraph("Skala prioritas adalah urutan daftar kebutuhan yang disusun berdasarkan tingkat kepentingan dan urgensinya. Kebutuhan mendesak dan penting wajib ditempatkan pada posisi teratas."),
                    MateriSection.Heading("Biaya Peluang (Opportunity Cost)"),
                    MateriSection.Paragraph("Biaya peluang adalah nilai dari kesempatan terbaik berikutnya yang harus dikorbankan ketika memilih suatu alternatif tindakan ekonomi."),
                    MateriSection.FormulaCard(
                        title = "Rumus Logika Biaya Peluang",
                        formula = "Biaya Peluang = Nilai Alternatif Terbaik yang Ditinggalkan",
                        explanation = "Bila memilih B daripada A, nilai manfaat dari A yang hilang adalah biaya peluang dari memilih B."
                    ),
                    MateriSection.Heading("Kurva Batas Kemungkinan Produksi (PPF)"),
                    MateriSection.Paragraph("Production Possibility Frontier (PPF) menggambarkan kombinasi maksimum dua output yang dapat dihasilkan perekonomian menggunakan sumber daya yang tersedia secara penuh dan efisien:"),
                    MateriSection.InteractiveDiagram(DiagramType.PPF_CURVE),
                    MateriSection.HighlightBox(
                        HighlightType.WASPADA,
                        "Jebakan Biaya Eksplisit vs Implisit",
                        "Biaya peluang bukan sekadar uang tunai yang kamu keluarkan, melainkan potensi keuntungan atau pendapatan masa depan yang kamu relakan."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Opportunity Cost", "Biaya kesempatan atau nilai terbaik yang dikorbankan."),
                    GlosariumItem("PPF", "Production Possibility Frontier; kurva batas kemungkinan produksi.")
                )
            ),
            Subbab(
                id = "1.5",
                babId = 1,
                judul = "1.5 Pembagian Ilmu Ekonomi",
                ringkasan = "Mengenal ekonomi deskriptif, teori ekonomi (mikro dan makro), serta ekonomi terapan.",
                sections = listOf(
                    MateriSection.Heading("Tiga Cabang Utama Ilmu Ekonomi"),
                    MateriSection.Bullets(
                        listOf(
                            "Ekonomi Deskriptif: Mengumpulkan fakta dan data empiris tentang fenomena ekonomi nyata (misal: data inflasi BPS Sulsel, laju ekspor semen Tonasa Pangkep).",
                            "Teori Ekonomi: Merumuskan hubungan sebab-akibat dan hukum ekonomi secara konseptual. Terbagi menjadi Mikroekonomi dan Makroekonomi.",
                            "Ekonomi Terapan: Menerapkan teori ekonomi ke dalam kebijakan praktis (kebijakan fiskal, moneter, perbankan, dan pertanian)."
                        )
                    ),
                    MateriSection.Heading("Perbedaan Ekonomi Mikro vs Ekonomi Makro"),
                    MateriSection.Table(
                        headers = listOf("Pembeda", "Ekonomi Mikro", "Ekonomi Makro"),
                        rows = listOf(
                            listOf("Fokus Kajian", "Unit individual (konsumen, perusahaan, pasar spesifik)", "Agregat perekonomian menyeluruh (nasional/global)"),
                            listOf("Variabel Kunci", "Harga barang tertentu, biaya produksi, laba usaha", "Pendapatan nasional (PDB), inflasi, pengangguran"),
                            listOf("Tujuan Analisis", "Efisiensi alokasi sumber daya perusahaan/individu", "Stabilitas ekonomi, pertumbuhan, kesempatan kerja")
                        )
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Ekonomi Mikro", "Kajian perilaku unit ekonomi skala kecil."),
                    GlosariumItem("Ekonomi Makro", "Kajian kinerja perekonomian skala agregat/nasional.")
                )
            ),
            Subbab(
                id = "1.6",
                babId = 1,
                judul = "1.6 Dasar-Dasar Ekonomi Syariah",
                ringkasan = "Prinsip keadilan, larangan riba, gharar, maisir, akad muamalah, serta instrumen ZISWAF.",
                sections = listOf(
                    MateriSection.Heading("Prinsip Utama Ekonomi Syariah"),
                    MateriSection.Paragraph("Ekonomi syariah berlandaskan Al-Qur'an dan As-Sunnah dengan tujuan mewujudkan kemaslahatan umat (falah) serta keadilan distributif."),
                    MateriSection.HighlightBox(
                        HighlightType.WASPADA,
                        "Tiga Larangan Pokok dalam Transaksi Keuangan Syariah",
                        "1. Riba: Tambahan yang disyaratkan tanpa imbalan pengganti yang sah.\n2. Gharar: Ketidakjelasan, penipuan, atau spekulasi yang merugikan pihak lain.\n3. Maisir: Perjudian atau taruhan yang mengandalkan untung-untungan tanpa usaha produktif."
                    ),
                    MateriSection.Heading("Akad-Akad Muamalah Populer"),
                    MateriSection.Bullets(
                        listOf(
                            "Murabahah: Akad jual beli dengan menyatakan harga perolehan dan margin keuntungan yang disepakati bersama.",
                            "Mudharabah: Kerja sama modal di mana pemilik modal (shahibul mal) menyediakan 100% dana, dan pengelola (mudharib) mengoperasikan usaha; laba dibagi bagi hasil.",
                            "Musyarakah: Kemitraan modal di mana kedua belah pihak sama-sama menyetorkan modal dan menanggung risiko bersama secara proporsional."
                        )
                    ),
                    MateriSection.Heading("Instrumen ZISWAF"),
                    MateriSection.Paragraph("Zakat, Infak, Sedekah, dan Wakaf (ZISWAF) berfungsi sebagai instrumen filantropi sosial untuk mengentaskan kemiskinan dan meratakan distribusi kekayaan dalam masyarakat.")
                ),
                glosarium = listOf(
                    GlosariumItem("Riba", "Penetapan bunga atau kelebihan pengembalian utang yang dilarang syariat."),
                    GlosariumItem("Gharar", "Ketidakpastian atau kerancuan dalam transaksi."),
                    GlosariumItem("Maisir", "Praktik spekulasi judi atau taruhan untung-untungan.")
                )
            )
        )
    )

    val bab2 = Bab(
        id = 2,
        semester = 1,
        judul = "Bab 2: Pelaku Kegiatan Ekonomi",
        deskripsi = "Mempelajari perilaku produsen, faktor produksi, saluran distribusi, teori konsumsi, serta Circular Flow Diagram.",
        subbabList = listOf(
            Subbab(
                id = "2.1",
                babId = 2,
                judul = "2.1 Produksi dan Teori Perilaku Produsen",
                ringkasan = "Faktor produksi, fungsi produksi, Law of Diminishing Marginal Returns, dan Break Even Point.",
                sections = listOf(
                    MateriSection.Heading("Faktor-Faktor Produksi dan Balas Jasanya"),
                    MateriSection.Table(
                        headers = listOf("Faktor Produksi", "Keterangan", "Balas Jasa Diterima"),
                        rows = listOf(
                            listOf("Sumber Daya Alam", "Lahan, air, tambang marmer Pangkep", "Sewa (Rent)"),
                            listOf("Tenaga Kerja", "Karyawan, buruh terampil, manajer", "Upah / Gaji (Wage)"),
                            listOf("Modal (Capital)", "Mesin, gedung, uang operasional", "Bunga Modal (Interest)"),
                            listOf("Kewirausahaan", "Keahlian memimpin dan memitigasi risiko", "Laba / Keuntungan (Profit)")
                        )
                    ),
                    MateriSection.Heading("Hukum Tambahan Hasil yang Semakin Menurun"),
                    MateriSection.Paragraph("The Law of Diminishing Marginal Returns (David Ricardo): Jika satu faktor produksi variabel (misal tenaga kerja) terus ditambah pada faktor produksi tetap (misal 1 hektar sawah), maka tambahan hasil (Marginal Product) awalnya naik, namun setelah titik tertentu akan menurun dan akhirnya bernilai negatif."),
                    MateriSection.Heading("Titik Impas (Break Even Point / BEP)"),
                    MateriSection.FormulaCard(
                        title = "Rumus BEP Unit",
                        formula = "BEP (Unit) = Biaya Tetap (FC) / (Harga Jual per Unit (P) - Biaya Variabel per Unit (VC))",
                        explanation = "Kondisi saat total pendapatan sama persis dengan total biaya (TR = TC), sehingga perusahaan tidak untung dan tidak rugi."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Diminishing Returns", "Hukum berkurangnya tambahan hasil produksi saat faktor variabel terus ditambah."),
                    GlosariumItem("Break Even Point", "Titik impas di mana pendapatan impas dengan pengeluaran.")
                )
            ),
            Subbab(
                id = "2.2",
                babId = 2,
                judul = "2.2 Distribusi dan Saluran Distribusi",
                ringkasan = "Konsep penyaluran barang dan jasa dari produsen ke konsumen, jenis saluran distribusi.",
                sections = listOf(
                    MateriSection.Heading("Pengertian dan Tujuan Distribusi"),
                    MateriSection.Paragraph("Distribusi adalah kegiatan menyalurkan barang dan jasa dari tempat produsen ke tangan konsumen akhir pada waktu, tempat, dan jumlah yang tepat."),
                    MateriSection.Heading("Saluran Distribusi"),
                    MateriSection.Bullets(
                        listOf(
                            "Distribusi Langsung: Produsen -> Konsumen (Contoh: Nelayan Pangkep menjual ikan segar langsung kepada pembeli di dermaga Maccini Baji).",
                            "Distribusi Semi Langsung: Produsen -> Toko/Outlet Resmi Milik Produsen -> Konsumen (Contoh: Toko kue khas milik produsen sendiri).",
                            "Distribusi Tidak Langsung: Produsen -> Agen/Grosir -> Pengecer (Retailer) -> Konsumen Akhir (Contoh: Pabrik semen Tonasa menyalurkan ke distributor, toko bangunan, lalu ke konsumen pembangun rumah)."
                        )
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Distribusi Langsung", "Penyaluran komoditas tanpa perantara pedagang."),
                    GlosariumItem("Grosir (Wholesaler)", "Pedagang perantara yang menjual dalam partai besar.")
                )
            ),
            Subbab(
                id = "2.3",
                babId = 2,
                judul = "2.3 Konsumsi dan Teori Perilaku Konsumen",
                ringkasan = "Pendekatan kardinal vs ordinal, Hukum Gossen I dan Hukum Gossen II.",
                sections = listOf(
                    MateriSection.Heading("Pendekatan Teori Konsumsi"),
                    MateriSection.Bullets(
                        listOf(
                            "Pendekatan Kardinal: Kepuasan konsumen (utility) dapat diukur secara kuantitatif dengan satuan util. Menggunakan konsep Marginal Utility (MU).",
                            "Pendekatan Ordinal: Kepuasan tidak dapat dihitung dengan angka pasti, melainkan dibandingkan melalui kurva indiferensi (Indifference Curve) dan garis anggaran (Budget Line)."
                        )
                    ),
                    MateriSection.Heading("Hukum Gossen I & II"),
                    MateriSection.HighlightBox(
                        HighlightType.INGAT,
                        "Hukum Gossen I (Hukum Kepuasan Menurun)",
                        "Jika pemenuhan suatu kebutuhan dilakukan terus-menerus, maka kenikmatan atau kepuasan tambahannya (Marginal Utility) mula-mula tinggi, namun lama-kelamaan akan semakin menurun sampai akhirnya mencapai titik jenuh."
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.CONTOH,
                        "Hukum Gossen II (Keseimbangan Kepuasan Beragam)",
                        "Manusia berusaha memenuhi berbagai macam kebutuhan hingga mencapai tingkat intensitas kepuasan yang sama (MU1/P1 = MU2/P2 = MUn/Pn)."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Utility", "Tingkat kepuasan atau kegunaan suatu barang bagi konsumen."),
                    GlosariumItem("Marginal Utility", "Tambahan kepuasan yang diperoleh dari konsumsi satu unit barang tambahan.")
                )
            ),
            Subbab(
                id = "2.4",
                babId = 2,
                judul = "2.4 Diagram Arus Melingkar (Circular Flow)",
                ringkasan = "Arus melingkar kegiatan ekonomi 2, 3, dan 4 sektor, serta konsep suntikan (injections) dan bocoran (leakages).",
                sections = listOf(
                    MateriSection.Heading("Peran Empat Pelaku Ekonomi Utama"),
                    MateriSection.Bullets(
                        listOf(
                            "Rumah Tangga Konsumen (RTK): Pemilik faktor produksi, penerima pendapatan, dan pembeli barang/jasa.",
                            "Rumah Tangga Produsen (RTP): Pengguna faktor produksi, penghasil barang/jasa, dan pembayar balas jasa.",
                            "Pemerintah (RTN): Pengatur kebijakan regulasi, pemungut pajak, pemberi subsidi, dan penyedia fasilitas publik.",
                            "Masyarakat Luar Negeri (MLN): Mitra transaksi ekspor, impor, penanaman modal asing, dan devisa."
                        )
                    ),
                    MateriSection.InteractiveDiagram(DiagramType.CIRCULAR_FLOW),
                    MateriSection.Heading("Suntikan (Injections) dan Bocoran (Leakages)"),
                    MateriSection.Paragraph("Dalam siklus makro ekonomi:\n- Bocoran (Leakages) adalah aliran keluar dari arus pendapatan: Tabungan (S) + Pajak (T) + Impor (M).\n- Suntikan (Injections) adalah penambahan aliran ke dalam arus pendapatan: Investasi (I) + Pengeluaran Pemerintah (G) + Ekspor (X).")
                ),
                glosarium = listOf(
                    GlosariumItem("Leakages", "Aliran pendapatan yang keluar dari siklus konsumsi barang domestik."),
                    GlosariumItem("Injections", "Aliran dana yang masuk memacu pendapatan perekonomian domestik.")
                )
            )
        )
    )

    val bab3 = Bab(
        id = 3,
        semester = 1,
        judul = "Bab 3: Mekanisme Pasar dan Struktur Pasar",
        deskripsi = "Konsep permintaan, penawaran, elastisitas harga, pembentukan harga keseimbangan, dan struktur pasar modern.",
        subbabList = listOf(
            Subbab(
                id = "3.1",
                babId = 3,
                judul = "3.1 Permintaan dan Penawaran",
                ringkasan = "Hukum permintaan dan penawaran, asumsi ceteris paribus, dan faktor determinan pergeseran kurva.",
                sections = listOf(
                    MateriSection.Heading("Hukum Permintaan"),
                    MateriSection.Paragraph("Jika harga suatu barang naik, maka jumlah barang yang diminta akan turun. Sebaliknya, jika harga turun, jumlah yang diminta akan naik, dengan asumsi faktor lain tetap (ceteris paribus). Hubungan harga dan kuantitas berbanding terbalik (kemiringan kurva negatif)."),
                    MateriSection.Heading("Hukum Penawaran"),
                    MateriSection.Paragraph("Jika harga suatu barang naik, maka jumlah barang yang ditawarkan produsen akan bertambah demi mengejar laba lebih besar. Sebaliknya, jika harga turun, jumlah yang ditawarkan akan berkurang. Hubungan harga dan kuantitas berbanding lurus (kemiringan kurva positif).")
                ),
                glosarium = listOf(
                    GlosariumItem("Ceteris Paribus", "Asumsi bahwa faktor-faktor lain di luar harga dianggap konstan atau tidak berubah."),
                    GlosariumItem("Slope Negatif", "Kemiringan kurva yang menurun dari kiri atas ke kanan bawah.")
                )
            ),
            Subbab(
                id = "3.2",
                babId = 3,
                judul = "3.2 Kurva dan Fungsi Permintaan dan Penawaran",
                ringkasan = "Menyusun fungsi linear permintaan dan penawaran, serta perbedaan pergerakan sepanjang kurva vs pergeseran kurva.",
                sections = listOf(
                    MateriSection.Heading("Bentuk Umum Fungsi Matematis"),
                    MateriSection.FormulaCard(
                        title = "Fungsi Permintaan & Penawaran",
                        formula = "Qd = a - bP    |    Qs = -c + dP",
                        explanation = "Qd memiliki koefisien harga negatif karena hukum permintaan, sedangkan Qs memiliki koefisien harga positif karena hukum penawaran."
                    ),
                    MateriSection.Heading("Pergerakan vs Pergeseran Kurva"),
                    MateriSection.Paragraph("1. Pergerakan sepanjang kurva (Movement along the curve): Disebabkan semata-mata oleh perubahan HARGA barang itu sendiri.\n2. Pergeseran seluruh kurva (Shift of the curve): Disebabkan oleh perubahan faktor BUKAN harga (seperti pendapatan masyarakat, selera, harga barang komplementer/substitusi, teknologi, ekspektasi masa depan).")
                ),
                glosarium = listOf(
                    GlosariumItem("Fungsi Permintaan", "Persamaan matematis yang menghubungkan jumlah permintaan dengan harga."),
                    GlosariumItem("Shift Curve", "Pergeseran kurva ke kanan atau kiri akibat variabel non-harga.")
                )
            ),
            Subbab(
                id = "3.3",
                babId = 3,
                judul = "3.3 Elastisitas Harga",
                ringkasan = "Menghitung elastisitas permintaan dan penawaran serta 5 kategori nilai elastisitas.",
                sections = listOf(
                    MateriSection.Heading("Konsep dan Rumus Elastisitas"),
                    MateriSection.FormulaCard(
                        title = "Rumus Koefisien Elastisitas",
                        formula = "Ed = (ΔQ / ΔP) × (P / Q)",
                        explanation = "Derajat kepekaan perubahan jumlah barang yang diminta akibat perubahan persentase harga."
                    ),
                    MateriSection.Table(
                        headers = listOf("Nilai Ed", "Kategori", "Arti Respon Konsumen", "Contoh Barang"),
                        rows = listOf(
                            listOf("Ed > 1", "Elastis", "%ΔQ > %ΔP (Sangat peka)", "Barang mewah, elektronik"),
                            listOf("Ed < 1", "Inelastis", "%ΔQ < %ΔP (Kurang peka)", "Beras, garam, obat resep"),
                            listOf("Ed = 1", "Elastis Uniter", "%ΔQ = %ΔP (Proporsional)", "Barang sekunder umum"),
                            listOf("Ed = 0", "Inelastis Sempurna", "Berapapun harga, Q tetap", "Obat penyelamat nyawa"),
                            listOf("Ed = ~", "Elastis Sempurna", "Pada harga P tertentu, Q tak terhingga", "Bahan bakar subsidi kuota bebas")
                        )
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Elastisitas", "Tingkat kepekaan kuantitas permintaan terhadap perubahan variabel harga.")
                )
            ),
            Subbab(
                id = "3.4",
                babId = 3,
                judul = "3.4 Keseimbangan Pasar dan Pergeseran Kurva",
                ringkasan = "Menghitung harga dan kuantitas keseimbangan (Qd = Qs) serta analisis kelebihan permintaan dan penawaran.",
                sections = listOf(
                    MateriSection.Heading("Syarat Keseimbangan Pasar (Equilibrium)"),
                    MateriSection.Paragraph("Keseimbangan pasar tercapai saat jumlah yang diminta oleh pembeli sama persis dengan jumlah yang ditawarkan oleh penjual pada tingkat harga tertentu (Qd = Qs)."),
                    MateriSection.InteractiveDiagram(DiagramType.MARKET_EQUILIBRIUM),
                    MateriSection.Heading("Contoh Soal Hitungan Keseimbangan"),
                    MateriSection.FormulaCard(
                        title = "Contoh Perhitungan Qd = 200 - 2P dan Qs = -40 + 4P",
                        formula = "200 - 2P = -40 + 4P  =>  240 = 6P  =>  P = 40\nQ = 200 - 2(40)  =>  Q = 120 unit",
                        explanation = "Harga keseimbangan adalah Rp40 dan jumlah keseimbangan pasar adalah 120 unit."
                    ),
                    MateriSection.HighlightBox(
                        HighlightType.CONTOH,
                        "Analisis Ketidakseimbangan",
                        "Jika harga ditetapkan di atas Rp40 (misal P=50), maka Qs = 160 sedangkan Qd = 100, terjadi kelebihan penawaran (surplus) 60 unit yang mendorong harga turun kembali menuju titik ekuilibrium."
                    )
                ),
                glosarium = listOf(
                    GlosariumItem("Ekuilibrium", "Kondisi stabil di mana kekuatan permintaan dan penawaran seimbang."),
                    GlosariumItem("Excess Supply", "Kondisi surplus barang di pasar akibat harga berada di atas ekuilibrium.")
                )
            ),
            Subbab(
                id = "3.5",
                babId = 3,
                judul = "3.5 Struktur Pasar dan Pengaruh IPTEK",
                ringkasan = "Pasar persaingan sempurna, monopoli, oligopoli, monopolistik, serta transformasi e-commerce di era digital.",
                sections = listOf(
                    MateriSection.Heading("Empat Macam Struktur Pasar"),
                    MateriSection.Table(
                        headers = listOf("Struktur Pasar", "Jumlah Penjual", "Sifat Barang", "Kekuasaan Harga"),
                        rows = listOf(
                            listOf("Persaingan Sempurna", "Sangat banyak", "Homogen (seragam)", "Price taker (tidak ada daya harga)"),
                            listOf("Monopoli", "Hanya satu", "Unik, tanpa substitusi dekat", "Price maker (penentu harga mutlak)"),
                            listOf("Oligopoli", "Sedikit (beberapa)", "Homogen / terdiferensiasi", "Tinggi, saling mempengaruhi (interdependensi)"),
                            listOf("Monopolistik", "Cukup banyak", "Terdiferensiasi (merek/kemasan)", "Sedang, persaingan ketat di promosi")
                        )
                    ),
                    MateriSection.Heading("Pengaruh IPTEK dan E-Commerce"),
                    MateriSection.Paragraph("Perkembangan internet dan platform e-commerce memangkas asimetri informasi antara konsumen dan produsen, memperpendek rantai pasok (disintermediasi), serta memperluas pasar UMKM daerah hingga ke kancah global.")
                ),
                glosarium = listOf(
                    GlosariumItem("Price Taker", "Produsen yang menerima harga pasar tanpa kemampuan mengubahnya."),
                    GlosariumItem("Disintermediasi", "Pemotongan rantai perantara dalam distribusi digital.")
                )
            )
        )
    )
}
