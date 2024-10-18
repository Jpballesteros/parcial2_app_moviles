package com.example.parcial2.clase;

public class Character {
    private String name;
    private String status;
    private String species;
    private String imageUrl;

    public Character(String name, String status, String species, String imageUrl) {
        this.name = name;
        this.status = status;
        this.species = species;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
