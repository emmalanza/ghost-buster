package com.f5.ghostbuster.views;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeView extends JFrame {

    public HomeView() {

        setTitle("GhostBuster");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
private void initializeComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Elementos se colocan de arriba a abajo
        

}


}
