package org.example;

import java.time.LocalDate;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;


    public SalesContract(String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(customerName, customerEmail, vehicleSold);
        this.salesTax = getSalesTax();
        this.recordingFee = getRecordingFee();
        this.processingFee = getProcessingFee();
        this.isFinanced = isFinanced;
    }

    //make sure this should be here
    @Override
    public double getTotalPrice() {
        return (getSalesTax() + getVehicleSold().getPrice() + getRecordingFee() + getProcessingFee());
    }

    @Override
    public double getMonthlyPayment() {
        if (getVehicleSold().getPrice() > 10000) {
            return getVehicleSold().getPrice() * (0.0425 / 12) / Math.pow(1 - (1 + (0.0425 / 12)), (-48));
        }
        else if (getVehicleSold().getPrice() < 10000) {
            return getVehicleSold().getPrice() * (0.0525 / 12) / Math.pow(1 - (1 + (0.0525 / 12)), (-24));
        }
        else {
            return 0;
        }
    }

    public double getSalesTax() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        recordingFee = 100;
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (getVehicleSold().getPrice() < 10000) {
            processingFee = 295;
        }
        else if (getVehicleSold().getPrice() >= 10000) {
            processingFee = 495;
        }
        return 0;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
}
