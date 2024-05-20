package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicle;
    List<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicle = new ArrayList<>();
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(ArrayList<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        // needs user input to accept min and max price
        return this.vehicle.stream()
                .filter(v -> v.getPrice() >= min && v.getPrice() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return this.vehicle.stream()
                .filter(v -> v.getMake().toUpperCase().contains(make) && v.getModel().toUpperCase().contains(model))
                .toList();
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return this.vehicle.stream()
                .filter(v -> v.getYear() >= min && v.getYear() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return this.vehicle.stream()
                .filter(v -> v.getColor().toUpperCase().contains(color))
                .toList();
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        return this.vehicle.stream()
                .filter(v -> v.getOdometer() >= min && v.getOdometer() <= max)
                .toList();
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return this.vehicle.stream()
                .filter(v -> v.getVehicleType().toUpperCase().contains(vehicleType))
                .toList();
    }

    public List<Vehicle> getVehiclesByVin(int vin) {
        return this.vehicle.stream()
                .filter(v -> v.getVin() == vin)
                .toList();
    }

    public Vehicle vehicleIsAvailable(int vin) {
        for (Vehicle vehicleIsAvailable : inventory) {
            if (vehicleIsAvailable.getVin() == vin) {
                return vehicleIsAvailable;
            }
        }
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        return this.vehicle.stream()
                .filter(Objects::nonNull)
                .toList();
    }
  
    public void addVehicle(Vehicle vehicle) {
        this.vehicle.add(vehicle);
    }

//    public void removeVehicle(Vehicle vehicle) {
//        this.vehicle.remove(vehicle);
//    }

    public void removeVehicle(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vin == vehicle.getVin()) {
                inventory.remove(vehicle);
                break;
            }
        }
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
}
