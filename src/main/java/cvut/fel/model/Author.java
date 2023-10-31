package cvut.fel.model;


import lombok.Data;
import javax.validation.constraints.Pattern;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @NonNull
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid email format")
    private String email;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @ManyToMany
    private List<Publisher> publishers;

    public Author() {

    }
}
