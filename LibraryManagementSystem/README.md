# Library Management System

Program perpustakaan sederhana menggunakan Java untuk tugas mata kuliah Pemrograman Berorientasi Objek (PBO).

## Fitur
- Melihat, menambah, dan menghapus buku
- Melihat dan menambah anggota
- Peminjaman dan pengembalian buku
- Riwayat peminjaman

## Konsep PBO
- Class dan Object: Buku, Anggota, Peminjaman, Perpustakaan
- Encapsulation: atribut menggunakan `private`
- Inheritance: `Buku` mewarisi `ItemPerpustakaan`
- Abstraction: `ItemPerpustakaan` adalah abstract class
- Polymorphism: `Buku` mengimplementasikan `tampilkanInfo()`

## Cara menjalankan
Pastikan Java JDK sudah terpasang. Buka terminal pada folder utama proyek, lalu jalankan:

```bash
javac -d out src/*.java
java -cp out Main
```

Data disimpan sementara di memori. Saat program ditutup, data tambahan akan hilang dan data contoh akan dimuat kembali.

## Upload ke GitHub
Buat repository kosong bernama `LibraryManagementSystem`, lalu jalankan dari folder proyek:

```bash
git init
git add .
git commit -m "Membuat sistem perpustakaan Java"
git branch -M main
git remote add origin https://github.com/USERNAME/LibraryManagementSystem.git
git push -u origin main
```

Ganti `USERNAME` dengan username GitHub sendiri.
