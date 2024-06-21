package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Contract {
    private String Date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private Double getTotalPrice;
    private Double getMonthlyPayment;

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        Date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}