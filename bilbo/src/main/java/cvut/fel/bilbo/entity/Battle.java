package cvut.fel.bilbo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "battles")
@Getter @Setter @ToString
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "groupA_id")
    private Group groupA;

    @ManyToOne
    @JoinColumn(name = "groupB_id")
    private Group groupB;

    @Column(name = "groupAvalue")
    private int groupAvalue;

    @Column(name = "groupBvalue")
    private int groupBvalue;

}
