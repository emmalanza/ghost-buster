package com.f5.ghostbuster.models.dto;

import java.time.LocalDate;

import com.f5.ghostbuster.models.Ghost;

public class GhostDTO {
    private int id;
    private String name;
    private String ghostClass;
    private String dangerLevel;
    private String ability;
    private LocalDate captureDate;

    public GhostDTO() {}

    public GhostDTO(String name, String ghostClass, String dangerLevel, String ability) {
        this.name = name;
        this.ghostClass = ghostClass;
        this.dangerLevel = dangerLevel;
        this.ability = ability;
    }

    public GhostDTO(Ghost ghost) {
        this.id = ghost.getId();
        this.name = ghost.getName();
        this.ghostClass = ghost.getGhostClass().name();
        this.dangerLevel = ghost.getDangerLevel().name();
        this.ability = ghost.getAbility();
        this.captureDate = ghost.getDateOfCapture();
    }

    @Override
    public String toString() {
        return String.format("%-4d %-30s %-15s %-10s %-10s",
        id, name, ghostClass, dangerLevel, captureDate);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGhostClass() { return ghostClass; }
    public String getDangerLevel() { return dangerLevel; }
    public String getAbility() { return ability; }

}
