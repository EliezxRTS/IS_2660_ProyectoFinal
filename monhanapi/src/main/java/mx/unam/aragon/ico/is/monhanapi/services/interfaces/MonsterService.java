package mx.unam.aragon.ico.is.monhanapi.services.interfaces;

import mx.unam.aragon.ico.is.monhanapi.entities.Monster;

import java.util.Optional;

public interface MonsterService {
    public abstract Optional<Monster> searchById(Long id);
    public abstract Iterable<Monster> list();
    public abstract Monster create(Monster monster);
    public abstract Monster update(Long id, Monster monster);
    public abstract Monster deleteById(Long id);
}
