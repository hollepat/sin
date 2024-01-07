package cvut.fel.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libraries")
@Getter @Setter @ToString
public class Library extends AbstractEntity{

    @Embedded
    private Address address;

    public Library() {

    }

    public Library(String name) {
        super();
        this.name = name;
    }

}
