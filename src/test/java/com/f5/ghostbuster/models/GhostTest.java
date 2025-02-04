package com.f5.ghostbuster.models;

import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

public class GhostTest {

    @Test
    @DisplayName("Initializing correctly ghost name")
    public void testInitialCorrectlyGhostName() {
        
        //Given
        String name = "Espíritu del Pescador de Lastres";
        Ghost ghost = new Ghost(name, Ghost.Class.IV,Ghost.DangerLevel.HIGH, "Aparecer durante tormentas en la costa");

        //Then
        assertThat(ghost.getName(), is(name));

    }
    
}
