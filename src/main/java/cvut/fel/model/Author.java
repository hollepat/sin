package cvut.fel.model;


import org.intellij.lang.annotations.Pattern;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    @ManyToMany(targetEntity = Book.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    @ManyToMany(targetEntity = Contract.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @NonNull
    private String email;       // TODO: check validation with regex

    @NonNull
    private String firstName;   // TODO: check validation with regex

    @NonNull
    private String lastName;    // TODO: check validation with regex

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
