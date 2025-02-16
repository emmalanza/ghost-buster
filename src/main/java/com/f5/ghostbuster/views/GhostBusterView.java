package com.f5.ghostbuster.views;

import java.awt.*;
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

import com.f5.ghostbuster.controller.GhostBusterController;
import com.f5.ghostbuster.views.listeners.CaptureGhostListener;
import com.f5.ghostbuster.views.listeners.FreeGhostListener;

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

        setTitle("Ghost Busters");
        setSize(670, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        //Labels
        ghostImg = new ImageIcon(getClass().getResource("/ghostbuster/ghost.png"));
        Image resizedImage = ghostImg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ghostImg = new ImageIcon(resizedImage);
        imgLabel = new JLabel(ghostImg);
        imageContainer.add(imgLabel);



        bottomChildBox.setLayout(new GridBagLayout());

        
        ghostName = new JLabel("Enter ghost name");
        ghostClass = new JLabel("Choose a class");
        ghostDanger = new JLabel("Choose danger lvl");
        ghostAbilities = new JLabel("Write down an ability");
        nameField = new JTextField();
        classBox = new JComboBox<>();
        
        controller.getGhostClasses().forEach(classBox::addItem);
        
        dangerBox = new JComboBox<>();
        
        controller.getDangerLevels().forEach(dangerBox::addItem);
        
        abilitiesField = new JTextField();
        captureButton = new JButton("Capture ghost");
        captureButton.setBackground(Color.decode("#ba181b"));
        captureButton.setFont(new Font("Arial", Font.BOLD, 12));
        captureButton.setForeground(new Color(255, 230, 0));
        
        GridBagConstraints boxGbc = new GridBagConstraints();
        boxGbc.fill = GridBagConstraints.BOTH;

        boxGbc.gridx = 0;
        boxGbc.gridy = 0;
        boxGbc.insets = new Insets(3, 10, 3, 10);
        bottomChildBox.add(ghostName, boxGbc);
        
        boxGbc.gridx = 0;
        boxGbc.gridy = 1;
        boxGbc.weightx = 0.8;

        bottomChildBox.add(nameField, boxGbc);

        boxGbc.gridx = 1;
        boxGbc.gridy = 0;

        bottomChildBox.add(ghostClass, boxGbc);

        boxGbc.gridx = 1;
        boxGbc.gridy = 1;

        bottomChildBox.add(classBox, boxGbc);

        boxGbc.gridx = 2;
        boxGbc.gridy = 0;

        bottomChildBox.add(ghostDanger, boxGbc);
        
        boxGbc.gridx = 2;
        boxGbc.gridy = 1;

        bottomChildBox.add(dangerBox, boxGbc);

        boxGbc.gridx = 3;
        boxGbc.gridy = 0;

        bottomChildBox.add(ghostAbilities, boxGbc);

        boxGbc.gridx = 3;
        boxGbc.gridy = 1;
        bottomChildBox.add(abilitiesField, boxGbc);

        boxGbc.gridx = 4;
        boxGbc.gridy = 1;
        boxGbc.weightx = 0.2;
        bottomChildBox.add(captureButton, boxGbc);
        
        boxGbc.anchor = GridBagConstraints.CENTER;


        ghostListModel = new DefaultListModel<>();
        ghostList = new JList<>(ghostListModel);
        scrollPane = new JScrollPane(ghostList);
        freeGhostButton = new JButton("Free Ghost");
        freeGhostButton.setBackground(Color.decode("#ba181b"));
        freeGhostButton.setFont(new Font("Arial", Font.BOLD, 12));
        freeGhostButton.setForeground(new Color(255, 230, 0));
        leftContainer.add(scrollPane);
        leftContainer.add(freeGhostButton);


        captureButton.addActionListener(new CaptureGhostListener(this, controller));
        freeGhostButton.addActionListener(new FreeGhostListener(this, controller));
        revalidate();
        repaint();
    }

   
}