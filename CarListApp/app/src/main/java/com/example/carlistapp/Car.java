package com.example.carlistapp;

public class Car {
    private String brand;
    private int year;
    private double price;
    private int imageResourceId; // Ajout d'un champ pour l'image

    public Car(String brand, int year, double price, int imageResourceId) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.imageResourceId = imageResourceId; // Initialiser l'image
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResourceId() { // Méthode pour obtenir l'image
        return imageResourceId;
    }
}
