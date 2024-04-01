package dataBis;

public class Bus {
    private String nama;
    protected int kapasitas, hargaSewa, jumlahUnit;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    // Method overloading 
    public String info() {
        return String.format("%-6s%-15s%-15d%-15d%-15d%-15s%n", "", nama, kapasitas, hargaSewa, jumlahUnit);
    }
}


