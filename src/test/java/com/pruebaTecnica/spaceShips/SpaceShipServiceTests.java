package com.pruebaTecnica.spaceShips;
import com.pruebaTecnica.spaceShips.exceptions.SpaceShipException;
import com.pruebaTecnica.spaceShips.persistence.entity.SpaceShip;
import com.pruebaTecnica.spaceShips.persistence.repository.SpaceShipRepository;
import com.pruebaTecnica.spaceShips.service.implementation.SpaceShipImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceShipServiceTests {
    @InjectMocks
    private SpaceShipImpl spaceShipService;

    @Mock
    private SpaceShipRepository spaceShipRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSpaceShips_WithValidPagination() {
        // Datos de prueba
        List<SpaceShip> ships = Arrays.asList(new SpaceShip(), new SpaceShip());
        Page<SpaceShip> pagedResponse = new PageImpl<>(ships);

        when(spaceShipRepository.findAll(PageRequest.of(0, 2))).thenReturn(pagedResponse);

        // Llamada al método
        Page<SpaceShip> result = spaceShipService.getAll(0, 2);

        // Validaciones
        assertNotNull(result);
        assertEquals(2, result.getContent().size());
        assertEquals(1, result.getTotalPages());
    }

    @Test
    public void testGetAllSpaceShips_WithInvalidPage() {
        Exception exception = assertThrows(SpaceShipException.class, () -> {
            spaceShipService.getAll(-1, 2);
        });
        assertEquals("The page number can't be negative.", exception.getMessage());
    }

    @Test
    public void testGetAllSpaceShips_WithInvalidSize() {
        Exception exception = assertThrows(SpaceShipException.class, () -> {
            spaceShipService.getAll(0, 0);
        });
        assertEquals("The size can't be less or equal to zero.", exception.getMessage());
    }
}
