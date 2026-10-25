public abstract class ItemPerpustakaan {
    private String id;
    private String judul;
    private int stok;

    public ItemPerpustakaan(String id, String judul, int stok) {
        this.id = id;
        this.judul = judul;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok > 0) {
            stok--;
        }
    }

    public void tambahStok() {
        stok++;
    }

    public abstract void tampilkanInfo();
}
