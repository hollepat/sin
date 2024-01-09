package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Battle;
import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.FieldMissingException;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.BattleRepository;
import cvut.fel.bilbo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BattleServiceImp implements BattleService {

    private final GroupRepository groupRepository;

    private final BattleRepository battleRepository;

    Logger logger = Logger.getLogger(GroupServiceImp.class.getName());

    @Autowired
    public BattleServiceImp(GroupRepository groupRepository, BattleRepository battleRepository) {
        this.groupRepository = groupRepository;
        this.battleRepository = battleRepository;
    }

    /**
     * Method for fighting between two groups
     *
     * @param groupAid id of group A
     * @param groupBid id of group B
     * @param type     type of battle
     * @return winner group
     */
    public Group fight(Long groupAid, Long groupBid, Integer type) {

        logger.info("Fighting groupA: " + groupAid + " groupB: " + groupBid + " type: " + type);
        if (groupAid == null) {
            logger.log(Level.WARNING, "GroupA is not valid");
            throw new FieldMissingException();
        }

        if (groupBid == null) {
            logger.log(Level.WARNING, "GroupB is not valid");
            throw new FieldMissingException();
        }

        if (type == null) {
            logger.log(Level.WARNING, "Type is not valid");
            throw new FieldMissingException();
        }

        // get groups from database
        Group groupA = groupRepository.findById(groupAid)
                .orElseThrow(() -> new NotFoundException("GROUP_A_NOT_FOUND"));

        Group groupB = groupRepository.findById(groupBid)
                .orElseThrow(() -> new NotFoundException("GROUP_B_NOT_FOUND"));

        Battle battle = new Battle();
        battle.setGroupA(groupA);
        battle.setGroupB(groupB);

        int groupAvalue = getValue(groupA, type);
        int groupBvalue = getValue(groupB, type);

        battle.setGroupAvalue(groupAvalue);
        battle.setGroupBvalue(groupBvalue);

        battleRepository.save(battle);
        logger.log(Level.INFO, "Battle win by: " + (groupAvalue > groupBvalue ? groupA.getName() : groupB.getName()));
        return groupAvalue > groupBvalue ? groupA : groupB;
    }

    /**
     * Method for getting value of group
     *
     * @param group group
     * @param type  type of battle
     * @return value of group
     */
    private int getValue(Group group, Integer type) {
        int value = 0;
        switch (type) {
            case 1:
                value = group.getHeroes().stream().mapToInt(Hero::getStrength).sum();
                break;
            case 2:
                value = group.getHeroes().stream().mapToInt(Hero::getMagic).sum();
                break;
            case 3:
                value = group.getHeroes().stream().mapToInt(Hero::getWill).sum();
                break;
            default:
                logger.log(Level.WARNING, "Type is not valid");
                throw new FieldMissingException();
        }
        return value;
    }
}
