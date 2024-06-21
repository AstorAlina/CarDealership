package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private int vin;
    private int year;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;
    private boolean sold;

    public Vehicle(int vin, int year, String vehicleMake, String vehicleModel, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    @Override
    public String toString(){
        return vin + "|" + year +  "|" + vehicleMake +  "|" + vehicleModel +  "|" + vehicleType + "|" + color + "|" + odometer + "|" + price + "|" + sold;
    }

}