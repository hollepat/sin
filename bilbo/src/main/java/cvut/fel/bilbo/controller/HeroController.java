package cvut.fel.bilbo.controller;

import cvut.fel.bilbo.dto.HeroDTO;
import cvut.fel.bilbo.service.HeroServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    private final HeroServiceImp heroServiceImp;

    @Autowired
    public HeroController(HeroServiceImp heroServiceImp) {
        this.heroServiceImp = heroServiceImp;
    }

    @PostMapping("/hero/{id}/new-name/{newName}")
    public ResponseEntity<Boolean> updateHero(@PathVariable Long id, @PathVariable String newName) {
        return ResponseEntity.ok(heroServiceImp.updateHero(id, newName));
    }

    @PostMapping("/addHero")
    public ResponseEntity<Boolean> addHero(@RequestBody HeroDTO hero) {
        return ResponseEntity.ok(heroServiceImp.addHero(hero));
    }
}
