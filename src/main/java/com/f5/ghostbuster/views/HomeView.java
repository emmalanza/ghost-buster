package com.f5.ghostbuster.views;

import com.f5.ghostbuster.factory.GhostBusterFactory;


import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.*;
import java.awt.event.ActionEvent;

public class HomeView extends JFrame {

    public HomeView() {

        setTitle("GhostBuster");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel mainPanel = new JPanel() {
            private final Image backgroundImage = new ImageIcon(getClass().getResource("/ghostbuster/background.jpg"))
                    .getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }

        };

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        mainPanel.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0); 

        //Titulo

        JLabel titleLabel = new JLabel("GhostBuster");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setForeground(new Color(199, 125, 243)); 
        mainPanel.add(titleLabel, gbc);

        //Boton
        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial", Font.BOLD, 30));
        newGameButton.setForeground(new Color(255, 230, 0)); 
        newGameButton.setBackground(new Color(139, 0, 0)); 
        newGameButton.setPreferredSize(new Dimension(250, 60));
        newGameButton.setFocusPainted(false);
        newGameButton.setContentAreaFilled(false); 
        newGameButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Agregar bordes redondeados
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(255, 230, 0), 3, true));

        // Hacer bordes redondeados
        newGameButton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(newGameButton.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 40, 40);
                super.paint(g2, c);
            }

            
        });       
        
        newGameButton.addActionListener((ActionEvent e) -> {
            new GhostBusterView(GhostBusterFactory.createController());
            dispose();
        });

        gbc.gridy = 1;
        mainPanel.add(newGameButton, gbc);

        add(mainPanel);
        setVisible(true);
    }
}
