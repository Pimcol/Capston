package org.techtown.mapcreate;

public class Database {
    public String Gas;
    public String GasStation;
    public double Lat;
    public double Lng;
    public String address;
    public int diesel;
    public int gasoilne;

    public Database()   {

    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDiesel() {
        return diesel;
    }

    public void setDiesel(int diesel) {
        this.diesel = diesel;
    }

    public int getGasoilne() {
        return gasoilne;
    }

    public void setGasoilne(int gasoilne) {
        this.gasoilne = gasoilne;
    }

    public Database(String Gas, String GasStation, int Lat, int Lng, String address, int diesel, int gasoilne) {
        this.Gas = Gas;
        this.GasStation = GasStation;
        this.Lat = Lat;
        this.Lng = Lng;
        this.address = address;
        this.diesel = diesel;
        this.gasoilne = gasoilne;
    }
}
