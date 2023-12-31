package cvut.fel.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Getter @Setter @ToString
public class Author extends AbstractEntity {

    @ManyToMany(mappedBy = "authors") // nazev vlastnosti na druhe strane vztahu
    private List<Book> books;

    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid email format")
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @ManyToMany
    private List<Publisher> publishers;

    public Author() {

    }

    public boolean hasContractWithPublisher(Publisher publisher) {
        return publishers.contains(publisher);
    }

    public void addPublisherToContract(Publisher publisher) {
        publishers.add(publisher);
    }
}
