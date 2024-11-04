package com.pruebaTecnica.spaceShips.controller;

import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.service.ISpaceShipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "naves_espaciales")
@Tag(name = "Naves espaciales")
public class SpaceShipController {

    @Autowired
    private ISpaceShipService spaceShipService;

    @GetMapping
    public ResponseEntity<Page<SpaceShip>> getAll(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(spaceShipService.getAll(page, size));
    }


}
