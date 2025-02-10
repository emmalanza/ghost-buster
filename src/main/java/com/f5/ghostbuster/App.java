package com.f5.ghostbuster;

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;

public class App 
{
    public static void main( String[] args )
    {
        GhostBuster ghostBuster = new GhostBuster();
        ConsoleView consoleView = new ConsoleView();
        GhostBusterController ghostController = new GhostBusterController(ghostBuster, consoleView);
        ghostController.run();
    }
}
