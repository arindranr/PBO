package dataBis;

public class BusRegular extends Bus {
    private boolean musik;

    public boolean isMusik() {
        return musik;
    }

    public void setMusik(boolean musik) {
        this.musik = musik;
    }

    @Override
    public String info() {
        return String.format("%-6s%-15s%-15d%-15d%-15d%-15s%n", "", getNama(), getKapasitas(), getHargaSewa(), getJumlahUnit(), (isMusik() ? "Ya" : "Tidak"));
    }

}

