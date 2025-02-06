package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;
import java.util.List;

public class GhostController {
    private GhostBuster model;
    private ConsoleView view;

    public GhostController(GhostBuster model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void captureGhost() {
       
        Ghost ghost = view.createGhost();
        model.captureGhost(ghost);
        view.showMessage("Fantasma \"" + ghost.getName() + "\" capturado exitosamente."); 
    }

    public void viewAllGhosts() {
        List<Ghost> ghosts = model.getAllGhost();
        view.showAllGhosts(ghosts);
    }

    public void freeGhost() {
        int id = view.getGhostId();
        boolean success = model.freeGhost(id);
        if (success) {
            view.showMessage("Fantasma  liberado exitosamente."); 
        } else {
            view.showMessage("Fantasma liberado exitosamente."); 
        }
    }

    public void filterGhostsByClass() {
        Ghost.Class ghostClass = view.getGhostClass();
        List<Ghost> ghosts = model.filterGhostsByClass(ghostClass);
        view.showAllGhosts(ghosts);
    }
}

    

