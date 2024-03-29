package cvut.fel.bilbo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter @Setter @ToString
public class Group {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "groupBelief")
        private Belief groupBelief;

        @OneToMany(mappedBy = "group")
        private List<Hero> heroes;

        public void addHero(Hero hero){
                if (heroes == null) {
                        heroes = new ArrayList<>();
                }
                heroes.add(hero);
        }
}
