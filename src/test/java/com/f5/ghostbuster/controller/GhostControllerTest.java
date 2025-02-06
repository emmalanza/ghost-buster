package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.Ghost.DangerLevel;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.swing.text.View;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

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

        // Configurar el comportamiento del mock de la vista
        when(mockView.getInput("Ingresa el nombre del fantasma: ")).thenReturn("Fantasma Prueba");
        when(mockView.getInput("Selecciona la clase de fantasma (I, II, III, IV): ")).thenReturn("IV");
        when(mockView.getInput("Ingresa el nivel de peligro (BAJO, MEDIO, ALTO, CRITICO): ")).thenReturn("ALTO");
        when(mockView.getInput("Ingresa la habilidad especial del fantasma: ")).thenReturn("Telequinesis");
        
        // Llamar al método captureGhost
        controller.captureGhost();

        // Verificar que se mostró el mensaje correcto al usuario
        verify(mockView).displayMessage("Fantasma \"Fantasma Prueba\" capturado exitosamente.");
    }
    }
   
 

