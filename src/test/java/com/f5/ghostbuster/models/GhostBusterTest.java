package com.f5.ghostbuster.models;

import org.junit.jupiter.api.BeforeEach;

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

    
}
