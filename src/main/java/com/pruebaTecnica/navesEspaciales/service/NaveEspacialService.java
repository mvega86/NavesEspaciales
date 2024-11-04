package com.pruebaTecnica.navesEspaciales.service;

import com.pruebaTecnica.navesEspaciales.persistence.repository.NaveEspacialRepository;
import org.springframework.stereotype.Service;

@Service
public class NaveEspacialService {

    private final NaveEspacialRepository naveEspacialRepository;

    public NaveEspacialService(NaveEspacialRepository naveEspacialRepository) {
        this.naveEspacialRepository = naveEspacialRepository;
    }
}
