package cvut.fel.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Library extends AbstractEntity{

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
    private List<Book> books;

    @Embedded
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
