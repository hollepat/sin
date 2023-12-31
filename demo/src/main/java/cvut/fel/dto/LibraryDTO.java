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

    private List<Long> books; // TODO: List<Long> books/ List<BookDTO> books (not List<Book> books)
    private Address address;

    public LibraryDTO() {
    }

    /*
    DTO should be simple object without methods, only holding data.
     */

}
