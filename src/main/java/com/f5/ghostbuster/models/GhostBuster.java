package com.f5.ghostbuster.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class GhostBuster {
    private List<Ghost> ghosts = new ArrayList<>();

    public void captureGhost(Ghost ghost) {
        ghosts.add(ghost);
    }
    public List<Ghost> getAllGhost() {
        return ghosts;
    }
    public boolean freeGhost(int id) {
        return false;
    }
    public List<Ghost> filterGhostsByClass() {
        return new ArrayList<>();
    }
    public List<Ghost> filterGhostsByDate(LocalDate date) {
        return new ArrayList<>();
    }

}