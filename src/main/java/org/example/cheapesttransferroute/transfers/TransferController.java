package org.example.cheapesttransferroute.transfers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/transfers")
public class TransferController {

    private final TransferService transferService;
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public Map<String, Object> PackageInfo() {
        return transferService.PackageInfo();
    }

    @PostMapping
    public void CreateTransfer(@RequestBody Transfer transfer) {
        System.out.println("davposte");
        transferService.CreateTransfer(transfer);
    }
}