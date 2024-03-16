package dataBis;

public class Bus {
    private String nama, fasilitas;
    protected int kapasitas, hargaSewa, jumlahUnit;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public int getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(int jumlahUnit) {
        this.jumlahUnit = jumlahUnit;
    }
}
