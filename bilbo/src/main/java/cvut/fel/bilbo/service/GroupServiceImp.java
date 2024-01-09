package cvut.fel.bilbo.service;

import cvut.fel.bilbo.entity.Group;
import cvut.fel.bilbo.entity.Hero;
import cvut.fel.bilbo.exception.FieldInvalidException;
import cvut.fel.bilbo.exception.FieldMissingException;
import cvut.fel.bilbo.exception.NotFoundException;
import cvut.fel.bilbo.repository.GroupRepository;
import cvut.fel.bilbo.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GroupServiceImp implements GroupService {


    private final GroupRepository groupRepository;

    private final HeroRepository heroRepository;

    Logger logger = Logger.getLogger(GroupServiceImp.class.getName());

    @Autowired
    public GroupServiceImp(GroupRepository groupRepository, HeroRepository heroRepository) {
        this.groupRepository = groupRepository;
        this.heroRepository = heroRepository;
    }

    public boolean addHeroToGroup(Long heroId, Long groupId) {

        logger.log(Level.INFO, "Adding hero with id: " + heroId + " to group with id: " + groupId);

        if (heroId == null) {
            logger.log(Level.WARNING, "HeroId is not valid");
            throw new FieldMissingException();
        }

        if (groupId == null) {
            logger.log(Level.WARNING, "GroupId is not valid");
            throw new FieldMissingException();
        }

        // get group from database
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NotFoundException("GROUP_NOT_FOUND"));

        // get hero from database
        Hero hero = heroRepository.findById(heroId)
                .orElseThrow(() -> new NotFoundException("HERO_NOT_FOUND"));

        // check if hero is already in group
        if (hero.getGroup() != null) {
            logger.log(Level.WARNING, "Hero is already in some group: " + hero.getGroup());
            throw new FieldInvalidException("HERO_ALREADY_IN_GROUP");
        }

        // check belief of group with belief of hero
        if (group.getGroupBelief() != hero.getBelief()) {
            logger.log(Level.WARNING, "Hero belief is not same as group belief");
            throw new FieldInvalidException("HERO_BELIEF_NOT_SAME_AS_GROUP_BELIEF");
        }

        logger.log(Level.INFO, "Hero: " + hero + " added to group: " + group);

        // add hero to group
        group.addHero(hero);
        hero.setGroup(group);

        // save hero to database
        groupRepository.save(group);
        heroRepository.save(hero);

        return true;

    }
}
