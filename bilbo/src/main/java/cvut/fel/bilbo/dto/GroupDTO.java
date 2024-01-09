package cvut.fel.bilbo.dto;

import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;

import java.util.List;
import java.util.stream.Collectors;

public class GroupDTO {

    private String name;

    private String groupBelief;

    private List<Long> heroes;

    public GroupDTO(Group group) {
        this.name = group.getName();
        this.groupBelief = group.getGroupBelief().toString();
        this.heroes = group.getHeroes().stream().map(Hero::getId).collect(Collectors.toList());
    }
}
