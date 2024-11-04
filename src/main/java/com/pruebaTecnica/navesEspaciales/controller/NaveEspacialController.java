package com.pruebaTecnica.navesEspaciales.controller;

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
public class NaveEspacialController {

    @Operation(summary = "Obtiene todas las naves espaciales")
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("Hola");
    }
}
