package com.example.healthkeeper.ApptCustomSpinner;

import java.io.Serializable;

public class Specialist_A188203 implements Serializable {

    private String name, type, hosp;
    private int image;

    public Specialist_A188203() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHosp() {
        return hosp;
    }

    public void setHosp(String hosp) {
        this.hosp = hosp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
