package dataBis;

public class BusVIP extends Bus {
    private boolean pemandu;
    private boolean wifi;

    public boolean isPemandu() {
        return pemandu;
    }

    public void setPemandu(boolean pemandu) {
        this.pemandu = pemandu;
    }

    public boolean isWifi() {
        return this.wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
}
