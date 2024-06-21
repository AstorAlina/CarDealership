package org.example;

public class LeaseContract extends Contract {
    private double ExpectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValue() {
        return (getVehicleSold().getPrice() * .50);
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        ExpectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return (getVehicleSold().getPrice() * .07);
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getLeaseFee() + getExpectedEndingValue());
    }

    @Override
    public double getMonthlyPayment() {
//        ((original price - expected ending value) / lease term) = depreciation fee
        double depreciationFee = (getVehicleSold().getPrice() - getExpectedEndingValue()) / 36;
//        (interest rate / 2400) = money factor
        double moneyFactor = (.04 / 2400);
//        ((original price + expected ending value) * money factor) = finance fee
        double financeFee = ((getVehicleSold().getPrice() + getExpectedEndingValue()) * moneyFactor);
//        (Lease fee / lease term) = Lease fee per month
        double leaseFeePerMonth = (getLeaseFee() / 36);
//        (depreciation fee + finance fee + lease fee per month) = total monthly payment
        return ((depreciationFee + financeFee) + leaseFeePerMonth);
    }

}