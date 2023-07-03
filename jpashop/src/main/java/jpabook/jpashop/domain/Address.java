package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable     //내장타입선언
@Getter
public class Address {

    private String city;        //어느 도시?
    private String street;      //어느 거리?
    private String zipcode;     //그건머임?

    protected Address(){
    }
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
