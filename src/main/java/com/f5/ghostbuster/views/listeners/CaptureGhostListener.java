package com.f5.ghostbuster.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.models.dto.GhostDTO;
import com.f5.ghostbuster.views.GhostBusterView;
import com.f5.ghostbuster.views.utils.GhostListUtils;

public class CaptureGhostListener implements ActionListener {

    private GhostBusterView view;
    private GhostBusterController controller;
    private GhostListUtils utils;

    public CaptureGhostListener(GhostBusterView view, GhostBusterController controller) {
        this.view = view;
        this.controller = controller;
        this.utils = new GhostListUtils(view, controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = view.nameField.getText();
        String ghostClass = (String) view.classBox.getSelectedItem();
        String abilities = view.abilitiesField.getText();
        String dangerLevel = (String) view.dangerBox.getSelectedItem();        
        
        if (name.isEmpty() || ghostClass == null || dangerLevel == null) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        GhostDTO ghost = new GhostDTO(name, ghostClass, dangerLevel, abilities);
        if (controller.captureGhost(ghost)) {
            JOptionPane.showMessageDialog(null, "Fantasma capturado con éxito!");
            utils.updateGhostList();
        } else {
            JOptionPane.showMessageDialog(null, "Error al capturar el fantasma", "Error", JOptionPane.ERROR_MESSAGE);
        }        
        view.nameField.setText("");
        view.abilitiesField.setText("");
        view.classBox.setSelectedIndex(0);
        view.dangerBox.setSelectedIndex(0);
    }

}

    
    
