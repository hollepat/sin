package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImp implements HeroService{

    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImp(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Hero getById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id is null");
        }
        return heroRepository.findById(id).orElseThrow(() -> new NotFoundException("HERO_NOT_FOUND"));

    }

    public List<Hero> getAll() {
        return (List<Hero>) heroRepository.findAll();
    }
}
