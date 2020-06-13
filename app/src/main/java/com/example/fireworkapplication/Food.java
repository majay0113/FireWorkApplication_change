package com.example.fireworkapplication;

public class Food {
    String name;
    String recipie;
    int image;

    public Food(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Food(String name, String recipie, int image) {
        this.name = name;
        this.recipie = recipie;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipie() {
        return recipie;
    }

    public void setRecipie(String recipie) {
        this.recipie = recipie;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

