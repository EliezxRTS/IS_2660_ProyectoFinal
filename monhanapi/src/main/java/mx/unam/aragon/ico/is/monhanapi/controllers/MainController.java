package mx.unam.aragon.ico.is.monhanapi.controllers;

import mx.unam.aragon.ico.is.monhanapi.entities.Monster;
import mx.unam.aragon.ico.is.monhanapi.services.interfaces.MonsterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/monhan")
public class MainController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Monster>> getMonster() {
        return new ResponseEntity<>(monsterService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterByID(@PathVariable Long id) {
        Optional<Monster> tmp = monsterService.searchById(id);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        return new ResponseEntity<>(monsterService.create(monster), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> DsntExist() {
        return new ResponseEntity<>("Unsupported Endpoint", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Monster> partialUpdate(@PathVariable Long id, @RequestBody Monster monster){
        Monster monster1 = monsterService.searchById(id).orElse(null);
        if (monster1 != null) {
            if (monster.getName() != null) monster1.setName(monster.getName());
            if (monster.getAlias() != null) monster1.setAlias(monster.getAlias());
            if (monster.getClassification() != null) monster1.setClassification(monster.getClassification());
            if (monster.getPicture() != null) monster1.setPicture(monster.getPicture());
            if (monster.getElements() != null) monster1.setElements(monster.getElements());
            return new ResponseEntity<>(monsterService.update(id, monster1), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monster> edit(@PathVariable Long id, @RequestBody Monster monster){
        Optional<Monster> tmp = monsterService.searchById(id);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(monsterService.update(id, monster), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monster> delete(@PathVariable Long id){
        Optional<Monster> tmp = monsterService.searchById(id);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(monsterService.deleteById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ping")
    public String ping() {
        LoggerFactory.getLogger(MainController.class).info("Ping!----");
        return "pong";
    }
}
