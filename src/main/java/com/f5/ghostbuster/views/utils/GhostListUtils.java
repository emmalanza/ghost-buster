package com.f5.ghostbuster.views.utils;
import java.util.List;
import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.dto.GhostDTO;
import com.f5.ghostbuster.views.GhostBusterView;

public class GhostListUtils {

    GhostBusterView view;
    GhostBusterController controller;

    public GhostListUtils (GhostBusterView view, GhostBusterController controller) {
        this.view = view;
        this.controller = controller;
    }

    public void updateGhostList(){

        List<GhostDTO> ghosts = controller.getAllGhosts();
        view.ghostListModel.clear();
        for(GhostDTO ghost : ghosts){
            view.ghostListModel.addElement(ghost.getId() + " " + ghost.getName()
            + " " + ghost.getGhostClass() + " " + ghost.getDangerLevel() + " " + ghost.getAbility() + " " + ghost.getCaptureDate().toString());

        }

    }

}
