package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.FieldMissingException;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.BattleRepository;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class BattleServiceTest {

    @Autowired
    private BattleService battleService;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private BattleRepository battleRepository;

    @Autowired
    private HeroRepository heroRepository;

    @Test
    public void fight() {
        // Arrange
        Group groupA = new Group();
        groupA.setId(1L);
        groupA.setName("Fellowship10");
        groupA.setGroupBelief(Belief.GOOD);
        groupA.setHeroes(generateFelloship());
        groupRepository.save(groupA);

        Group groupB = new Group();
        groupB.setId(2L);
        groupB.setName("SauronBand10");
        groupB.setGroupBelief(Belief.EVIL);
        groupB.setHeroes(generateSauron());
        groupRepository.save(groupB);


        // Act
        Group result = battleService.fight(groupA.getId(), groupB.getId(), 1);

        // Assert
        assertEquals(groupB.getId(), result.getId());

    }

    @Test(expected = NotFoundException.class)
    public void fightErrorWrongId() {
        // Arrange
        Group groupA = new Group();
        groupA.setId(1L);
        groupA.setName("Fellowship4");
        groupA.setGroupBelief(Belief.GOOD);
        groupA.setHeroes(generateFelloship());
        groupRepository.save(groupA);


        // Act
        Group result = battleService.fight(groupA.getId(), 3L, 1);

        fail("Exception not thrown.");
    }

    private List<Hero> generateSauron() {
        Hero hero1 = new Hero();
        hero1.setName("Saruman");
        hero1.setStrength(200);
        hero1.setMagic(200);
        hero1.setWill(200);
        hero1.setBelief(Belief.EVIL);
        heroRepository.save(hero1);

        return new ArrayList<Hero>() {{
            add(hero1);
        }};
    }

    private List<Hero> generateFelloship() {
        Hero hero1 = new Hero();
        hero1.setName("Bilbo5");
        hero1.setStrength(100);
        hero1.setMagic(100);
        hero1.setWill(100);
        hero1.setBelief(Belief.GOOD);
        heroRepository.save(hero1);

        Hero hero2 = new Hero();
        hero2.setName("Gandalf");
        hero2.setStrength(0);
        hero2.setMagic(100);
        hero2.setWill(50);
        hero2.setBelief(Belief.GOOD);
        heroRepository.save(hero2);

        return new ArrayList<Hero>() {{
            add(hero1);
            add(hero2);
        }};
    }

}
