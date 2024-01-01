package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter @Setter @ToString
public class Publisher extends AbstractEntity {


    @Embedded  // allows us to import Address class as part of Publisher database object (in our case relational table)
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
    private List<Book> publishedBooks;

    @ManyToMany
    private List<Author> contracts;

    public Publisher() {

    }

    public void addAuthorToContract(Author author) {
        contracts.add(author);
    }

    public boolean bookIsPublished(Book book) {
        return publishedBooks.contains(book);
    }

    public void addPublishedBook(Book book) {
        publishedBooks.add(book);
    }
}
