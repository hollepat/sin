package cvut.fel.model;


import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    /*
    The @JoinTable annotation in JPA is used to define the association
    table when mapping a many-to-many relationship between entities.
    It specifies the name of the join table and the columns used for
    the association.
     */
    @ManyToMany
    @JoinTable(
            name = "library_book",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @NonNull
    private List<Book> books;

    @Embedded
    @NonNull
    private Address address;

    public Library() {

    }

    public boolean containsBook(Book book) {
        return books.contains(book);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
