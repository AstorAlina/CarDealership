package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealership {
    //properties
    private String name;
    private String address;
    private String phone;

    List<Vehicle> inventory = new ArrayList<>();
    VehicleRepository vr = new VehicleRepository("jdbc:mysql://localhost:3306/dealership", "root", "Shpitser123!");

    //methods
    // sorts array list by a price range then sorts them from min to max price
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return vr.getVehicleByPriceRange(min, max);
    }

    // sorts array list by make and model sorts them from min to max price
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return vr.getVehicleByMakeAndModel(make, model);
    }

    // sorts array list by a year range then sorts them from min to max price
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return vr.getVehiclesByYear(min, max);
    }

    // sorts array list by a color then sorts them by make, model then price from min to max price
    public List<Vehicle> getVehiclesByColor(String color) {
        return vr.getVehiclesByColor(color);
    }

    // sorts array list by a mileage range then sorts them from min to max mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return vr.getVehicleByMileage(min, max);
    }

    // sorts array list by a vehicle type and sorts them by make, model then year
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return vr.getVehiclesByType(vehicleType);
    }

    //gets all vehicles
    public List<Vehicle> getAllVehicles() {
        return vr.getAllVehicles();
    }
    //int Vin, int year, String vehicleMake, String vehicleModel, String vehicleType, String color, int odometer, double price
    //adds a vehicle to the inventory array then rewrites the file
    public void addVehicle(Vehicle vehicle) {
        vr.addVehicles(vehicle);
    }

    //removes a vehicle from the inventory array then rewrites the file
    public void removeVehicle(int vin) {
        vr.removeVehicle(vin);
    }
}
