package com.f5.ghostbuster;

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.factory.GhostBusterFactory;
import com.f5.ghostbuster.views.ConsoleView;

public class App {
    public static void main(String[] args) {
        GhostBusterController controller = GhostBusterFactory.createController();
        ConsoleView view = new ConsoleView(controller);

        boolean running = true;
        while (running) {
            view.showMenu();
            int option = view.getOption();
            switch (option) {
                case 1:
                    view.captureGhost();
                    break;
                case 2:
                    view.getAllGhost();
                    break;
                case 3:
                    view.freeGhost();
                    break;
                case 4:
                    view.filterGhostByClass();
                    break;
                case 5:
                    view.filterGhostsByDate();
                    break;
                case 6:
                    view.showMessage("Saliendo del juego...");
                    running = false;
                    break;
                default:
                    view.showMessage("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
