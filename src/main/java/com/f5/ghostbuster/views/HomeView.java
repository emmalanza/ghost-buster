package com.f5.ghostbuster.views;

import com.f5.ghostbuster.factory.GhostBusterFactory;

import javax.swing.BorderFactory;
import javax.swing.Timer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
            private final Image backgroundImage = new ImageIcon(
                    getClass().getResource("/ghostbuster/ghostbusterhome.jpg"))
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

        JLabel titleLabel = new JLabel("GhostBuster");
        titleLabel.setFont(new Font("Arial Black", Font.BOLD, 50));
        titleLabel.setForeground(new Color(255, 230, 0));
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        Timer timer = new Timer(400, e -> titleLabel.setLocation(titleLabel.getX(),
                titleLabel.getY() + (titleLabel.getY() % 2 == 0 ? 1 : -1)));
        timer.start();

        mainPanel.add(titleLabel, gbc);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Arial Black", Font.BOLD, 25));
        newGameButton.setForeground(new Color(255, 230, 0));
        newGameButton.setBackground(new Color(139, 0, 0));
        newGameButton.setPreferredSize(new Dimension(250, 60));
        newGameButton.setFocusPainted(false);
        newGameButton.setContentAreaFilled(true);
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(255, 230, 0), 3));

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
