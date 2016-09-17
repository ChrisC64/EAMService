package com.lunasol.eamservice;

/**
 * Created by chris on 9/6/2016.
 */
public class Automobile implements IVehicle {
    private double miles;
    private int year;
    private String model;
    private String make;
    public Automobile() {
        this.miles = 2000;
        this.year = 1989;
        this.model = "Camry";
        this.make = "TOYOTA";
    }
    public Automobile(double miles, int year, String model, String make) {
        this.miles = miles;
        this.year = year;
        this.model = model;
        this.make = make;
    }
    @Override
    public IVehicle getVehicle() {
        return this;
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public String getYear() {
        return String.valueOf(this.year);
    }

    @Override
    public String getMiles() {
        return String.valueOf(this.miles);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setMiles(int miles) {
        this.miles = miles;
    }

    @Override
    public void setMake(String maker) {
        this.make = maker;
    }
}
