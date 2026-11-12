# Prompt Lengkap Aplikasi EKONOMIKU

Prompt siap tempel (copy-paste) ke Claude Code, Google AI Studio, atau Cursor untuk membangun aplikasi Android Ekonomi Kelas X SMAN 1 Pangkep, sesuai versi terbaru proyek EKONOMIKU. Ganti nama guru atau sekolah bila perlu; selebihnya bisa dipakai apa adanya.

## 1. Peran, identitas, dan tujuan

Anda adalah developer Android senior sekaligus spesialis pendidikan digital. Bantu saya, Nur Halim, S.Pd., Gr. (Guru Ekonomi SMAN 1 Pangkajene dan Kepulauan), membangun aplikasi Android native bernama EKONOMIKU untuk pembelajaran Ekonomi Kelas X (Fase E, Kurikulum Merdeka). Bangun proyek yang lengkap, langsung bisa di-build di Android Studio, dan jalankan semua pemeriksaan yang bisa Anda lakukan sebelum menyerahkan hasilnya.

| Item | Nilai |
| --- | --- |
| Nama aplikasi | EKONOMIKU - Ekonomi Kelas X Interaktif |
| Sekolah | SMAN 1 Pangkajene dan Kepulauan (SMANSA PANGKEP) |
| Guru pengampu | Nur Halim, S.Pd., Gr. |
| Kepala sekolah | Syamsul Ardi, S.Pd., M.Pd. |
| Wali kelas | XI Cermat |
| Pengguna | Siswa SMA kelas X, usia 15-17 tahun |
| Platform | Android native, minSdk 24 (Android 7.0), targetSdk 36 |
| Bahasa antarmuka | Bahasa Indonesia |

Tujuan aplikasi:

1. Siswa belajar mandiri, terstruktur, dan menarik, tanpa kuota internet.
2. Seluruh materi, diagram, bank soal, dan LKPD tersimpan lokal (offline penuh).
3. Siswa berlatih lewat bank soal pilihan ganda dengan umpan balik dan pembahasan seketika.
4. Guru membagikan LKPD digital dengan mudah dan menerima hasil kerja siswa.
5. Kemajuan belajar terlacak lewat rekap nilai, XP, level, dan lencana (gamifikasi).
6. Data siswa hanya tersimpan di HP masing-masing; tidak ada server dan tidak ada izin internet.

## 2. Teknologi, desain, dan struktur proyek

**Teknologi dan arsitektur**

- Bahasa Kotlin, UI Jetpack Compose dengan Material Design 3, arsitektur MVVM (satu `EkonomiViewModel` memakai StateFlow).
- Database lokal Room (tabel User, HasilLatihan, Bookmark, LkpdSubmission). Pengaturan (mode gelap, ukuran teks, notifikasi, jam notifikasi) disimpan di SharedPreferences agar tidak hilang saat aplikasi ditutup.
- Navigasi berbasis tumpukan layar sederhana di ViewModel dengan `BackHandler`, plus bottom navigation.
- Pembaca PDF memakai `PdfRenderer` bawaan Android (tanpa library tambahan).
- Pengingat harian memakai WorkManager. Coroutines dan StateFlow untuk proses asinkron.
- Dependensi seperlunya saja: Compose BOM, Material3 dan icons extended, Lifecycle, Room (KSP), WorkManager, Coroutines. Jangan menambah Firebase, Retrofit, atau library jaringan lain.
- Build: Gradle Kotlin DSL, version catalog `libs.versions.toml`, wrapper Gradle disertakan. Build debug harus berjalan tanpa keystore; tanda tangan release bersifat opsional lewat variabel lingkungan KEYSTORE\_PATH, STORE\_PASSWORD, KEY\_PASSWORD.

**Desain**

- Warna utama #1976D2 (biru), aksen #FFC107 (amber), latar #FFFFFF (terang) dan #121212 (gelap). Dukung mode terang dan gelap.
- Kartu elevasi 4dp, sudut membulat 8dp, ikon Material Icons, font Roboto atau bawaan sistem.
- Header bermerek SMANSA dengan logo sekolah (file `logo_smansa.png` yang saya sediakan) di splash dan halaman utama.
- Animasi transisi halus (Crossfade), target nyaman di HP RAM 2GB, ukuran APK di bawah 50 MB.
- Aksesibilitas: contentDescription pada ikon, kontras warna memadai, ukuran sentuh minimal 48dp, ukuran teks dapat diubah (Kecil 0,9x, Normal 1,0x, Besar 1,15x).

**Struktur proyek (package `com.example`)**

```
app/src/main/
  java/com/example/
    MainActivity.kt                 # entry point, bottom nav, back handler, izin notifikasi
    data/model/                     # User, MateriModels (Bab, Subbab, Soal), HasilLatihan, Bookmark, LkpdSubmission
    data/local/                     # AppDatabase, Daos, AppPreferences
    data/repository/                # EkonomiRepository, MateriData(+Semester1/2), SoalData, LkpdData, BadgeData
    notification/ReminderScheduler.kt
    util/LkpdDownloader.kt
    ui/{splash,home,materi,soal,lkpd,rekap,profil,games,components,navigation,theme,viewmodel}/
  assets/lkpd/                      # PDF LKPD
  res/drawable/logo_smansa.png, res/values/strings.xml
```

## 3. Struktur materi (6 bab, 2 semester)

Semua materi ditulis langsung di kode (data class), tanpa internet. Setiap subbab punya ringkasan, contoh nyata (konteks Pangkep bila relevan), tabel atau rumus, dan kotak highlight berwarna: Tahukah Kamu, Ingat, Waspada, Contoh, Analogi. Setiap bab punya glosarium istilah yang bisa diklik. Beberapa subbab memuat diagram yang digambar dengan Compose Canvas (Circular Flow, PPF, Piramida Maslow, kurva Permintaan-Penawaran, Piramida Keuangan, alur QRIS, alur Gadai).

| Bab | Judul | Semester | Subbab |
| --- | --- | --- | --- |
| 1 | Konsep Ilmu Ekonomi | Ganjil | 1.1 Pengertian Ilmu Ekonomi; 1.2 Kebutuhan dan Alat Pemuas Kebutuhan; 1.3 Kelangkaan dan Masalah Pokok Ekonomi; 1.4 Skala Prioritas dan Biaya Peluang; 1.5 Pembagian Ilmu Ekonomi; 1.6 Dasar-Dasar Ekonomi Syariah |
| 2 | Pelaku Kegiatan Ekonomi | Ganjil | 2.1 Produksi dan Teori Perilaku Produsen; 2.2 Distribusi dan Saluran Distribusi; 2.3 Konsumsi dan Teori Perilaku Konsumen; 2.4 Diagram Arus Melingkar |
| 3 | Mekanisme Harga Pasar dan Struktur Pasar | Ganjil | 3.1 Permintaan dan Penawaran; 3.2 Kurva dan Fungsi Permintaan dan Penawaran; 3.3 Elastisitas Harga; 3.4 Keseimbangan Pasar dan Pergeseran Kurva; 3.5 Struktur Pasar dan Pengaruh IPTEK |
| 4 | Bank Sentral dan Sistem Pembayaran | Genap | 4.1 Bank Sentral (Bank Indonesia); 4.2 Sistem Pembayaran di Indonesia; 4.3 Alat Pembayaran Tunai dan Non-Tunai |
| 5 | OJK dan Lembaga Keuangan | Genap | 5.1 OJK; 5.2 Perbankan di Indonesia; 5.3 Pasar Modal dan Investasi; 5.4 Lembaga Keuangan Non-Bank |
| 6 | Risiko dan Keuangan Pribadi | Genap | 6.1 Risiko dalam Ekonomi dan Investasi; 6.2 Manajemen Risiko dan Kejahatan Keuangan; 6.3 Perencanaan dan Laporan Keuangan Pribadi |

Konten wajib mencakup, antara lain: oikos dan nomos, hierarki kebutuhan Maslow, kelangkaan dan tiga masalah pokok ekonomi, biaya peluang dan PPF, ekonomi mikro dan makro, riba, gharar, maisir, akad syariah dan ZISWAF; faktor produksi dan balas jasanya, Hukum Diminishing Returns, BEP, Hukum Gossen I dan II, bocoran dan suntikan; fungsi Qd dan Qs, elastisitas, keseimbangan (contoh Qd = 200 - 2P dan Qs = -40 + 4P menghasilkan P = 40 dan Q = 120), struktur pasar; tiga pilar tugas BI, BI-Rate, BI-FAST, BI-RTGS, SKNBI, QRIS, metode 3D keaslian rupiah; peran OJK, prinsip 5C, LPS (Rp2 miliar dan syarat 3T), saham, obligasi, sukuk, reksa dana, asuransi, dana pensiun, pegadaian; risiko sistematis dan non-sistematis, risk-return tradeoff, investasi bodong dan pinjol ilegal, neraca dan arus kas pribadi, rasio keuangan sehat.

## 4. Fitur utama

**Splash dan Home**

- Splash 2 detik (otomatis ke Home): logo SMANSA, nama EKONOMIKU, subjudul "Ekonomi Kelas X Interaktif", nama sekolah, dan nama guru.
- Home: sapaan "Halo, \[Nama Siswa\]!", banner gamifikasi (XP, level, progres), lima menu utama (Materi, Latihan Soal, LKPD, Rekap Nilai, Profil), akses ke Lab Interaktif, dan progres belajar. Bottom navigation: Home, Materi, Soal, LKPD, Rekap, Profil.

**Materi**

- Alur: pilih semester (Ganjil atau Genap), pilih bab, pilih subbab, lalu baca konten.
- Konten kaya: judul, teks tebal, bullet, tabel, kartu rumus, kotak highlight berwarna, diagram Canvas, dan glosarium yang bisa diklik.
- Tombol navigasi Sebelumnya, Daftar Isi, Berikutnya. Bookmark subbab favorit. Pencarian kata kunci di seluruh materi.
- Membaca subbab memberi +20 XP (sekali per subbab).

**Latihan Soal**

- 25 soal pilihan ganda per bab (total 150), 5 opsi A-E, urutan soal diacak setiap latihan dimulai.
- Timer 60 detik per soal, dapat dinonaktifkan. Tombol Lewati dan Jawab.
- Setelah menjawab: umpan balik Benar (hijau) atau Salah (merah) beserta kunci dan pembahasan singkat.
- Hasil akhir: skor (benar/25), persentase, predikat (Sangat Baik 85% ke atas, Baik 70%, Cukup 55%, Perlu Belajar Lagi di bawah itu), jumlah benar dan salah, waktu pengerjaan.
- Tombol Ulangi Latihan dan Lihat Pembahasan Lengkap. Hasil disimpan ke Room.

**LKPD**

- Enam LKPD berstudi kasus nyata Pangkep: (1) Skala Prioritas dan Biaya Peluang, (2) Circular Flow Usaha Bandeng Pangkep, (3) Mekanisme Harga dan Keseimbangan Pasar, (4) Pembayaran Digital dan QRIS (observasi kantin sekolah), (5) OJK dan Pengawasan Jasa Keuangan, (6) Perencanaan Keuangan dan Neraca Pribadi.
- Tiap LKPD: petunjuk pengerjaan, kolom identitas siswa (nama, kelas, tanggal), soal esai atau analisis kasus, kolom isian interaktif dengan simpan draf, dan rubrik penilaian untuk guru.
- Tombol Buka PDF (viewer internal berbasis PdfRenderer, navigasi halaman) dan tombol Unduh yang menyimpan PDF ke folder Download (MediaStore di Android 10 ke atas, izin WRITE\_EXTERNAL\_STORAGE hanya sampai Android 9).
- Tombol Kumpulkan membagikan hasil lewat WhatsApp atau Google Classroom (share intent teks). Menyelesaikan LKPD memberi +50 XP.

**Rekap Nilai**

- Tabel riwayat: Tanggal, Bab, Skor, Persentase, Predikat. Grafik progres nilai per bab. Filter per bab.
- Tombol Ekspor Rekap membagikan kartu nilai sebagai teks kepada guru atau orang tua.

**Profil dan Pengaturan**

- Nama siswa (diisi saat pertama membuka aplikasi), kelas (X, XI, XII), avatar, informasi guru dan sekolah, daftar lencana.
- Pengaturan: mode gelap, ukuran teks, pengingat belajar harian beserta pilihan jam (06:00, 12:00, 16:00, 19:00, 20:00, 21:00).
- Tombol Reset Data (dengan dialog konfirmasi) dan Tentang Aplikasi (versi, pengembang, kontak).

## 5. Gamifikasi, lab interaktif, dan notifikasi

**XP dan level**

| Aktivitas | XP |
| --- | --- |
| Membaca satu subbab | +20 |
| Jawaban benar di latihan soal | +10 per nomor |
| Menyelesaikan LKPD | +50 |
| Menyelesaikan simulasi pasar | +30 |

| Level | Nama | Rentang XP |
| --- | --- | --- |
| 1 | Calon Ekonom Pemula | 0 - 100 |
| 2 | Pembelajar Aktif | 101 - 300 |
| 3 | Pengamat Pasar Cermat | 301 - 600 |
| 4 | Analis Ekonomi Muda | 601 - 1000 |
| 5 | Master Ekonomi SMANSA | 1001 ke atas |

Tampilkan dialog perayaan saat naik level atau membuka lencana baru.

**Tujuh lencana prestasi**: Langkah Awal, Kutu Buku Ekonomi, Penembak Jitu (skor 100%), Pakar Mekanisme Pasar, Pelindung Finansial, Cendekia LKPD, dan Master Ekonomi SMANSA. Tentukan syarat tiap lencana yang masuk akal (misalnya Pakar Mekanisme Pasar untuk skor tinggi di Bab 3, Pelindung Finansial untuk Bab 5 atau 6) dan tampilkan di Profil.

**Lab Interaktif (mini game)**

- Simulasi Keseimbangan Pasar: siswa menggeser slider harga P dan melihat jumlah diminta (Qd = 200 - 2P) dan ditawarkan (Qs = -40 + 4P), kelebihan permintaan atau penawaran, hingga menemukan titik keseimbangan Rp40 dan 120 unit.
- Detektor Fraud dan Anti-Pinjol: siswa menilai skenario penawaran investasi atau pinjaman (resmi OJK dengan prinsip 2L Legal dan Logis, atau penipuan, Ponzi, pinjol ilegal), lalu mendapat umpan balik.

**Pengingat belajar harian**

- Notifikasi lokal 1x sehari berjudul "Waktunya latihan soal!" memakai WorkManager (PeriodicWorkRequest dengan initial delay menuju jam pilihan), tetap berjalan setelah aplikasi ditutup dan HP di-restart.
- Jam dapat diatur di Profil. Minta izin POST\_NOTIFICATIONS di Android 13 ke atas dan lewati notifikasi dengan tenang bila izin ditolak. Mengetuk notifikasi membuka aplikasi.

## 6. Data soal, database, izin, dan kualitas

**Bank soal (wajib tepat 150)**

Simpan di `SoalData.kt` sebagai `soalBab1` sampai `soalBab6`, masing-masing 25 objek `Soal`, dan sediakan `getSoalByBab(babId)`.

```kotlin
data class Soal(
    val id: Int,            // babId*100 + nomor, misalnya 101..125, 201..225
    val babId: Int,
    val nomorSoal: Int,     // 1..25 berurutan
    val pertanyaan: String,
    val opsi: List<String>, // tepat 5 opsi, A sampai E, tidak ada yang kembar
    val jawabanBenar: Int,  // 0=A, 1=B, 2=C, 3=D, 4=E
    val pembahasan: String  // 1-2 kalimat, menjelaskan mengapa jawabannya benar
)
```

Aturan isi soal:

- Soal sesuai isi materi bab, bervariasi (definisi, contoh kasus, hitungan, penalaran). Soal hitungan harus benar secara matematis dan dicek ulang.
- Posisi kunci jawaban tersebar merata di A sampai E, jangan didominasi satu huruf. Hindari opsi "semua benar" atau "A dan B" karena urutan soal diacak.
- Pengecoh masuk akal, bukan asal-asalan. Tanpa tanda kutip ganda atau simbol dolar di dalam teks.
- Sertakan unit test yang memastikan: 6 bab, 25 soal per bab, id unik, 5 opsi unik, kunci 0 sampai 4, pembahasan tidak kosong.

**Database Room**

| Tabel | Isi utama |
| --- | --- |
| User | id, nama, kelas, avatarId, XP, level, lencana terbuka, tanggal daftar |
| HasilLatihan | userId, bab, judulBab, skor, totalSoal, persentase, predikat, tanggal, waktuDetik |
| Bookmark | babId, subbabId, judulBab, judulSubbab, tanggal |
| LkpdSubmission | babId, jawaban isian siswa, status, tanggal simpan |

**Izin dan privasi**

- Hanya POST\_NOTIFICATIONS (Android 13+) dan WRITE\_EXTERNAL\_STORAGE dengan `maxSdkVersion="28"`. Tidak ada izin INTERNET.
- Semua data siswa (nama, nilai, XP) tersimpan lokal; tidak ada pengiriman ke server mana pun.

**Kualitas**

- Offline-first, penanganan error (misalnya PDF gagal dimuat tampil pesan ramah), status loading, daftar memakai LazyColumn.
- Kode Kotlin rapi, tanpa warning berarti, nama dalam Bahasa Indonesia untuk teks tampilan dan Bahasa Inggris untuk identifier.
- Jalankan pengecekan semampu lingkungan Anda (build, unit test, atau minimal pengecekan sintaks). Jika build tidak mungkin dijalankan, katakan terus terang apa yang belum terverifikasi.

## 7. Output, fase kerja, dan checklist

**Urutan pengerjaan**

1. Fase 1 (MVP): Splash, Home, Materi (satu bab lengkap), Latihan Soal dengan hasil tersimpan.
2. Fase 2: LKPD (daftar, form isian, viewer PDF, unduh) dan Rekap Nilai.
3. Fase 3: Bookmark, pencarian, mode gelap, ukuran teks, notifikasi harian.
4. Fase 4: Lengkapi enam bab, 150 soal, gamifikasi, dan Lab Interaktif.

Kerjakan berurutan, pastikan tiap fase tidak merusak fase sebelumnya, dan beri ringkasan singkat di akhir tiap fase.

**Bahan yang saya sediakan**: logo SMANSA (PNG), empat file PDF LKPD (taruh di `assets/lkpd/`), dan materi bila ada. Bila materi belum lengkap, susun dari pengetahuan umum yang akurat sesuai Kurikulum Merdeka Fase E dan tandai bagian yang perlu saya tinjau.

**Hasil akhir yang saya minta**

- Proyek Gradle lengkap (zip) yang bisa dibuka langsung di Android Studio, termasuk `gradlew`.
- README.md berisi cara build APK debug dan release, daftar izin, cara menambah materi dan soal, serta troubleshooting.
- Ringkasan jujur: apa yang sudah diverifikasi dan apa yang belum (misalnya Gradle sync atau tampilan di perangkat).

**Checklist sebelum menyerahkan**

- [ ] Build debug berjalan tanpa keystore dan tanpa google-services.json
- [ ] Tepat 150 soal, 25 per bab, kunci tersebar A sampai E, unit test lulus
- [ ] Semua hitungan pada soal dan materi sudah dicek ulang
- [ ] Pengaturan (mode gelap, ukuran teks, notifikasi) tetap tersimpan setelah aplikasi ditutup
- [ ] Notifikasi harian tampil pada jam pilihan dan izin Android 13+ ditangani
- [ ] Tombol Buka dan Unduh LKPD berfungsi; PDF yang bukan LKPD tidak ikut di assets
- [ ] Tidak ada izin INTERNET dan tidak ada dependensi jaringan
- [ ] Tampilan nyaman di mode terang dan gelap, serta teks Kecil, Normal, dan Besar
- [ ] README lengkap
