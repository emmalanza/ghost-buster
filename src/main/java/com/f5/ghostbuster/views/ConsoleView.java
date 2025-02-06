package com.f5.ghostbuster.views;

import java.util.List;

import com.f5.ghostbuster.models.Ghost;

public interface ConsoleView {

     void displayMenu();
    int getUserOption();
    String getInput(String prompt);
    void displayMessage(String message);
    void displayGhosts(List<Ghost> ghosts);
} 