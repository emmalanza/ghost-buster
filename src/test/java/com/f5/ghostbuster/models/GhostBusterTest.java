package com.f5.ghostbuster.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GhostBusterTest {
    private GhostBuster ghostBuster;
    @BeforeEach
    public void setUp() {
        ghostBuster = new GhostBuster();
        Ghost ghost1 = new Ghost("Espíritu del Pescador de Lastres", Ghost.Class.IV, Ghost.DangerLevel.ALTO, "Aparecer durante tormentas en la costa");
        Ghost ghost2 = new Ghost("Espíritu del Río Caudal", Ghost.Class.V, Ghost.DangerLevel.CRITICO, "Aparecer durante tormentas en la costa");
        Ghost ghost3 = new Ghost("Espíritu de Turón", Ghost.Class.I, Ghost.DangerLevel.BAJO, "Aparecer durante tormentas en la costa");
        ghostBuster.captureGhost(ghost1);
        ghostBuster.captureGhost(ghost2);
        ghostBuster.captureGhost(ghost3);   
    }


    @Test
    public void testCaptureGhost() {
       ghostBuster.captureGhost(new Ghost("Espíritu del Pescador de Lastres", Ghost.Class.IV, 
       Ghost.DangerLevel.ALTO, "Aparecer durante tormentas en la costa"));
       assertEquals(4, ghostBuster.getAllGhost().size());
    }
    @Test
    public void testGetAllGhosts() {
       assertEquals(3, ghostBuster.getAllGhost().size());
    }

    @Test 
    public void testFreeGhost() {
        Ghost ghost = new Ghost("Espíritu de Turón", Ghost.Class.I, Ghost.DangerLevel.BAJO, "Aparecer durante tormentas en la costa");
        ghostBuster.captureGhost(ghost);
        assertEquals(true, ghostBuster.freeGhost(ghost.getId()));
        assertEquals(3, ghostBuster.getAllGhost().size());
    }

    @Test void testFilterGhostsByClass() {
        assertEquals(1, ghostBuster.filterGhostsByClass(Ghost.Class.I).size());
    }




    
}
