package org.example.cheapesttransferroute.transfers;

import java.util.List;

public class Transfer {
    public int maxWeight;
    public List<Package> availableTransfers;

    public Transfer(int maxWeight, List<Package> packages) {
        this.maxWeight = maxWeight;
        this.availableTransfers = packages;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    public List<Package> getPackages() {
        return availableTransfers;
    }
    public void setPackages(List<Package> packages) {
        this.availableTransfers = packages;
    }

    @Override
    public String toString() {
        return "TransferRequest{" +
                "maxWeight=" + maxWeight +
                ", availableTransfers=" + availableTransfers.toString() +
                '}';
    }
}
