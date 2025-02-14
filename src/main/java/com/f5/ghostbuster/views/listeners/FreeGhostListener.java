package com.f5.ghostbuster.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.dto.GhostDTO;
import com.f5.ghostbuster.views.GhostBusterView;
import com.f5.ghostbuster.views.utils.GhostListUtils;

public class FreeGhostListener implements ActionListener {

    private GhostBusterView view;
    private GhostBusterController controller;
    private GhostListUtils utils;

    public FreeGhostListener(GhostBusterView view, GhostBusterController controller) {
        this.view = view;
        this.controller = controller;
        this.utils = new GhostListUtils(view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = view.ghostList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(view, "Select a ghost to free it", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<GhostDTO> ghosts = controller.getAllGhosts();
        GhostDTO selectedGhost = ghosts.get(selectedIndex);

        int ghostId = selectedGhost.getId();
        boolean success = controller.freeGhost(ghostId);

        if (success) {
            JOptionPane.showMessageDialog(view, "Fantasma liberado");
            utils.updateGhostList();
        } else {
            JOptionPane.showMessageDialog(view, "Error with freeing the ghost", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}

    
    
