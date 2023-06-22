package hb02.embadable;

import javax.persistence.Embeddable;

@Embeddable//we can embed this class in our different entities
public class Address {

    private String street;
    private String city;
    private String country;
    private String zipCOde;

    //getter and setter


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCOde() {
        return zipCOde;
    }

    public void setZipCOde(String zipCOde) {
        this.zipCOde = zipCOde;
    }

    // to String method()


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCOde='" + zipCOde + '\'' +
                '}';
    }
}
