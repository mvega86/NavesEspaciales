package com.pruebaTecnica.spaceShips.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "naves_espaciales")
@Tag(name = "Naves espaciales")
public class SpaceShipController {

    @Operation(summary = "Obtiene todas las naves espaciales")
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("Hola");
    }
}
