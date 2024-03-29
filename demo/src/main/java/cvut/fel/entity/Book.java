package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Getter @Setter
public class Book extends AbstractEntity{

    @Column(unique = true)
    private String ISBN;

    @Column
    private Date dateOfPublishing;

    /*
    The @JoinTable annotation in JPA is used to define the association
    table when mapping a many-to-many relationship between entities.
    It specifies the name of the join table and the columns used for
    the association.
     */
    @ManyToMany
    @JoinTable(
        name = "book_author",   // name of the special table in the database
        joinColumns = @JoinColumn(name = "book_id"),    // name of the column in the book_author table that references this entity
        inverseJoinColumns = @JoinColumn(name = "author_id")    // name of the column in the book_author table that references the other entity
    )
    private List<Author> authors;

    // Mapping the enum to a column in the database
    @Enumerated(EnumType.STRING) // You can use EnumType.ORDINAL for storing enum indexes in the database
    private Genre genre;


    /*
    The @JoinColumn annotation is typically used on the owning side
    of the relationship (in the @ManyToOne side) to specify the column
    in the database table that represents the foreign key related to the
    associated entity.
     */
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
        this.dateOfPublishing = new Date();
    }

    public Date getPublished() {
        return (Date) dateOfPublishing.clone();
    }

    public void setPublished(Date published) {
        this.dateOfPublishing = (Date) published.clone();
    }

    @Override
    public String toString() {
        String publisherName = publisher != null ? publisher.getName() : null;
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", dateOfPublishing=" + dateOfPublishing +
                ", genre=" + genre +
                ", publisherName=" + publisherName +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
