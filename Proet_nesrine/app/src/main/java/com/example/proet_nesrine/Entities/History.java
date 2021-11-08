package com.example.proet_nesrine.Entities;

public class History {
    int image;
    String title;
    String location;
    String descrip;

    public History(int image, String title, String location, String descrip) {
        this.image = image;
        this.title = title;
        this.location = location;
        this.descrip = descrip;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDescrip() {
        return descrip;
    }
}
