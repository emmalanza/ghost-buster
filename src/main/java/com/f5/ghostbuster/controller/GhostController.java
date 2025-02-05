package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.view.View;

public class GhostController {

    private GhostBuster model;
    private View view;
    public GhostController(GhostBuster model, View view) {
        this.model = model;
        this.view = view;
    }

    
}
