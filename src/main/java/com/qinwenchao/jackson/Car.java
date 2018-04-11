package com.qinwenchao.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Car {
    private String brand = null;
    private int doors = 0;

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return String.format("brand:%s doors:%s", brand, doors);
    }
}