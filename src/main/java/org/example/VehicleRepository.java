package org.example;


import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private BasicDataSource basicDataSource;

    public VehicleRepository(String url, String userName, String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public List<Vehicle> getAllVehicles() {
        String query = "{CALL GetAllVehicles()}";

        List<Vehicle> allVehicles = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);
                System.out.println(year);
                allVehicles.add(vehicle);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allVehicles;
    }

    public List<Vehicle> getVehicleByPriceRange(double minPrice, double maxPrice) {
        String query = "{CALL GetVehiclesByPriceRange(?,?)}";

        List<Vehicle> vehiclesByPrice = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setDouble(1, minPrice);
            cs.setDouble(2, maxPrice);
            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByPrice.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByPrice;
    }

    public List<Vehicle> getVehicleByMakeAndModel(String make, String model) {
        String query = "{CALL GetVehiclesByMakeAndModel(?,?)}";

        List<Vehicle> vehiclesByMakeAndModel = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, make);
            cs.setString(2, model);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByMakeAndModel.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByMakeAndModel;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        String query = "{CALL GetVehiclesByMileage(?,?)}";

        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, min);
            cs.setInt(2, max);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByMileage.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        String query = "{CALL GetVehiclesByYearRange(?,?)}";

        List<Vehicle> vehiclesByYear = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, min);
            cs.setInt(2, max);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByYear.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String colorChosen) {
        String query = "{CALL GetVehiclesByColor(?)}";

        List<Vehicle> vehiclesByColor = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, colorChosen);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByColor.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByColor;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        String query = "{CALL GetVehiclesByType(?)}";

        List<Vehicle> vehiclesByType = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, type);

            ResultSet resultSet = cs.executeQuery();

            while (resultSet.next()) {
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                vehiclesByType.add(vehicle);
            }
        } catch (SQLException exception) {
        }
        return vehiclesByType;
    }

    public void removeVehicle(int vin) {
        String query = "{CALL RemoveVehicle(?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vin);

            cs.executeQuery();
        } catch (SQLException exception) {
        }
    }

    //    public void createSae
    public void addVehicles(Vehicle vehicle) {
        String query = "{CALL AddVehicle(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vehicle.getVin());
            cs.setInt(2, vehicle.getYear());
            cs.setString(3, vehicle.getVehicleMake());
            cs.setString(4, vehicle.getVehicleModel());
            cs.setString(5, vehicle.getVehicleType());
            cs.setString(6, vehicle.getColor());
            cs.setInt(7, vehicle.getOdometer());
            cs.setDouble(8, vehicle.getPrice());

            cs.executeQuery();
        } catch (SQLException ex) {
        }
    }

    public void addSalesContract(String contractDate, SalesContract salesContract) {
        String query = "{CALL SalesContract(?,?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, contractDate);
            cs.setBoolean(2, salesContract.isFinanceOption());
            cs.setDouble(3, salesContract.getSalesTaxAmount());
            cs.setDouble(4, salesContract.getRecordingFee());
            cs.setDouble(5, salesContract.getProcessingFee());
            cs.setString(6, salesContract.getCustomerName());
            cs.setString(7, salesContract.getCustomerEmail());
            cs.setInt(8, salesContract.getVehicleSold().getVin());

            cs.executeQuery();

        } catch (SQLException exception) {
        }
    }

    public void addLeaseContract(String contractDate, LeaseContract leaseContract){
        String query = "{CALL LeaseContract(?,?,?,?,?,?,?)}";

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setString(1, contractDate);
            cs.setString(2, leaseContract.getCustomerName());
            cs.setString(3, leaseContract.getCustomerEmail());
            cs.setInt(4, leaseContract.getVehicleSold().getVin());
            cs.setDouble(5, leaseContract.getExpectedEndingValue());
            cs.setDouble(6, leaseContract.getLeaseFee());
            cs.setDouble(7,leaseContract.getMonthlyPayment());

            cs.executeQuery();
        }
        catch (SQLException exception) {
        }
    }
    public List<Vehicle> isVehicleAvailable(int vin) {
        String query = "{CALL GetVehicleByAvail(?)}";

        List<Vehicle> isVehicleAvailable = new ArrayList<>();

        try (Connection conn = basicDataSource.getConnection();
             CallableStatement cs = conn.prepareCall(query)) {

            cs.setInt(1, vin);

            ResultSet resultSet = cs.executeQuery();

            while(resultSet.next()){
                int Vin = resultSet.getInt("VIN");
                int year = resultSet.getInt("Year");
                String vehicleMake = resultSet.getString("VehicleMake");
                String vehicleModel = resultSet.getString("VehicleModel");
                String vehicleType = resultSet.getString("VehicleType");
                String color = resultSet.getString("Color");
                int odometer = resultSet.getInt("Odometer");
                double price = resultSet.getDouble("Price");
                boolean sold = resultSet.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(Vin, year, vehicleMake, vehicleModel, vehicleType, color, odometer, price, sold);

                isVehicleAvailable.add(vehicle);
            }
        }
        catch (SQLException exception) {
        }
        return isVehicleAvailable;
    }
}