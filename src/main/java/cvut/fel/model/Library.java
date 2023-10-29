package cvut.fel.model;


import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Library {

    @NonNull
    private String name;
    @Id
    private Long id;

    @NonNull
    @ManyToMany
    private List<Book> books;

    @NonNull
    private Address address;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
