package cvut.fel.repository;

import cvut.fel.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    /*
     * The repository pattern is a higher-level abstraction that provides a
     * more object-oriented and domain-driven way to interact with data storage.
     * It abstracts the logic for retrieving, storing, and managing domain objects,
     * providing a simple and consistent interface for accessing data.
     * A repository typically encapsulates data access logic related to a specific
     * domain entity or aggregate root. For example, you might have a UserRepository
     * that handles operations with DBS related to user entities.
     */

    List<Book> findByName(String name);

}
