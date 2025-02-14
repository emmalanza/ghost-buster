package com.f5.ghostbuster;


import com.f5.ghostbuster.views.HomeView;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            HomeView homeView = new HomeView();
            homeView.setVisible(true);
        });

