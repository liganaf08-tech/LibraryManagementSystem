public class Peminjaman {
    private String idPeminjaman;
    private Anggota anggota;
    private Buku buku;
    private boolean sudahKembali;

    public Peminjaman(String idPeminjaman, Anggota anggota, Buku buku) {
        this.idPeminjaman = idPeminjaman;
        this.anggota = anggota;
        this.buku = buku;
        this.sudahKembali = false;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public Buku getBuku() {
        return buku;
    }

    public boolean isSudahKembali() {
        return sudahKembali;
    }

    public void kembalikanBuku() {
        if (sudahKembali) {
            System.out.println("Buku sudah dikembalikan sebelumnya.");
            return;
        }

        buku.tambahStok();
        sudahKembali = true;
        System.out.println("Buku berhasil dikembalikan.");
    }

    public void tampilkanInfo() {
        String status = sudahKembali ? "Sudah kembali" : "Dipinjam";
        System.out.println("ID Pinjam: " + idPeminjaman
                + " | Anggota: " + anggota.getNama()
                + " | Buku: " + buku.getJudul()
                + " | Status: " + status);
    }
}
