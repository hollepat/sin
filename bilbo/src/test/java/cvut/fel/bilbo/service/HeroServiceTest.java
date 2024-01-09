package cvut.fel.bilbo.service;

import cvut.fel.bilbo.dto.HeroDTO;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.repository.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class HeroServiceTest {

    @Autowired
    private HeroServiceImp heroServiceImp;

    @Autowired
    private HeroRepository heroRepository;

    @Test
    public void addHero() {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Bilbo1");
        heroDTO.setStrength(100);
        heroDTO.setMagic(100);
        heroDTO.setWill(100);
        heroDTO.setBelief("good");

        assertTrue(heroServiceImp.addHero(heroDTO));

    }

    @Test
    public void updateHero() {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Bilbo2");
        heroDTO.setStrength(100);
        heroDTO.setMagic(100);
        heroDTO.setWill(100);
        heroDTO.setBelief("good");


        assertTrue(heroServiceImp.addHero(heroDTO));

        Hero h = heroRepository.findByName("Bilbo2");

        assertTrue(heroServiceImp.updateHero(h.getId(), "Sam"));
    }

    @Test
    public void getHeroes() {
        heroServiceImp.getAll();
    }
}
