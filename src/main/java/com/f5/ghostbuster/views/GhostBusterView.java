package com.f5.ghostbuster.views;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.views.listeners.CaptureGhostListener;
import com.f5.ghostbuster.views.listeners.FreeGhostListener;
import com.f5.ghostbuster.views.renderers.GhostRenderer;

public class GhostBusterView extends JFrame {

    public JPanel leftContainer, imageContainer, bottomContainer, bottomChildBox;
    public JButton captureButton, exitButton, freeGhostButton;
    public JLabel imgLabel,ghostName, ghostClass, ghostDanger, ghostAbilities;
    public JTextField nameField, abilitiesField;
    public JComboBox<String> classBox, dangerBox;
    public ImageIcon ghostImg;
    public JList<String> ghostList;
    public DefaultListModel<String> ghostListModel;
    public JScrollPane scrollPane;


    public GhostBusterView (GhostBusterController ghostBusterController) {

        GhostBusterController  controller = ghostBusterController;

        setTitle("GhostBuster");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.3;
        gbc.weighty = 1.0;

        leftContainer = new JPanel();
        leftContainer.setLayout(new GridBagLayout());
        leftContainer.setBackground(Color.decode("#D9D9D9"));
        add(leftContainer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.weightx = 0.7;
        gbc.weighty = 0.7;

        imageContainer = new JPanel();
        imageContainer.setBackground(Color.decode("#242222"));
        add(imageContainer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        gbc.weighty = 0.3;

        bottomContainer = new JPanel();
        bottomContainer.setLayout(new GridBagLayout());
        bottomContainer.setBackground(Color.decode("#666464"));
        add(bottomContainer, gbc);

        bottomChildBox = new JPanel();
        GridBagConstraints bottomGbc = new GridBagConstraints();
        bottomGbc.fill = GridBagConstraints.BOTH;
        bottomGbc.insets = new Insets(40, 30, 40, 30);
        bottomGbc.weightx = 0.7;
        bottomGbc.weighty = 0.7;
        bottomGbc.anchor = GridBagConstraints.CENTER;
        bottomChildBox.setBackground(Color.decode("#d3d3d3"));
        bottomContainer.add(bottomChildBox, bottomGbc);
   
        ghostImg = new ImageIcon(getClass().getResource("/com/f5/ghostbuster/ghost.png"));
        Image resizedImage = ghostImg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ghostImg = new ImageIcon(resizedImage);
        imgLabel = new JLabel(ghostImg);
        imageContainer.add(imgLabel);

        List<JLabel> labels = Arrays.asList(
            ghostName = new JLabel("Enter ghost name"),
            ghostClass = new JLabel("Choose a class"),
            ghostDanger = new JLabel("Choose danger lvl"),
            ghostAbilities = new JLabel("Write down an ability")
        );
        
        List<Component> components = Arrays.asList(
            nameField = new JTextField(),
            classBox = new JComboBox<>(),
            dangerBox = new JComboBox<>(),
            abilitiesField = new JTextField(),
            captureButton = new JButton("Capture ghost")
        ); 

        bottomChildBox.setLayout(new GridBagLayout());
        GridBagConstraints boxGbc = new GridBagConstraints();
        boxGbc.insets = new Insets(3, 10, 3, 10);
        boxGbc.weightx = 0.8;
        boxGbc.fill = GridBagConstraints.BOTH;
        boxGbc.anchor = GridBagConstraints.CENTER;
        
        for (int i = 0; i < labels.size(); i++ ) {
            boxGbc.gridx = i;
            boxGbc.gridy = 0;
            bottomChildBox.add(labels.get(i), boxGbc);
        }

        for (int i = 0; i < components.size(); i++) {
            boxGbc.gridx = i;
            boxGbc.gridy = 1;
            boxGbc.weightx = (i == 4) ? 0.2 : 0.8;
            bottomChildBox.add(components.get(i), boxGbc);
        }
        
        controller.getGhostClasses().forEach(classBox::addItem); 
        controller.getDangerLevels().forEach(dangerBox::addItem);

        captureButton.setBackground(Color.decode("#ba181b"));
        captureButton.setFont(new Font("Arial", Font.BOLD, 12));
        captureButton.setForeground(new Color(255, 230, 0));       
        
        ghostListModel = new DefaultListModel<>();
        ghostList = new JList<>(ghostListModel);
        ghostList.setCellRenderer(new GhostRenderer());
        ghostList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ghostList.setBackground(Color.decode("#D9D9D9"));
        ghostList.setFixedCellHeight(230);

        GridBagConstraints leftGbc = new GridBagConstraints(0, 0, 1, 1, 0.5, 1.0, 
        GridBagConstraints.CENTER, GridBagConstraints.BOTH, 
        new Insets(10, 10, 10, 10), 0, 0);
        
        scrollPane = new JScrollPane(ghostList);
        scrollPane.setBackground(Color.decode("#D9D9D9"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        leftContainer.add(scrollPane, leftGbc);
        
        freeGhostButton = new JButton("Free Ghost");
        freeGhostButton.setBackground(Color.decode("#ba181b"));
        freeGhostButton.setFont(new Font("Arial", Font.BOLD, 12));
        freeGhostButton.setForeground(new Color(255, 230, 0));
        
        leftGbc.gridy++;
        leftGbc.weighty = 0.1;
        leftGbc.fill = GridBagConstraints.NONE;
        leftContainer.add(freeGhostButton, leftGbc);

        captureButton.addActionListener(new CaptureGhostListener(this, controller));
        freeGhostButton.addActionListener(new FreeGhostListener(this, controller));
        
        revalidate();
        repaint();
    }

   
}