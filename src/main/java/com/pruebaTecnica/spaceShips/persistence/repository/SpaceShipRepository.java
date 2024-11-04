package com.pruebaTecnica.spaceShips.persistence.repository;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceShipRepository extends JpaRepository<SpaceShip, Long>{
    List<SpaceShip> findByNameContaining(String name);
}