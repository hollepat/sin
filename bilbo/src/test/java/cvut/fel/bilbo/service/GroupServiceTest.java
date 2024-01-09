package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest()
public class GroupServiceTest {

    @Autowired
    private GroupService service;

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void testAddHeroToGroup() {

        Hero hero = new Hero();
        hero.setName("Bilbo");
        hero.setId(1L);
        hero.setStrength(100);
        hero.setMagic(100);
        hero.setWill(100);
        hero.setBelief(Belief.GOOD);
        heroRepository.save(hero);

        Group group = new Group();
        group.setId(1L);
        group.setName("Fellowship");
        group.setGroupBelief(Belief.GOOD);
        groupRepository.save(group);

        // Act
        boolean result = service.addHeroToGroup(hero.getId(), group.getId());

        // Assert
        assertTrue(result);
    }

    @Test(expected = NotFoundException.class)
    public void addHeroToGroupError() {

            Hero hero = new Hero();
            hero.setName("Bilbo11");
            hero.setId(1L);
            hero.setStrength(100);
            hero.setMagic(100);
            hero.setWill(100);
            hero.setBelief(Belief.GOOD);
            heroRepository.save(hero);

            Group group = new Group();
            group.setId(1L);
            group.setName("Fellowship11");
            group.setGroupBelief(Belief.GOOD);
            groupRepository.save(group);

            // Act
            service.addHeroToGroup(2L, group.getId());

            fail("Exception not thrown.");
    }


}
