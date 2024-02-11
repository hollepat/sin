package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {
    private String city;
    private String street;
    private String streetNumber;
}
