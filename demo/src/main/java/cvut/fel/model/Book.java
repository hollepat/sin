package cvut.fel.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    @Column
    @NonNull
    private Long ISBN;

    @Column
    @OneToMany
    private List<Author> authors;

    @Column
    private Date dateOfPublishing;

    @Column
    private Genre genre;

    @Column
    @NonNull
    private String name;

    @Column
    @OneToOne
    private Publisher publisher;

    public Book(List<Author> authors, Publisher publisher) {
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book() {

    }
}
