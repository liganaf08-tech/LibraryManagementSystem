import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Perpustakaan perpus = new Perpustakaan();

        // Data awal untuk mencoba program
        perpus.tambahBuku(new Buku("B001", "Pemrograman Java", "Andi", 5));
        perpus.tambahBuku(new Buku("B002", "Basis Data", "Budi", 3));
        perpus.tambahAnggota(new Anggota("A001", "Mahasiswa"));

        int pilihan = -1;

        do {
            System.out.println("\n=== SISTEM PERPUSTAKAAN ===");
            System.out.println("1. Lihat Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Lihat Anggota");
            System.out.println("5. Tambah Anggota");
            System.out.println("6. Pinjam Buku");
            System.out.println("7. Kembalikan Buku");
            System.out.println("8. Riwayat Peminjaman");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());

                switch (pilihan) {
                    case 1:
                        perpus.tampilkanBuku();
                        break;
                    case 2:
                        System.out.print("ID buku: ");
                        String idBuku = input.nextLine();
                        System.out.print("Judul buku: ");
                        String judul = input.nextLine();
                        System.out.print("Penulis: ");
                        String penulis = input.nextLine();
                        System.out.print("Stok: ");
                        int stok = Integer.parseInt(input.nextLine());

                        if (idBuku.isBlank() || judul.isBlank() || penulis.isBlank()) {
                            System.out.println("Data tidak boleh kosong.");
                        } else if (stok < 0) {
                            System.out.println("Stok tidak boleh negatif.");
                        } else {
                            perpus.tambahBuku(new Buku(idBuku, judul, penulis, stok));
                        }
                        break;
                    case 3:
                        System.out.print("ID buku yang dihapus: ");
                        perpus.hapusBuku(input.nextLine());
                        break;
                    case 4:
                        perpus.tampilkanAnggota();
                        break;
                    case 5:
                        System.out.print("ID anggota: ");
                        String idAnggota = input.nextLine();
                        System.out.print("Nama anggota: ");
                        String nama = input.nextLine();

                        if (idAnggota.isBlank() || nama.isBlank()) {
                            System.out.println("Data tidak boleh kosong.");
                        } else {
                            perpus.tambahAnggota(new Anggota(idAnggota, nama));
                        }
                        break;
                    case 6:
                        System.out.print("ID anggota: ");
                        String idPeminjam = input.nextLine();
                        System.out.print("ID buku: ");
                        String idYangDipinjam = input.nextLine();
                        perpus.pinjamBuku(idPeminjam, idYangDipinjam);
                        break;
                    case 7:
                        System.out.print("ID peminjaman (contoh P1): ");
                        perpus.kembalikanBuku(input.nextLine());
                        break;
                    case 8:
                        perpus.tampilkanPeminjaman();
                        break;
                    case 0:
                        System.out.println("Program selesai. Terima kasih.");
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang benar.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
