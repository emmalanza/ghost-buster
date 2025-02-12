package com.f5.ghostbuster.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.f5.ghostbuster.models.dto.GhostDTO;

public class GhostBuster {
    private List<Ghost> ghosts = new ArrayList<>();

    public boolean captureGhost(GhostDTO ghostDTO) {
        try {
            Ghost ghost = new Ghost(
                ghostDTO.getName(),
                Ghost.Class.valueOf(ghostDTO.getGhostClass()), 
                Ghost.DangerLevel.valueOf(ghostDTO.getDangerLevel()), 
                ghostDTO.getAbility()
            );
            ghosts.add(ghost);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    public List<GhostDTO> getAllGhost() {
       List<GhostDTO> ghostsDTO = new ArrayList<>();
       for (Ghost ghost : this.ghosts) {
            ghostsDTO.add(new GhostDTO(ghost));
       }
       return ghostsDTO;
    }

    public boolean freeGhost(int id) {
        return ghosts.removeIf(ghost -> ghost.getId() == id);
    }

    public List<GhostDTO> filterGhostsByClass(String ghostClass) {
        List<Ghost> filteredGhosts = ghosts.stream().filter(ghost -> ghost.getGhostClass() == Ghost.Class.valueOf(ghostClass)).toList();
        return filteredGhosts.stream().map(GhostDTO::new).toList();
    }

    public List<GhostDTO> filterGhostsByDate(LocalDate date) {
        List<Ghost> filteredGhosts = ghosts.stream().filter(ghost -> ghost.getDateOfCapture().equals(date)).toList();
        return filteredGhosts.stream().map(GhostDTO::new).toList();
    }
}