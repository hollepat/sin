package cvut.fel.bilbo.controller;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import cvut.fel.bilbo.service.BattleServiceImp;
import org.apache.catalina.Store;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class BattleControllerTest extends BaseControllerTestRunner {

    @MockBean
    private BattleServiceImp battleServiceImpMock;

    @Test
    public void getByIdReturnsMatchingBook() throws Exception {
        Hero hero = new Hero();
        hero.setName("Bilbo");
        hero.setMagic(100);
        hero.setStrength(100);
        hero.setWill(100);
        hero.setBelief(Belief.GOOD);

        Group group = new Group();
        group.setName("Hobbits");
        group.addHero(hero);
        hero.setGroup(group);

        Hero hero2 = new Hero();
        hero.setName("Gandalf");
        hero.setMagic(200);
        hero.setStrength(200);
        hero.setWill(100);
        hero.setBelief(Belief.GOOD);

        Group group2 = new Group();
        group2.setName("Sauron");
        group2.addHero(hero2);
        hero2.setGroup(group2);
        

        /* The bookServiceMock.findById method is stubbed to return this Book
         object when called with the given ID.*/
        when(battleServiceImpMock.fight(group2.getId(), group.getId(), 1)).thenReturn(group2);

        // The response is captured in MvcResult.
        final MvcResult mvcResult = mockMvc.perform(post("/fight/groupA/1/groupB/2")).andReturn();

        // The response is converted to a BookDTO object.
        final Group result = readValue(mvcResult, Group.class);

        /* verify(dtoMapper).bookToDto(book) checks if dtoMapper's
        bookToDto method was called with the correct Book object.
         */
        //verify(dtoMapper).bookToDto(book);

        System.out.println(result);
        assertNotNull(result);
        assertEquals(group2.getId(), result.getId());
        assertEquals(group2.getName(), result.getName());
    }
}
