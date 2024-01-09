package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Group;

public interface BattleService {

    Group fight(Long groupA, Long groupB, Integer type);
}
