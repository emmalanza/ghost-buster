package com.f5.ghostbuster.controller;

import java.beans.Transient;

import javax.swing.text.View;

import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;;

public class GhostController {
    private GhostBuster model;
    private ConsoleView view;

    public GhostController(GhostBuster model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void captureGhost() {

        String name = view.getInput("Ingresa el nombre del fantasma: ");    
        

    
}


}
    

