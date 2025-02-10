package com.f5.ghostbuster.controller;


import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;
import java.util.List;
import java.time.LocalDate;


public class GhostBusterController {
    private GhostBuster model;
    private ConsoleView view;

    public GhostBusterController(GhostBuster model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    captureGhost();
                    break;
                case 2:
                    viewAllGhosts();
                    break;
                case 3:
                    freeGhost();
                    break;
                case 4:
                    filterGhostsByClass();
                    break;
                case 5:
                    filterGhostsByDate();
                    break;
                case 6:
                    view.showMessage("¡Hasta luego!");
                    break;
                default:
                    view.showMessage("Opción no válida.");
                    break;
            }
        } while (option != 6);
    }
    

    public void captureGhost() {
        Ghost ghost = view.createGhost();
        model.captureGhost(ghost);
        view.showMessage("Fantasma \"" + ghost.getName() + "\" capturado exitosamente."); 
    }

    public void viewAllGhosts() {
        List<Ghost> ghosts = model.getAllGhost();
        if (ghosts.isEmpty()) {
            view.showMessage("Todavía no has capturado ningún fantasma");
        } else {
            view.showAllGhosts(ghosts);
        }
    }

    public void freeGhost() {
        int id = view.getGhostId();
        boolean success = model.freeGhost(id);
        if (success) {
            view.showMessage("Fantasma  liberado exitosamente."); 
        } else {
            view.showMessage("Fantasma no encontrado."); 
        }
    }

    public void filterGhostsByClass() {
        Ghost.Class ghostClass = view.getGhostClass();
        List<Ghost> ghosts = model.filterGhostsByClass(ghostClass);
        if (ghosts.isEmpty()) {
            view.showMessage("No se encontraron fantasmas de la clase " + ghostClass);
        } else {
            view.showAllGhosts(ghosts);
        }
    }

    public void filterGhostsByDate() {
        LocalDate date = view.getLocalDate();
        List<Ghost> ghosts = model.filterGhostsByDate(date);
        if (ghosts.isEmpty()) {
            view.showMessage("No se encontraron fantasma capturados el día: " + date);
        } else {
            view.showAllGhosts(ghosts);
        }
    }
}





    

