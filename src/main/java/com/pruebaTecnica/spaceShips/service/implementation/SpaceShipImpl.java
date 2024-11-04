package com.pruebaTecnica.spaceShips.service.implementation;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.persistence.repository.SpaceShipRepository;
import com.pruebaTecnica.spaceShips.service.ISpaceShipService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipImpl implements ISpaceShipService {

    private final SpaceShipRepository spaceShipRepository;

    public SpaceShipImpl(SpaceShipRepository spaceShipRepository) {
        this.spaceShipRepository = spaceShipRepository;
    }

    @Override
    public Page<SpaceShip> getAll(int page, int size) {
        return spaceShipRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<SpaceShip> getSpaceShipById(Long id) {
        return spaceShipRepository.findById(id);
    }

    @Override
    public List<SpaceShip> getSpaceShipsByName(String name) {
        return spaceShipRepository.findByNameContaining(name);
    }

    @Override
    public SpaceShip createSpaceShip(SpaceShip spaceShip) {
        return spaceShipRepository.save(spaceShip);
    }

    @Override
    public SpaceShip updateSpaceShip(Long id, SpaceShip spaceShip) {
        spaceShip.setId(id);
        return spaceShipRepository.save(spaceShip);
    }

    @Override
    public void deleteSpaceShip(Long id) {
        spaceShipRepository.deleteById(id);
    }
}
