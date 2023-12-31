package cvut.fel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Embeddable
@Getter @Setter
public class Address implements Serializable, Cloneable {

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

    @Override
    public Address clone() {
        return new Address(this);
    }
}
