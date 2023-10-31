package cvut.fel.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @NonNull
    private Long ISBN;

    @ManyToMany
    @JoinTable(
            name = "book author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @NonNull
    private List<Author> authors;

    @Column
    private Date dateOfPublishing;

    // Mapping the enum to a column in the database
    @Enumerated(EnumType.STRING) // You can use EnumType.ORDINAL for storing enum indexes in the database
    private Genre genre;

    @NonNull
    private String name;

    /*
    the @JoinColumn annotation is typically used on the owning side
    of the relationship (in the @ManyToOne side) to specify the column
    in the database table that represents the foreign key related to the
    associated entity.
     */
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {

    }
}
