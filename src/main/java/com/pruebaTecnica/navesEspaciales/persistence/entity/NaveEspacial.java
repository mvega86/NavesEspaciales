package com.pruebaTecnica.navesEspaciales.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Nave_Espacial")
@Getter
@Setter
public class NaveEspacial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
}
