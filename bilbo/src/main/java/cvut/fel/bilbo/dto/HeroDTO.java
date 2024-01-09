package cvut.fel.bilbo.dto;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
public class HeroDTO {

        private String name;
        private String belief;
        private int strength;
        private int magic;
        private int will;
        private Long group;

}
