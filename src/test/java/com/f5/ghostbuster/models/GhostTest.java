package com.f5.ghostbuster.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;

public class GhostTest {

        private Ghost ghost;
        private String name;
        private Ghost.Class ghostClass;
        private Ghost.DangerLevel dangerLevel;
        private String hability;

        @BeforeEach
        public void setUp() {
            name = "Espíritu del Pescador de Lastres";
            ghostClass = Ghost.Class.IV;
            dangerLevel = Ghost.DangerLevel.ALTO;
            hability = "Aparecer durante tormentas en la costa";
            ghost = new Ghost(name, ghostClass, dangerLevel, hability);
        }
    @Test
    @DisplayName("Initializing correctly ghost name")
    public void testInitialCorrectlyGhostName() {
        
        //Given
        String name = "Espíritu del Pescador de Lastres";
        Ghost ghost = new Ghost(name, Ghost.Class.IV, Ghost.DangerLevel.ALTO, "Aparecer durante tormentas en la costa");

        //Then
        assertThat(ghost.getName(), is(name));
    }
    
    @Test
    @DisplayName("Initializing correctly ability of ghost")
    public void testInitialCorrectlyGhostAbility() {
        
        //Then
        assertThat(ghost.getability(), is(ability));
    }
}
