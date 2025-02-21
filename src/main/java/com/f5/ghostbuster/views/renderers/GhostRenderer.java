package com.f5.ghostbuster.views.renderers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class GhostRenderer extends DefaultListCellRenderer {


    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {


        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBorder(new EmptyBorder(5, 10, 5, 10)); 
        containerPanel.setOpaque(false); 

        JPanel cellPanel = new JPanel(new BorderLayout()) {

        private final Image customCell = new ImageIcon(getClass().getResource("/com/f5/ghostbuster/card.png"))
                .getImage();

            @Override
            public void paintComponent (Graphics g){
                super.paintComponent(g);

                if (isSelected) {
                    g.setColor(new Color(107, 124, 198));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }

                g.drawImage(customCell, 0, 0, getWidth(), getHeight(), this);


            }
            
        };
        
        cellPanel.setOpaque(false);
        
        JLabel label = new JLabel(value.toString());
            label.setForeground(Color.BLACK);
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            cellPanel.add(label, BorderLayout.CENTER);

            containerPanel.add(cellPanel, BorderLayout.CENTER);

            return containerPanel;
        }
    }