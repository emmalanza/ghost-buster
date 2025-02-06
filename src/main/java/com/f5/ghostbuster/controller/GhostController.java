package com.f5.ghostbuster.controller;


import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.views.ConsoleView;
import com.f5.ghostbuster.models.Ghost.Class;

public class GhostController {
    private GhostBuster model;
    private ConsoleView view;

    public GhostController(GhostBuster model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void captureGhost() {

        String name = view.getInput("Ingresa el nombre del fantasma: ");   
        String classInput = view.getInput("Selecciona la clase de fantasma (I, II, III, IV): ");
        String dangerLevel = view.getInput("Ingresa el nivel de peligro (BAJO, MEDIO, ALTO, CRITICO): ");
        String ability = view.getInput("Ingresa la habilidad especial del fantasma: ");
        
        //Convertir la clase y el nivel de peligro a enum

        Class ghostClass = Class.valueOf(classInput);
        
        

    
}


}
    

