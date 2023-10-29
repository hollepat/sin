package cvut.fel.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Publisher {

    @Id
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Address address;

    @OneToMany
    private List<Book> publishedBooks;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
