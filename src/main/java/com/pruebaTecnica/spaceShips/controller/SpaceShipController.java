package com.pruebaTecnica.spaceShips.controller;

import com.pruebaTecnica.spaceShips.dto.FilterDTO;
import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.dto.SpaceShipDTO;
import com.pruebaTecnica.spaceShips.service.ISpaceShipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "spaceShips")
@Tag(name = "Space ships")
public class SpaceShipController {

    @Autowired
    private ISpaceShipService spaceShipService;

    @GetMapping
    public ResponseEntity<Page<SpaceShip>> find(@ModelAttribute FilterDTO filterDTO,
                                                  @RequestParam int page,
                                                  @RequestParam int size) {
        return ResponseEntity.ok(spaceShipService.getAll(filterDTO, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceShip> read(@PathVariable Long id) {
        return ResponseEntity.ok(spaceShipService.getSpaceShipById(id));
    }

//    @GetMapping("/search")
//    public ResponseEntity<List<SpaceShip>> getByName(@RequestParam String name) {
//        return ResponseEntity.ok(spaceShipService.getSpaceShipsByName(name));
//    }

    @PostMapping
    public ResponseEntity<SpaceShip> create(@RequestBody SpaceShipDTO spaceShipDTO) {
        return ResponseEntity.ok(spaceShipService.createSpaceShip(spaceShipDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceShip> update(@PathVariable Long id, @RequestBody SpaceShipDTO spaceShipDTO) {
        return ResponseEntity.ok(spaceShipService.updateSpaceShip(id, spaceShipDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        spaceShipService.deleteSpaceShip(id);
        return ResponseEntity.noContent().build();
    }


}
