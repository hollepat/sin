package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter @Setter @ToString
public class Author extends AbstractEntity {

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid email format")
    private String email;

    @ManyToMany(mappedBy = "authors") // nazev vlastnosti na druhe strane vztahu
    private List<Book> books;

    @ManyToMany
    private List<Publisher> publishers;

    public Author() {

    }

    public Author(String name) {
        super();
        this.name = name;
    }

    public boolean hasContractWithPublisher(Publisher publisher) {
        return publishers.contains(publisher);
    }

    public void addPublisherToContract(Publisher publisher) {
        publishers.add(publisher);
    }
}
