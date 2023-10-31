package cvut.fel.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @Embedded  // allows us to import Address class as part of Publisher database object (in our case relational table)
    @NonNull
    private Address address;


    /*
    When you have a bidirectional relationship between
    entities, it means that each entity has a reference
    to the other entity. For example, in a one-to-many
    or many-to-one relationship, one entity references
    the other, and vice versa.

    In this case, the mappedBy attribute tells JPA that
    the publishedBooks field in the Publisher class is mapped by the
    publisher field in the Book class. This means that the
    Book class is the owner of the relationship, and the
    association is managed from the Book side.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher")
    @NonNull
    private List<Book> publishedBooks;

    @ManyToMany
    private List<Author> contracts;

    public Publisher() {

    }
}
