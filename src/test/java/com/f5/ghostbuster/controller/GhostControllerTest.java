package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;
import static org.mockito.Mockito.mock;
import javax.swing.text.View;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import org.junit.jupiter.api.DisplayName;

public class GhostControllerTest {
    
    // Se crean instancias de las clases Ghost y GhostBuster
    GhostBuster mockModel = mock(GhostBuster.class);
    ConsoleView mockView = mock(ConsoleView.class);

    // Se crea una instancia de la clase GhostController
    GhostController controller = new GhostController(mockModel, mockView);


    @Test
    @DisplayName(" Test for captureGhost method")

    // Se crea un método para probar el método captureGhost
        void testCaptureGhost() {

    // Configurar vistas Mock

    when(mockView.getInput("Ingresa el nombre del fantasma")).thenReturn("Fantasma Prueba");
    when(mockView.getInput("Selecciona la clase de fantasma (I, II, III, IV)")).thenReturn("IV");
    when(mockView.getInput("Ingresa el nivel de peligro (BAJO, MEDIO, ALTO, CRITICO)")).thenReturn("ALTO");
    when(mockView.getInput("Ingresa la habilidad especial del fantasma")).thenReturn("Telequinesis");
    
    // Llamar al método captureGhost
    controller.captureGhost();

}
