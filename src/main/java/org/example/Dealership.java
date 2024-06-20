package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dealership {

    private int id;
    private String name;
    private String address;
    private String phone;
//    public Dealership(int id, String name, String address, String phone) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.vehicle = new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public ArrayList<Vehicle> getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(ArrayList<Vehicle> vehicle) {
//        this.vehicle = vehicle;
//    }


    VehicleRepository repo = new VehicleRepository("jdbc:mysql://localhost:3306/dealership", "root", "YUm15510n");

    public Dealership(int i, String Automotive, String s, String s1) {
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        // needs user input to accept min and max price
//        return this.vehicle.stream()
//                .filter(v -> v.getPrice() >= min && v.getPrice() <= max)
//                .toList();
        return repo.getVehicleByPriceRange(min, max);
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
//        return this.vehicle.stream()
//                .filter(v -> v.getMake().toUpperCase().contains(make) && v.getModel().toUpperCase().contains(model))
//                .toList();
        return repo.getVehicleByMakeAndModel(make, model);
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
//        return this.vehicle.stream()
//                .filter(v -> v.getYear() >= min && v.getYear() <= max)
//                .toList();
        return repo.getVehiclesByYear(min, max);
    }

    public List<Vehicle> getVehiclesByColor(String color) {
//        return this.vehicle.stream()
//                .filter(v -> v.getColor().toUpperCase().contains(color))
//                .toList();
        return repo.getVehiclesByColor(color);
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
//        return this.vehicle.stream()
//                .filter(v -> v.getOdometer() >= min && v.getOdometer() <= max)
//                .toList();
        return repo.getVehicleByMileage(min, max);
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
//        return this.vehicle.stream()
//                .filter(v -> v.getVehicleType().toUpperCase().contains(vehicleType))
//                .toList();
//
        return repo.getVehiclesByType(vehicleType);
    }

//    public List<Vehicle> getVehiclesByVin(int vin) {
////        return this.vehicle.stream()
////                .filter(v -> v.getVin() == vin)
////                .toList();
//    }


    public Vehicle vehicleIsAvailable(int vin) {
//        for (Vehicle vehicleIsAvailable : inventory) {
//            if (vehicleIsAvailable.getVin() == vin) {
//                return vehicleIsAvailable;
//            }
//        }
//        return null;
        return (Vehicle) repo.isVehicleAvailable(vin);
    }

    public List<Vehicle> getAllVehicles() {
//        return this.vehicle.stream()
//                .filter(Objects::nonNull)
//                .toList();
        return repo.getAllVehicles(id);
    }


    public void addVehicle(Vehicle vehicle) {
//        this.vehicle.add(vehicle);
        repo.addVehicles(vehicle);

    }

    public void addSalesContract(String contractDate, SalesContract salesContract) {
        repo.addSalesContract(contractDate, salesContract);
    }

    public void addLeaseContract(String contractDate, LeaseContract leaseContract) {
        repo.addLeaseContract(contractDate, leaseContract);
    }
//    public void removeVehicle(Vehicle vehicle) {
//        this.vehicle.remove(vehicle);
//    }

    public void removeVehicle(int vin) {
//        for (Vehicle vehicle : inventory) {
//            if (vin == vehicle.getVin()) {
//                inventory.remove(vehicle);
//                break;
        repo.removeVehicle(vin);
    }
}

//    public void setInventory(ArrayList<Vehicle> inventory) {
//        this.inventory = inventory;
//    }
