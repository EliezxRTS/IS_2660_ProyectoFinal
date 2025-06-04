package mx.unam.aragon.ico.is.monhanapi.repositories;

import mx.unam.aragon.ico.is.monhanapi.entities.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Long> {
    Monster findByIdMonster(Long idMonster);
}
