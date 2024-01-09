package cvut.fel.bilbo;

import cvut.fel.bilbo.entity.Belief;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.repository.HeroRepository;
import cvut.fel.bilbo.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BilboApplication implements CommandLineRunner {


    private final HeroService heroService;
    private final HeroRepository heroRepository;

    public BilboApplication(HeroService heroService, HeroRepository heroRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
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

        System.out.println(heroService.getById(1L));
        heroService.getAll().forEach(System.out::println);

    }

}
