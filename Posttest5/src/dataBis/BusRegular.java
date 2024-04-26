package dataBis;

public class BusRegular extends Bus {
    private boolean musik;

    public BusRegular(String nama, int kapasitas, int hargaSewa, int jumlahUnit, boolean musik) {
        super(nama, kapasitas, hargaSewa, jumlahUnit);
        this.musik = musik;
    }

    public boolean isMusik() {
        return musik;
    }

    public void setMusik(boolean musik) {
        this.musik = musik;
    }

    @Override
    public final String info() {
        return String.format("%-6s%-15s%-15d%-15d%-15d%-15s%n", "", getNama(), getKapasitas(), getHargaSewa(), getJumlahUnit(), (isMusik() ? "Ya" : "Tidak"));
    }
}
