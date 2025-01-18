package org.example.cheapesttransferroute.transfers;

import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class TransferService {
    private int totalCost = 0;
    private int totalWeight = 0;
    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public Map<String, Object> PackageInfo() {
        List<Package> selectedTransfers = transferRepository.findAll();
        transferRepository.deleteAll();

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("selectedTransfers", selectedTransfers);
        response.put("totalCost", totalCost);
        response.put("totalWeight", totalWeight);

        System.out.println("Response: " + response);
        return response;
    }

    public void CreateTransfer(Transfer transfer) {
        int maxWeight = transfer.getMaxWeight();
        List<Package> packages = transfer.getPackages();
        Collections.sort(packages);
        GetResultPackages(maxWeight, packages);
    }

    public int[][] GetKnapsackMatrix(int maxWeight, List<Package> packages) {
       int[][] matrix = new int[packages.size() + 1][maxWeight + 1];
       for (int i = 1; i <= packages.size(); i++) {
           for(int j = 0; j < maxWeight + 1; j++) {
               if(packages.get(i - 1).getWeight() > j){
                   matrix[i][j] = matrix[i - 1][j];
               }else{
                   matrix[i][j] = Math.max(packages.get(i - 1).getCost() + matrix[i - 1][j - packages.get(i - 1).getWeight()], matrix[i - 1][j]);
               }
           }
       }
       return matrix;
    }

    public void GetResultPackages(int maxWeight, List<Package> packages){
        int[][] resultDP = GetKnapsackMatrix(maxWeight, packages);

        totalCost = resultDP[packages.size()][maxWeight];
        totalWeight = 0;

        int i = packages.size();
        int j = maxWeight;

        while(i > 0 && j > 0){
            if (resultDP[i][j] != resultDP[i - 1][j]) {
                transferRepository.save(packages.get(i - 1));
                totalWeight += packages.get(i - 1).getWeight();
                j -= packages.get(i - 1).getWeight();
            }
            i--;
        }
    }
}
