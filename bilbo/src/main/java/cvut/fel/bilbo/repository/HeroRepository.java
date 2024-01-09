package cvut.fel.bilbo.repository;

import cvut.fel.bilbo.entity.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    Hero findByName(String name);
}
