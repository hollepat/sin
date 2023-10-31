package cvut.fel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name = "contract_author",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

}