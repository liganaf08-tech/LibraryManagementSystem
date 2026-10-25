import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();
    private ArrayList<Anggota> daftarAnggota = new ArrayList<>();
    private ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        for (Buku b : daftarBuku) {
            if (b.getId().equalsIgnoreCase(buku.getId())) {
                System.out.println("ID buku sudah digunakan.");
                return;
            }
        }

        daftarBuku.add(buku);
        System.out.println("Buku berhasil ditambahkan.");
    }

    public void hapusBuku(String id) {
        Buku bukuDitemukan = null;

        for (Buku b : daftarBuku) {
            if (b.getId().equalsIgnoreCase(id)) {
                bukuDitemukan = b;
                break;
            }
        }

        if (bukuDitemukan == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        for (Peminjaman p : daftarPeminjaman) {
            if (p.getBuku() == bukuDitemukan && !p.isSudahKembali()) {
                System.out.println("Buku sedang dipinjam dan belum bisa dihapus.");
                return;
            }
        }

        daftarBuku.remove(bukuDitemukan);
        System.out.println("Buku berhasil dihapus.");
    }

    public void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada data buku.");
            return;
        }

        for (Buku b : daftarBuku) {
            b.tampilkanInfo();
        }
    }

    public void tambahAnggota(Anggota anggota) {
        for (Anggota a : daftarAnggota) {
            if (a.getId().equalsIgnoreCase(anggota.getId())) {
                System.out.println("ID anggota sudah digunakan.");
                return;
            }
        }

        daftarAnggota.add(anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public void tampilkanAnggota() {
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }

        for (Anggota a : daftarAnggota) {
            a.tampilkanInfo();
        }
    }

    public void pinjamBuku(String idAnggota, String idBuku) {
        Anggota anggotaDitemukan = null;
        Buku bukuDitemukan = null;

        for (Anggota a : daftarAnggota) {
            if (a.getId().equalsIgnoreCase(idAnggota)) {
                anggotaDitemukan = a;
                break;
            }
        }

        for (Buku b : daftarBuku) {
            if (b.getId().equalsIgnoreCase(idBuku)) {
                bukuDitemukan = b;
                break;
            }
        }

        if (anggotaDitemukan == null) {
            System.out.println("Anggota tidak ditemukan.");
            return;
        }

        if (bukuDitemukan == null) {
            System.out.println("Buku tidak ditemukan.");
            return;
        }

        if (bukuDitemukan.getStok() <= 0) {
            System.out.println("Stok buku habis.");
            return;
        }

        bukuDitemukan.kurangiStok();

        String idPinjam = "P" + (daftarPeminjaman.size() + 1);
        Peminjaman peminjaman = new Peminjaman(
                idPinjam, anggotaDitemukan, bukuDitemukan);

        daftarPeminjaman.add(peminjaman);
        System.out.println("Peminjaman berhasil. ID: " + idPinjam);
    }

    public void kembalikanBuku(String idPinjam) {
        for (Peminjaman p : daftarPeminjaman) {
            if (p.getIdPeminjaman().equalsIgnoreCase(idPinjam)) {
                p.kembalikanBuku();
                return;
            }
        }

        System.out.println("Data peminjaman tidak ditemukan.");
    }

    public void tampilkanPeminjaman() {
        if (daftarPeminjaman.isEmpty()) {
            System.out.println("Belum ada transaksi peminjaman.");
            return;
        }

        for (Peminjaman p : daftarPeminjaman) {
            p.tampilkanInfo();
        }
    }
}
