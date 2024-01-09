package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Hero;

import java.util.List;

public interface HeroService {
    Hero getById(Long id);
    List<Hero> getAll();

}
