package com.f5.ghostbuster.factory;

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.GhostBuster;

public class GhostBusterFactory {
        public static GhostBusterController createController() {
        GhostBuster model = new GhostBuster();
        return new GhostBusterController(model);
    }
}
