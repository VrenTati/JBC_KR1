package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Souvenir {
    private String name;
    private String manufacturer;
    private String releaseDate;
    private String price;

    public Souvenir(String name, String manufacturer, String releaseDate, String price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Назва: " + name + "\nРеквізити виробника: " + manufacturer
                + "\nДата випуску: " + releaseDate + "\nЦіна: " + price;
    }
}
