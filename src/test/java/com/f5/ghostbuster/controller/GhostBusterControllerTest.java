package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GhostBusterControllerTest {

    // Mock
    private GhostBuster mockModel;
    private ConsoleView mockView;
    private GhostBusterController controller;

    @BeforeEach
    void setUp() {
        
        mockModel = mock(GhostBuster.class);
        mockView = mock(ConsoleView.class);
        controller = new GhostBusterController(mockModel, mockView);
    }

    @Test
    @DisplayName("Test para verificar que se muestra el mensaje correcto al capturar un fantasma")
    void testCaptureGhostDisplaysCorrectMessage() {

        
        Ghost ghost = new Ghost("Fantasma Prueba", Ghost.Class.IV, Ghost.DangerLevel.ALTO, "Telequinesis");

        
        when(mockView.createGhost()).thenReturn(ghost);

        
        controller.captureGhost();

        
        verify(mockModel).captureGhost(ghost);

        
        verify(mockView).showMessage(eq("Fantasma \"Fantasma Prueba\" capturado exitosamente."));
    }

    @Test
    @DisplayName("Verify that  the captured ghost list is displayed")

    void testViewAllGhosts() {

        List<Ghost> ghosts = new ArrayList<>();
        ghosts.add(new Ghost("Fantasma A", Ghost.Class.IV, Ghost.DangerLevel.ALTO, "Habilidad A"));
        ghosts.add(new Ghost("Fantasma B", Ghost.Class.II, Ghost.DangerLevel.MEDIO, "Habilidad B"));

        when(mockModel.getAllGhost()).thenReturn(ghosts);

        controller.viewAllGhosts();

        verify(mockModel).getAllGhost();
        verify(mockView).showAllGhosts(ghosts);
    }

    @Test
    @DisplayName("Verify that the ghost is released correctly")
    void testFreeGhost() {
        
        when(mockView.getGhostId()).thenReturn(1);

        
        when(mockModel.freeGhost(1)).thenReturn(true);

        controller.freeGhost();

        verify(mockView).getGhostId();
        verify(mockModel).freeGhost(1);
        verify(mockView).showMessage("Fantasma  liberado exitosamente.");
    }

    @Test
    @DisplayName("Verify that the ghosts are filtered by class")
    void testFilterGhostsByClass() {

        when(mockView.getGhostClass()).thenReturn(Ghost.Class.III);

        List<Ghost> filteredGhosts = new ArrayList<>();
        filteredGhosts.add(new Ghost("Fantasma C", Ghost.Class.III, Ghost.DangerLevel.ALTO, "Habilidad C"));

        when(mockModel.filterGhostsByClass(Ghost.Class.III)).thenReturn(filteredGhosts);
        controller.filterGhostsByClass();

        verify(mockView).getGhostClass();
        verify(mockModel).filterGhostsByClass(Ghost.Class.III);
        verify(mockView).showAllGhosts(filteredGhosts);
    }

    @Test
    @DisplayName("Verify that the ghosts are filtered by date")
    void testFilterGhostsByDate() {
        LocalDate date = LocalDate.of(2023, 3, 20);
        when(mockView.getLocalDate()).thenReturn(date);

        List<Ghost> filteredGhosts = new ArrayList<>();
        filteredGhosts.add(new Ghost("Fantasma D", Ghost.Class.IV, Ghost.DangerLevel.CRITICO, "Habilidad D"));

        when(mockModel.filterGhostsByDate(date)).thenReturn(filteredGhosts);

        controller.filterGhostsByDate();

        verify(mockView).getLocalDate();
        verify(mockModel).filterGhostsByDate(date);
        verify(mockView).showAllGhosts(filteredGhosts);
    }

}
