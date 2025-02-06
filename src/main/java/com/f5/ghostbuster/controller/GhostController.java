package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;

public class GhostController {
    private GhostBuster model;
    private ConsoleView view;

    public GhostController(GhostBuster model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void captureGhost() {
        // Usar el método createGhost() de la vista para obtener un nuevo fantasma
        Ghost ghost = view.createGhost();

        // Enviar el fantasma al modelo para que lo almacene
        model.captureGhost(ghost);

        // Mostrar mensaje de éxito al usuario
        view.showMessage("Fantasma \"" + ghost.getName() + "\" capturado exitosamente.");
    }

    // Otros métodos...
}

    

