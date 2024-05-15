package com.example.healthkeeper.ApptCustomSpinner;

import java.io.Serializable;

public class Hospital_A188203 implements Serializable {

    private String name, address;
    private int image;

    public Hospital_A188203() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
