package cvut.fel.model;

import javax.persistence.*;

@Entity
public class Contract {

    @Id
    @ManyToOne
    private Author author;

    @OneToOne
    private Publisher publisher;
}
