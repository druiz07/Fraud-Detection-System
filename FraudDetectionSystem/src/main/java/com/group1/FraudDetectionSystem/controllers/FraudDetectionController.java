package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.services.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    @Autowired
    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/checkFraud")
    public String checkFraudulentTransactions() {
        fraudDetectionService.checkFraudulentTransactions();
        return "Fraud detection completed.";
    }
}
