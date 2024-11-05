package com.pruebaTecnica.spaceShips;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.persistence.repository.SpaceShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(false) // Para que los cambios se mantengan durante el test
class SpaceShipsApplicationIntegrationTests {

	@Autowired
	private SpaceShipRepository spaceShipRepository;

	@Test
	public void testDatabaseMigration() {
		// Verifica que la tabla esté creada
		List<SpaceShip> spaceShips = spaceShipRepository.findAll();
		assertThat(spaceShips).isNotNull();
	}

}
