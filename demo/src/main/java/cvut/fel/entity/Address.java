package cvut.fel.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Embeddable
@Getter @Setter @ToString
public class Address implements Serializable {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    public Address(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
    }

    public Address() {

    }

    public Address(String city, String street, String streetNumber) {
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}
