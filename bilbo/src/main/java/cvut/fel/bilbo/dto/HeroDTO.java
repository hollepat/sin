package cvut.fel.bilbo.dto;

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
