package com.pruebaTecnica.spaceShips.service;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISpaceShipService {
    public Page<SpaceShip> getAllSpaceShips(int page, int size);

    public Optional<SpaceShip> getSpaceShipById(Long id);

    public List<SpaceShip> getSpaceShipsByName(String name);

    public SpaceShip createSpaceShip(SpaceShip spaceShip);

    public SpaceShip updateSpaceShip(Long id, SpaceShip spaceShip);

    public void deleteSpaceShip(Long id);
}
