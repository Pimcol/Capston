package org.techtown.mapcreate;

public class GasInfo {
    private String Gas;
    private String GasStation;
    private String address;
    private double Lat;
    private double Lng;
    private int gasoline;
    private int diesel;

    public GasInfo(){}

    public String getGas() {
        return Gas;
    }

    public void setGas(String gas) {
        Gas = gas;
    }

    public String getGasStation() {
        return GasStation;
    }

    public void setGasStation(String gasStation) {
        GasStation = gasStation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(int lat) {
        Lat = lat;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(int lng) {
        Lng = lng;
    }

    public int getGasoline() {
        return gasoline;
    }

    public void setGasoline(int gasoline) {
        this.gasoline = gasoline;
    }

    public int getDiesel() {
        return diesel;
    }

    public void setDiesel(int diesel) {
        this.diesel = diesel;
    }
}
