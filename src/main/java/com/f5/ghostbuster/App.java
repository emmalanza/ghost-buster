package com.f5.ghostbuster;


import com.f5.ghostbuster.factory.GhostBusterFactory;
import com.f5.ghostbuster.views.GhostBusterView;

public class App {
    public static void main(String[] args) {
        new GhostBusterView(GhostBusterFactory.createController());
    }
}
