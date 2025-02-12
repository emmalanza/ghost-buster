package com.f5.ghostbuster.controller;

import com.f5.ghostbuster.models.Ghost;
import com.f5.ghostbuster.models.GhostBuster;
import com.f5.ghostbuster.models.dto.GhostDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class GhostBusterController {
    private GhostBuster model;

    public GhostBusterController(GhostBuster model) {
        this.model = model;
    }

    public boolean captureGhost(GhostDTO ghostDTO) {
        return model.captureGhost(ghostDTO);
    }
    
    public List<GhostDTO> getAllGhosts() {
        List<GhostDTO> ghosts = model.getAllGhost();
        return ghosts;
    }

    public boolean freeGhost(int id) {  
        return model.freeGhost(id); 
    }

    public List<GhostDTO> filterGhostsByClass(String ghostClass) {
        return model.filterGhostsByClass(ghostClass);
    }

    public List<GhostDTO> filterGhostsByDate(LocalDate date) {
        return model.filterGhostsByDate(date);
    }

    public List<String> getGhostClasses() {
        return Arrays.stream(Ghost.Class.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    public List<String> getDangerLevels() {
        return Arrays.stream(Ghost.DangerLevel.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
