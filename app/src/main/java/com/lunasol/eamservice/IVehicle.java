package com.lunasol.eamservice;

/**
 * Created by chris on 8/9/2016.
 */
public interface IVehicle {
    IVehicle getVehicle();
    String getMake();
    String getYear();
    String getMiles();
    String getModel();

    void setModel(String model);
    void setYear(int year);
    void setMiles(int miles);
    void setMake(String maker);
}
