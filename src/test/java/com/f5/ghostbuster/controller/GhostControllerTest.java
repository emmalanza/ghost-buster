package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.controllers.GhostController;
import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GhostControllerTest {
    
    private GhostBuster mockModel;
    private ConsoleView mockView;
    private GhostController controller;

    @BeforeEach
    void setUp() {
        // Creamos los mocks y el controlador antes de cada prueba
        mockModel = mock(GhostBuster.class);
        mockView = mock(ConsoleView.class);
        controller = new GhostController(mockModel, mockView);
    }

    @Test
    @DisplayName("Test para verificar que se muestra el mensaje correcto al capturar un fantasma")
    void testCaptureGhostDisplaysCorrectMessage() {

        // Crear un objeto fantasma para simular la entrada del usuario
        Ghost ghost = new Ghost("Fantasma Prueba", Ghost.Class.IV, Ghost.DangerLevel.ALTO, "Telequinesis");

        // Configurar el comportamiento del mock de la vista
        when(mockView.createGhost()).thenReturn(ghost);
        
        // Llamar al método captureGhost
        controller.captureGhost();

        // Verificar que el fantasma fue capturado en el modelo
        verify(mockModel).captureGhost(ghost);

        // Verificar que se mostró el mensaje correcto al usuario
        verify(mockView).showMessage("Fantasma \"Fantasma Prueba\" capturado exitosamente.");
    }
}
