package com.pruebaTecnica.spaceShips.mapper;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.dto.SpaceShipDTO;
import org.springframework.stereotype.Component;

@Component
public class SpaceShipDTOTOSpaceShip implements IMapper<SpaceShipDTO, SpaceShip>{
    @Override
    public SpaceShip map(SpaceShipDTO in) {
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setName(in.getName());
        return spaceShip;
    }

}
