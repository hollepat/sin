package cvut.fel.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Data
public class Address {

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "streetNumber", nullable = false)
    private String streetNumber;

    public Address(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.streetNumber = address.getStreetNumber();
    }

    public Address() {

    }

    public Address clone() {
        return new Address(this);
    }
}
