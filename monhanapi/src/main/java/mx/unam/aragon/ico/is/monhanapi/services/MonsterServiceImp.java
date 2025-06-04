package mx.unam.aragon.ico.is.monhanapi.services;

import jakarta.transaction.Transactional;
import mx.unam.aragon.ico.is.monhanapi.entities.Monster;
import mx.unam.aragon.ico.is.monhanapi.repositories.MonsterRepository;
import mx.unam.aragon.ico.is.monhanapi.services.interfaces.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonsterServiceImp implements MonsterService {
    @Autowired
    private MonsterRepository monsterRepository;

    @Override
    public Optional<Monster> searchById(Long id) {
        return monsterRepository.findById(id);
    }

    @Override
    public Iterable<Monster> list() {
        return monsterRepository.findAll();
    }

    @Override
    public Monster create(Monster monster) {
        /*if (monster.getAlias() == null || monster.getAlias().isBlank()) {
            monster.setAlias("none");
        }
        if (monster.getPicture() == null || monster.getPicture().isBlank()) {
            monster.setPicture("'https://tiermaker.com/images/chart/chart/final-bosses-tier-list-monster-hunter-171616/1stgen-questionmarkiconpng.png'");
        }
        if (monster.getElements() == null || monster.getElements().isBlank()) {
            monster.setElements("none");
        }*/
        return monsterRepository.save(monster);
    }

    @Override
    public Monster update(Long id, Monster monster) {
        Optional<Monster> actualMonster = monsterRepository.findById(id);
        if (actualMonster.isPresent()) {
            Monster monster1 = actualMonster.get();
            monster1.setName(monster.getName());
            monster1.setAlias(monster.getAlias());
            monster1.setClassification(monster.getClassification());
            monster1.setPicture(monster.getPicture());
            monster1.setElements(monster.getElements());
            return monsterRepository.save(monster1);
        }
        else {
            return null;
        }
    }

    @Override
    @Transactional
    public Monster deleteById(Long id) {
        Optional<Monster> monster = monsterRepository.findById(id);
        if (monster.isPresent()) {
            monsterRepository.deleteById(id);
            return monster.get();
        }
        else {
            return null;
        }
    }
}
