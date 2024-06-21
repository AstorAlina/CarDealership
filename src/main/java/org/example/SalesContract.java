package org.example;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return (.05 * getVehicleSold().getPrice());
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (getVehicleSold().getPrice() < 10000) {
            return 295;
        } else if (getVehicleSold().getPrice() >= 10000) {
            return 495;
        }
        return 0;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        return (getSalesTaxAmount() + getVehicleSold().getPrice() + recordingFee + getProcessingFee());
        //((vehicle price) * sales tax) + vehicle price + recording fee + Processing fee
    }

    @Override
    public double getMonthlyPayment() {
        if (financeOption == true) {
            if (getVehicleSold().getPrice() >= 10000) {
                //Monthly payment = (loan amount) × (interest rate / 12) / (1 − (1 + (interest rate / 12)) ^ (-loan term)).
                return (getVehicleSold().getPrice() * (0.0425 / 12)) / (1 - (Math.pow(1 + (.0425 / 12), (-48))));
            }
            else if (getVehicleSold().getPrice() < 10000) {
                return (getVehicleSold().getPrice() * (.0525 / 12)) / (1 - (Math.pow(1 + (.0525 / 12), (-24))));
            }
        }
        return 0;
    }
}