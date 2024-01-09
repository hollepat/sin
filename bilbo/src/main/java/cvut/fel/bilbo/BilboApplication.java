package cvut.fel.bilbo;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import cvut.fel.bilbo.service.HeroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilboApplication implements CommandLineRunner {


    private final HeroService heroService;
    private final HeroRepository heroRepository;

    private final GroupRepository groupRepository;

    public BilboApplication(HeroService heroService, HeroRepository heroRepository, GroupRepository groupRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
        this.groupRepository = groupRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BilboApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("Hello world!");

        Hero hero = new Hero();
        hero.setName("Bilbo");
        hero.setMagic(100);
        hero.setStrength(100);
        hero.setWill(100);
        hero.setBelief(Belief.GOOD);
        heroRepository.save(hero);

        Group group = new Group();
        group.setName("Hobbits");
        group.addHero(hero);
        group.setGroupBelief(Belief.GOOD);
        hero.setGroup(group);
        group.addHero(hero);

        groupRepository.save(group);
        heroRepository.save(hero);

        Hero hero1 = new Hero();
        hero1.setName("Drak");
        hero1.setMagic(100);
        hero1.setStrength(100);
        hero1.setWill(100);
        hero1.setBelief(Belief.GOOD);
        heroRepository.save(hero1);

        Group group2 = new Group();
        group2.setName("Hobbits");
        group2.addHero(hero1);
        group2.setGroupBelief(Belief.GOOD);
        hero1.setGroup(group2);
        group2.addHero(hero1);

        groupRepository.save(group2);
        heroRepository.save(hero1);


//        System.out.println(heroService.getById(1L));
//        heroService.getAll().forEach(System.out::println);

    }

}
