package cvut.fel.dto;

import cvut.fel.model.Address;
import cvut.fel.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibraryDTO extends AbstractDTO {

    private Long id;
    private String name;
    private List<Long> books; // TODO: List<Long> books/ List<BookDTO> books (not List<Book> books)
    private Address address;

    public LibraryDTO(LibraryDTO libraryDTO) {
        super();
        id = libraryDTO.getId();
        name = libraryDTO.getName();
        books = libraryDTO.getBooks();
        address = libraryDTO.getAddress().clone();
    }

    /*
    In DTO we have methods for adding and removing books etc. It is
    a object to hold data between DBS and FE.
     */

    public void addBook(Long bookId) {
        books.add(bookId);
    }

    public boolean containsBook(Book book) {
        return books.contains(book);
    }


    @Override
    protected AbstractDTO clone() {
        return new LibraryDTO(this);
    }
}
