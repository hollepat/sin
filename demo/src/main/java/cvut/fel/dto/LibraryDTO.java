package cvut.fel.dto;

import cvut.fel.entity.Address;
import cvut.fel.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LibraryDTO extends AbstractDTO {

    private AddressDTO address;

    public LibraryDTO() {
    }

    /*
    DTO should be simple object without methods, only holding data.
     */

}
