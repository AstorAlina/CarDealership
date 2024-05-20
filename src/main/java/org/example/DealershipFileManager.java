package org.example;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    private String inputToFile;

    public String getInputToFile() {
        return inputToFile;
    }

    public void setInputToFile(String inputToFile) {
        this.inputToFile = inputToFile;
    }

    private static final String INVENTORY_FILE = "src/main/resources/";
    //This method should load and read the inventory.csv
    public Dealership getDealership() {
        Dealership dealership = new Dealership("", "", "");

        //Get user input to choose which inventory.csv to view

        String inventoryFilePath = INVENTORY_FILE + getInputToFile();
        System.out.println(inventoryFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath))) {

            //deserialize the first line to import the information into Dealership
            String line = reader.readLine();//only deserialize the first line
            String[] title = line.split("\\|");
            String name = title[0];
            String address = title[1];
            String phone = title[2];
            dealership = new Dealership(name, address, phone);

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            //deserialize the rest of the line to import the information into Vehicle
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
            dealership.setVehicle(vehicles);
        }

        catch(IOException ex){
            System.out.println("Sorry couldn't read the file." + ex.getMessage());
        }
        return dealership;
    }

    //This method will overwrite the inventory.csv file with the current dealership information and inventory list
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INVENTORY_FILE, false))) {
            //need to write to csv the title line
            String titleToFile = String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            writer.write(titleToFile);

            //writes the inventory of vehicles to csv
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String inventoryToFile = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
                        //vehicle.contractDate());
                        //vehicle.customerName());
                        //vehicle.customerEmail());
                        //vehicle.vehicleSold());
                writer.newLine();
                writer.write(inventoryToFile);
                //optional message
                //System.out.println("Printed successfully!");
            }
        } catch (IOException ex) {
            System.out.println("Couldn't open the file");
        }
    }


}
