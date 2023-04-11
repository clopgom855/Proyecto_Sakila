package entidades;

import java.sql.Timestamp;

public class City {
     private int cityId;
    private String city;
    private int countryId;
    private Timestamp lastUpdate;
    
    public City(int cityId, String city, int countryId, Timestamp lastUpdate) {
        this.cityId = cityId;
        this.city = city;
        this.countryId = countryId;
        this.lastUpdate = lastUpdate;
    }
    
    public int getCityId() {
        return cityId;
    }
    
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public int getCountryId() {
        return countryId;
    }
    
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
