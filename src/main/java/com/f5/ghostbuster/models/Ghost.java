package com.f5.ghostbuster.models;

import java.time.LocalDate;

public class Ghost {

    public enum Class {
        I, II, III, IV, V
    }

    public enum DangerLevel {
        BAJO, MEDIO, ALTO, CRITICO
    }
    
    private static int counter = 0;
    private int id;
    private String name;
    private Ghost.Class ghostClass;
    private Ghost.DangerLevel dangerLevel;
    private String ability;
    private LocalDate captureDate;

    public Ghost(String name, Class ghostClass, DangerLevel dangerLevel, String ability) {
        this.id = ++counter;
        this.name = name;
        this.ghostClass = ghostClass;
        this.dangerLevel = dangerLevel;
        this.ability = ability;
        this.captureDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("%-4d %-30s %-15s %-10s %-10s",
        id, name, ghostClass, dangerLevel, captureDate);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Ghost.Class getGhostClass() {
        return ghostClass;
    }
    
    public Ghost.DangerLevel getDangerLevel() {
        return dangerLevel;
    }

    public String getAbility() {
        return ability;
    }

    public LocalDate getDateOfCapture() {
        return captureDate;
    }

}
