public class Buku extends ItemPerpustakaan {
    private String penulis;

    public Buku(String id, String judul, String penulis, int stok) {
        super(id, judul, stok);
        this.penulis = penulis;
    }

    public String getPenulis() {
        return penulis;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID: " + getId()
                + " | Judul: " + getJudul()
                + " | Penulis: " + penulis
                + " | Stok: " + getStok());
    }
}
