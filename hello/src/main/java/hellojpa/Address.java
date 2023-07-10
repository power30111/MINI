package hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    String city;
    String zipcode;
    String street;

    public void Address(){
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
