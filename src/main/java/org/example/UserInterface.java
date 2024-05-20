package org.example;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager fileManager;

    public UserInterface() {
//        fileManager = new DealershipFileManager();
//        dealership = fileManager.getDealership();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public void init() {
        //this.dealership = fileManager.getDealership();
        System.out.println("""
                Which Dealership would you like to view?
                1)D & B Used Cars
                2)Raymundo's Exotic Cars
                3)Carl's Best Beaters Car
                Please enter one of the choices above!
                """);
        String input = scanner.nextLine().trim();
        switch (input) {
            case "1":
                DealershipFileManager.setInputToFile("inventory.csv");
                dealership = DealershipFileManager.getDealership();
                System.out.println(DealershipFileManager.getInputToFile());
//                fileManager.getDealership().getAllVehicles();
                break;
            case "2":
                DealershipFileManager.setInputToFile("inventory2.csv");
                dealership = DealershipFileManager.getDealership();
                System.out.println(DealershipFileManager.getInputToFile());
                break;
            case "3":
                DealershipFileManager.setInputToFile("inventory3.csv");
                dealership = DealershipFileManager.getDealership();
                System.out.println(DealershipFileManager.getInputToFile());
                break;
            default:
                break;
        }
    }

    public void display() {
        System.out.println("""
                Welcome to the car dealership!
                Would you like to:
                1) Find vehicles by price range
                2) Find vehicles by make/model
                3) Find vehicles by year range
                4) Find vehicles by color
                5) Find vehicles by mileage range
                6) Find vehicles by type
                7) List all vehicles
                8) Add a vehicle
                9) Remove a vehicle
                10) Buy a car <--
                99) Quit""");

        String userInput = scanner.nextLine().toUpperCase().trim();

        switch (userInput) {
            case "1":
                processGetByPriceRequest();
                break;
            case "2":
                processGetByMakeModelRequest();
                break;
            case "3":
                processGetByYearRequest();
                break;
            case "4":
                processGetByColorRequest();
                break;
            case "5":
                processGetByMileageRequest();
                break;
            case "6":
                processGetByVehicleTypeRequest();
                break;
            case "7":
                processGetAllVehiclesRequest();
                break;
            case "8":
                processAddVehicleRequest();
                break;
            case "9":
                processRemoveVehicleRequest();
                break;
            case "10":
                processPurchaseVehicleRequest();
                break;
            case "99":
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input");

        }
    }

    public void processGetByPriceRequest() {
        System.out.println("To find vehicles by price, enter a minimum and maximum price (in digits, ex: 2000).");
        System.out.println("Enter minimum price:");
        double min = Double.parseDouble(scanner.nextLine().trim());
        System.out.println("Enter maximum price:");
        double max = Double.parseDouble(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {
        System.out.println("To find vehicles, please enter make and model (ex: Ford):");
        System.out.println("Enter the vehicle manufacturer's name:");
        String make = scanner.nextLine().toUpperCase().trim();
        System.out.println("Enter the vehicle model name:");
        String model = scanner.nextLine().toUpperCase().trim();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        System.out.println("To find vehicles by year range, enter the earliest and latest year (in digits, ex: 2000):");
        System.out.println("Enter the earliest year:");
        int min = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the latest year:");
        int max = Integer.parseInt(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest() {
        System.out.println("To find vehicles by color, please enter the color (ex: red):");
        System.out.println("Enter the desired color:");
        String color = scanner.nextLine().toUpperCase().trim();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest() {
        System.out.println("To find vehicles by mileage, please enter min and max mileage (in digits, ex: 2000):");
        System.out.println("Enter the minimum mileage:");
        int min = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the maximum mileage:");
        int max = Integer.parseInt(scanner.nextLine().trim());
        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("To search vehicle by type, enter vehicle type (ex: truck):");
        System.out.println("Enter the vehicle type:");
        String type = scanner.nextLine().toUpperCase().trim();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehiclesRequest() {
        System.out.println("Here is a list of all vehicles:");
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        System.out.println("To add a vehicle, please enter the following information:");
        System.out.println("Enter the vehicle's VIN:");
        int vin = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the vehicle's year:");
        int year = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the vehicle's make:");
        String make = scanner.nextLine().toUpperCase().trim();
        System.out.println("Enter the vehicle's model:");
        String model = scanner.nextLine().toUpperCase().trim();
        System.out.println("Enter the vehicle's type:");
        String type = scanner.nextLine().toUpperCase().trim();
        System.out.println("Enter the vehicle's color:");
        String color = scanner.nextLine().toUpperCase().trim();
        System.out.println("Enter the vehicle's odometer reading:");
        int odometer = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Enter the vehicle's price:");
        double price = Double.parseDouble(scanner.nextLine().trim());
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("Vehicle added and saved successfully.");
        System.out.println("Here is a list of all vehicles:");
        displayVehicles(dealership.getAllVehicles());
        System.out.println("Would you like to add another vehicle? (y/n)");
        String response = scanner.nextLine().toUpperCase().trim();
        if (response.equalsIgnoreCase("Y")) {
            processAddVehicleRequest();
        } else { // user does not want to add another vehicle
            return;
        }
    }

    public void processRemoveVehicleRequest() {
        processGetAllVehiclesRequest();
        System.out.println("To remove a vehicle, please enter the vehicle's VIN:");
        int vin = Integer.parseInt(scanner.nextLine().trim());
        scanner.nextLine();
        Vehicle vehicle = dealership.getVehiclesByVin(vin).get(0);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
        } else {
            dealership.removeVehicle(vin);
            DealershipFileManager.saveDealership(dealership);
            System.out.println("Vehicle removed and saved successfully.");
            processGetAllVehiclesRequest();
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No matching vehicles were found.");
        } else {
            System.out.println("VIN|YEAR|MAKE|MODEL|TYPE|COLOR|MILEAGE|PRICE");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        NumberFormat.getCurrencyInstance().format(vehicle.getPrice()));
            }
        }
    }

    public void processPurchaseVehicleRequest() {
        System.out.println("Choose (1) buy a vehicle or (2) lease a vehicle");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                processBuyVehicleRequest();
                display();
                break;
            case 2:
                processLeaseVehicleRequest();
                display();
                break;
        }
    }

    public void processBuyVehicleRequest() {
        System.out.println("To buy a car enter your full name:");
        String name = scanner.nextLine();
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        boolean finance = true;
        System.out.println("Enter the VIN of the vehicle you'd like to buy:");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("Would you like to finance?");
        String financeOption = scanner.nextLine();
        finance = !financeOption.equalsIgnoreCase("No");

            Vehicle vehicle = dealership.vehicleIsAvailable(vin);
            Contract contract = new SalesContract(name, email, vehicle, finance);
            ContractFileManager.saveContract(contract);
            dealership.removeVehicle(vin);
            DealershipFileManager.saveDealership(dealership);

    }
        public void processLeaseVehicleRequest() {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Please enter a valid email address: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Please enter the vin of the vehicle you would like to purchase: ");
            int vehicleVin = Integer.parseInt(scanner.nextLine());
            Vehicle vehicle = dealership.vehicleIsAvailable(vehicleVin);
            Contract contract = new LeaseContract(name, emailAddress, vehicle);
            ContractFileManager.saveContract(contract);
            dealership.removeVehicle(vehicleVin);
            DealershipFileManager.saveDealership(dealership);
        }


}

