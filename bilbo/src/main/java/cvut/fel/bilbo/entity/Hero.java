package cvut.fel.bilbo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
@Setter @Getter @ToString
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Belief belief;

    @Column(name = "strength")
    private int strength;

    @Column(name = "magic")
    private int magic;

    @Column(name = "will")
    private int will;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
