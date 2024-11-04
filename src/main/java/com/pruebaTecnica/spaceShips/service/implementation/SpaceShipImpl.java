package com.pruebaTecnica.spaceShips.service.implementation;

import com.pruebaTecnica.spaceShips.exceptions.SpaceShipException;
import com.pruebaTecnica.spaceShips.mapper.SpaceShipDTOTOSpaceShip;
import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.persistence.repository.SpaceShipRepository;
import com.pruebaTecnica.spaceShips.service.DTO.SpaceShipDTO;
import com.pruebaTecnica.spaceShips.service.ISpaceShipService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipImpl implements ISpaceShipService {

    private final SpaceShipRepository spaceShipRepository;
    private final SpaceShipDTOTOSpaceShip spaceShipDTOTOSpaceShip;

    public SpaceShipImpl(SpaceShipRepository spaceShipRepository, SpaceShipDTOTOSpaceShip spaceShipDTOTOSpaceShip) {
        this.spaceShipRepository = spaceShipRepository;
        this.spaceShipDTOTOSpaceShip = spaceShipDTOTOSpaceShip;
    }

    @Override
    public Page<SpaceShip> getAll(int page, int size) {
        //La pagina no puede ser menor que 0
        if (page < 0) {
            throw new SpaceShipException("The page number can't be negative.", HttpStatus.BAD_REQUEST);
        }
        //La tamaño no puede ser menor que 0
        if (size <= 0) {
            throw new SpaceShipException("The size can't be less or equal to zero.", HttpStatus.BAD_REQUEST);
        }
        return spaceShipRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public SpaceShip getSpaceShipById(Long id) {
        //Se busca si existe la SpaceShip en BBDD
        Optional<SpaceShip> optionalSpaceShip = spaceShipRepository.findById(id);
        if(optionalSpaceShip.isEmpty()){
            //Si no existe lanzo error
            throw new SpaceShipException("Space ship not found", HttpStatus.NOT_FOUND);
        }
        //Si existe lo devuelvo
        return optionalSpaceShip.get();
    }

    @Override
    public List<SpaceShip> getSpaceShipsByName(String name) {
        //Verifico si se genera un listado de SpaceShip con el nombre dado
        List<SpaceShip> spaceShipList = spaceShipRepository.findByNameContaining(name);
        if(spaceShipList.size() == 0){
            //Si no se genera lanzo un error
            throw new SpaceShipException("SpaceShips not found", HttpStatus.NOT_FOUND);
        }
        //Si genera la lista la devuelvo
        return spaceShipList;
    }

    @Override
    public SpaceShip createSpaceShip(SpaceShipDTO spaceShipDTO) {
        //Hago un mapeo para convertir el SpaceShipDTO en SpaceShip para poder persistir en la BBDD
        SpaceShip spaceShip = spaceShipDTOTOSpaceShip.map(spaceShipDTO);
        return spaceShipRepository.save(spaceShip);
    }

    @Override
    public SpaceShip updateSpaceShip(Long id, SpaceShipDTO spaceShipDTO) {
        //Se busca si existe la SpaceShip en BBDD
        Optional<SpaceShip> optionalSpaceShip = spaceShipRepository.findById(id);
        if(optionalSpaceShip.isEmpty()){
            //Si no existe lanzo error
            throw new SpaceShipException("Space ship not found", HttpStatus.NOT_FOUND);
        }
        //Si existe actualizo
        SpaceShip spaceShip = optionalSpaceShip.get();
        spaceShip.setName(spaceShipDTO.getName());
        return spaceShipRepository.save(spaceShip);
    }

    @Override
    public void deleteSpaceShip(Long id) {
        //Se busca si existe la SpaceShip en BBDD
        Optional<SpaceShip> optionalSpaceShip = spaceShipRepository.findById(id);
        if(optionalSpaceShip.isEmpty()){
            //Si no existe lanzo error
            throw new SpaceShipException("Space ship not found", HttpStatus.NOT_FOUND);
        }
        //Si existe lo elimino
        spaceShipRepository.deleteById(id);
    }
}
