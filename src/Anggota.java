public class Anggota {
    private String id;
    private String nama;

    public Anggota(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanInfo() {
        System.out.println("ID Anggota: " + id + " | Nama: " + nama);
    }
}
