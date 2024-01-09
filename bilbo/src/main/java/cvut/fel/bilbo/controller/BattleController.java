package cvut.fel.bilbo.controller;

import cvut.fel.bilbo.dto.GroupDTO;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.service.BattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleController {

    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }


    @PostMapping("/fight/groupA/{groupAid}/groupB/{groupBid}")
    public ResponseEntity<GroupDTO> createBook(@PathVariable Long groupAid, @PathVariable Long groupBid) {
        Group group = battleService.fight(groupAid, groupBid, 1);
        GroupDTO groupDTO = new GroupDTO(group);
        return ResponseEntity.ok(groupDTO);
    }
}
