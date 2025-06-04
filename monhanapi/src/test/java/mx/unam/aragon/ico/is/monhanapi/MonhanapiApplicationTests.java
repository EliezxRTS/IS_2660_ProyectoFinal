package mx.unam.aragon.ico.is.monhanapi;

import mx.unam.aragon.ico.is.monhanapi.entities.Monster;
import mx.unam.aragon.ico.is.monhanapi.repositories.MonsterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MonhanapiApplicationTests {
	/*@Autowired
	private MonsterRepository monsterRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertMonster() {
		Monster monster = new Monster(null,"Zinogre", "Thunder Wolf Wyvern", "Wyvern", null, "Thunder");
		monsterRepository.save(monster);
	}

	@Test
	void readMonsterByID() {
		Long idTmp = 1L;
		Monster tmp = monsterRepository.findByIdMonster(idTmp);
		System.out.println(tmp);
	}

	@Test
	void deleteMonster() {
		Long idTmp = 2L;
		monsterRepository.deleteById(idTmp);
	}

	@Test
	void updateMonster() {
		Long idTmp = 1L;
		Monster tmp = monsterRepository.findByIdMonster(idTmp);
		tmp.setAlias("Fanged Wyvern");
		monsterRepository.save(tmp);
	}*/
}
