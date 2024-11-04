package com.pruebaTecnica.spaceShips.service;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.service.DTO.SpaceShipDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISpaceShipService {
    public Page<SpaceShip> getAll(int page, int size);

    public SpaceShip getSpaceShipById(Long id);

    public List<SpaceShip> getSpaceShipsByName(String name);

    public SpaceShip createSpaceShip(SpaceShipDTO spaceShipDTO);

    public SpaceShip updateSpaceShip(Long id, SpaceShipDTO spaceShipDTO);

    public void deleteSpaceShip(Long id);
}
