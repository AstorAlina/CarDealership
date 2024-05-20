package org.example;

import org.example.Contract;
import org.example.Vehicle;
import java.time.LocalDate;

public class LeaseContract extends Contract {

    private double endingValue;
    private double leaseFee;

    public LeaseContract(String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);
        this.endingValue = getEndingValue();
        this.leaseFee = getLeaseFee();
    }

    @Override
    public double getTotalPrice() {
        return (getLeaseFee() + getEndingValue());
    }

    @Override
    public double getMonthlyPayment() {
        double depreciationFee = (getVehicleSold().getPrice() - getEndingValue()) /36;
        double moneyFactor = (0.04 / 2400);
        double financeFee = ((getVehicleSold().getPrice() + getEndingValue()) + moneyFactor);
        double leaseFeePerMonth = (getLeaseFee() / 36);
        return ((depreciationFee + financeFee) + leaseFeePerMonth);
    }

    public double getEndingValue() {
        return (getVehicleSold().getPrice() * 0.5);
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return (getVehicleSold().getPrice() * 0.07);
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
