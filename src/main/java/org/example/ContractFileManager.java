package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static final String filePath = "src/main/resources/contracts.csv";

    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                writer.write(String.format("SALE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        contract.getContractDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold().toString(),
                        salesContract.getSalesTax(),
                        salesContract.getRecordingFee(),
                        salesContract.getProcessingFee(),
                        contract.getTotalPrice(),
                        (salesContract.isFinanced() ? "YES" : "No"),
                        contract.getMonthlyPayment()) + "\n");
            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                writer.write(String.format("LEASE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f",
                        contract.getContractDate(),
                        contract.getCustomerName(),
                        contract.getCustomerEmail(),
                        contract.getVehicleSold().toString(),
                        leaseContract.getEndingValue(),
                        leaseContract.getLeaseFee(),
                        contract.getTotalPrice(),
                        contract.getMonthlyPayment()) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving contract to file");
            throw new RuntimeException(e);
        }
    }
}
