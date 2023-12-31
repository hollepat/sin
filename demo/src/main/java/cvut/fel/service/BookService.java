package cvut.fel.service;

import cvut.fel.dto.BookDTO;
import cvut.fel.entity.Book;

public interface BookService {

    /*
    * A service in the context of software architecture typically refers to a layer
    * that encapsulates the business logic or operations performed by an application.
    * It acts as an intermediary between the presentation layer (e.g., user interface)
    * and the data access layer (e.g., database).
    * In a typical application with a layered architecture (like MVC - Model-View-Controller),
    * services play a crucial role:
    */

    Book findById(Long id);

    Boolean createBook(BookDTO bookDTO);
}
