package cvut.fel.bilbo.service;

import cvut.fel.bilbo.dto.HeroDTO;
import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class HeroServiceImp implements HeroService{

    private final HeroRepository heroRepository;
    private final GroupRepository groupRepository;

    private final Logger logger = Logger.getLogger(HeroServiceImp.class.getName());

    @Autowired
    public HeroServiceImp(HeroRepository heroRepository, GroupRepository groupRepository) {
        this.heroRepository = heroRepository;
        this.groupRepository = groupRepository;
    }

    public Hero getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }

        Hero hero = heroRepository.findById(id).orElseThrow(() -> new NotFoundException("HERO_NOT_FOUND"));
        System.out.println(hero);
        return hero;
    }

    public boolean updateHero(Long id, String newName) {
        logger.info("Updating hero with id: " + id + " to name: " + newName);
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }

        Hero hero = heroRepository.findById(id).orElseThrow(() -> new NotFoundException("HERO_NOT_FOUND"));
        hero.setName(newName);
        heroRepository.save(hero);
        return true;
    }

    public List<Hero> getAll() {
        List<Hero> heroes = (List<Hero>) heroRepository.findAll();
        heroes.forEach(System.out::println);
        return heroes;
    }

    public Boolean addHero(HeroDTO heroDTO) {
        logger.info("Adding heroDTO: " + heroDTO);
        if (heroDTO == null) {
            throw new IllegalArgumentException("HeroDTO is null");
        }
        Hero h = new Hero();
        h.setName(heroDTO.getName());
        h.setMagic(heroDTO.getMagic());
        h.setStrength(heroDTO.getStrength());
        h.setWill(heroDTO.getWill());
        h.setBelief(Belief.getEnum(heroDTO.getBelief()));

        if (heroDTO.getGroup() != null) {
            Group group = groupRepository.findById(heroDTO.getGroup()).orElseThrow(() -> new NotFoundException("GROUP_NOT_FOUND"));
            h.setGroup(group);
        }

        heroRepository.save(h);
        return true;
    }



}
