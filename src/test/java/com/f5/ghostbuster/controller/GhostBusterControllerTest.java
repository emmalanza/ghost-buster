package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.dto.GhostDTO;
import com.f5.ghostbuster.models.GhostBuster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;

class GhostBusterControllerTest {

    @Mock
    private GhostBuster model;  // Mockeamos el modelo

    private GhostBusterController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializamos los mocks
        controller = new GhostBusterController(model);
    }

    @Test
    void testCaptureGhostSuccessfully() {
        // Creamos el objeto GhostDTO para la prueba
        GhostDTO ghostDTO = new GhostDTO("Casper", "I", "BAJO", "Invisibilidad");

        // Establecemos lo que el mock debería devolver cuando se le llame
        when(model.captureGhost(ghostDTO)).thenReturn(true);

        // Llamamos al método del controlador
        boolean result = controller.captureGhost(ghostDTO);

        // Comprobamos que el resultado es el esperado
        assertTrue(result);

        // Verificamos que el modelo recibió la llamada correctamente
        verify(model).captureGhost(ghostDTO);
    }

    @Test
    void testCaptureGhostFailure() {
        GhostDTO ghostDTO = new GhostDTO("Ghostly", "Scary", "High", "Teletrasnportacion");
        when(model.captureGhost(ghostDTO)).thenReturn(false);

        boolean result = controller.captureGhost(ghostDTO);
        
        assertFalse(result);
        verify(model).captureGhost(ghostDTO);
    }

    @Test
    void testGetAllGhostsWhenEmpty() {
        // Cuando no haya fantasmas en el modelo
        when(model.getAllGhost()).thenReturn(Arrays.asList());

        List<GhostDTO> ghosts = controller.getAllGhosts();

        assertTrue(ghosts.isEmpty());  // Verificamos que la lista esté vacía
    }

    @Test
    void testGetAllGhostsWhenNotEmpty() {
        GhostDTO ghostDTO = new GhostDTO("Boo", "Friendly", "Medium", "Flying");
        when(model.getAllGhost()).thenReturn(Arrays.asList(ghostDTO));

        List<GhostDTO> ghosts = controller.getAllGhosts();

        assertFalse(ghosts.isEmpty());  // Verificamos que la lista no esté vacía
        assertEquals(1, ghosts.size());
        assertEquals("Boo", ghosts.get(0).getName());
    }

    @Test
    void testFilterGhostsByClassWhenFound() {
        GhostDTO ghostDTO = new GhostDTO("Spooky", "I", "BAJO", "Invisibilidad");
        when(model.filterGhostsByClass("I")).thenReturn(Arrays.asList(ghostDTO));

        List<GhostDTO> filteredGhosts = controller.filterGhostsByClass("I");

        assertFalse(filteredGhosts.isEmpty());
        assertEquals("Spooky", filteredGhosts.get(0).getName());
    }

    @Test
    void testFilterGhostsByClassWhenNotFound() {
        when(model.filterGhostsByClass("Friendly")).thenReturn(Arrays.asList());

        List<GhostDTO> filteredGhosts = controller.filterGhostsByClass("Friendly");

        assertTrue(filteredGhosts.isEmpty());
    }

    @Test
    void testFreeGhostSuccessfully() {
        GhostDTO ghostDTO = new GhostDTO("Ghostly", "I", "ALTO", "Teletrasnportacion");
        when(model.freeGhost(ghostDTO.getId())).thenReturn(true);

        boolean result = controller.freeGhost(ghostDTO.getId());

        assertTrue(result);
        verify(model).freeGhost(ghostDTO.getId());
    }

    @Test
    void testFreeGhostFailure() {
        when(model.freeGhost(3)).thenReturn(false);

        boolean result = controller.freeGhost(3);

        assertFalse(result);
        verify(model).freeGhost(3);
    }
}
