package dataBis;

public final class BusVIP extends Bus {
    private boolean pemandu;
    private boolean wifi;

    public BusVIP(String nama, int kapasitas, int hargaSewa, int jumlahUnit, boolean pemandu, boolean wifi) {
        super(nama, kapasitas, hargaSewa, jumlahUnit);
        this.pemandu = pemandu;
        this.wifi = wifi;
    }

    public boolean isPemandu() {
        return pemandu;
    }

    public void setPemandu(boolean pemandu) {
        this.pemandu = pemandu;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String info() {
        return String.format("%-6s%-15s%-15d%-15d%-15d%-15s%-15s%n", "", getNama(), getKapasitas(), getHargaSewa(), getJumlahUnit(), (isPemandu() ? "Ya" : "Tidak"), (isWifi() ? "Ya" : "Tidak"));
    }
}