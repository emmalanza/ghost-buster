package com.f5.ghostbuster.models;

public class Ghost {

    private String name;

    public Ghost(String name, Ghost.Class ghostClass, Ghost.DangerLevel dangerLevel, String hability) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   public enum Class {
        I, II, III, IV, V
    }

    public enum DangerLevel {
        BAJO, MEDIO, ALTO, CRITICO
    }
}
