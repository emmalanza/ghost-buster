package com.f5.ghostbuster.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.f5.ghostbuster.models.dto.GhostDTO;

public class GhostBusterTest {
    private GhostBuster ghostBuster;
    @BeforeEach
    public void setUp() {
        ghostBuster = new GhostBuster();
        GhostDTO ghost1 = new GhostDTO("Espíritu del Pescador de Lastres", "I", "ALTO", "Aparecer durante tormentas en la costa");
        GhostDTO ghost2 = new GhostDTO("Espíritu del Pescador de Lastres", "II", "MEDIO", "Aparecer durante tormentas en la costa");
        GhostDTO ghost3 = new GhostDTO("Espíritu del Pescador de Lastres", "III", "BAJO", "Aparecer durante tormentas en la costa");
        
        ghostBuster.captureGhost(ghost1);
        ghostBuster.captureGhost(ghost2);
        ghostBuster.captureGhost(ghost3);   
    }

    @Test
    public void testCaptureGhost() {
       ghostBuster.captureGhost(new GhostDTO("Espíritu del Pescador de Lastres", "II", "MEDIO", "Aparecer durante tormentas en la costa"));
       assertEquals(4, ghostBuster.getAllGhost().size());
    }
    @Test
    public void testGetAllGhosts() {
       assertEquals(3, ghostBuster.getAllGhost().size());
    }

    @Test 
    public void testFreeGhost() {

        assertEquals(true, ghostBuster.freeGhost(ghostBuster.getAllGhost().getLast().getId()));
        assertEquals(2, ghostBuster.getAllGhost().size());
    }

    @Test void testFilterGhostsByClass() {
        assertEquals(1, ghostBuster.filterGhostsByClass("I").size());
    }

    @Test void testFilterGhostsByDate() {   
        Ghost ghost = new Ghost("Espíritu de Turón", Ghost.Class.I, Ghost.DangerLevel.BAJO, "Aparecer durante tormentas en la costa");
        ghostBuster.captureGhost(new GhostDTO(ghost));
        assertEquals(4, ghostBuster.filterGhostsByDate(ghost.getDateOfCapture()).size());
    }


    
}
