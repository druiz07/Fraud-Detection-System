package com.group1.FraudDetectionSystem.controllers;

import com.group1.FraudDetectionSystem.services.FraudDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling fraud detection requests.
 */
@RestController
@RequestMapping("/fraud")
public class FraudDetectionController {

    private final FraudDetectionService fraudDetectionService;

    /**
     * Constructs a FraudDetectionController with the given FraudDetectionService.
     *
     * @param fraudDetectionService the service to handle fraud detection logic
     */
    @Autowired
    public FraudDetectionController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    /**
     * Endpoint to check for fraudulent transactions.
     *
     * @return a String message indicating that fraud detection has been completed.
     */
    @PostMapping("/checkFraud")
    public String checkFraudulentTransactions() {
        fraudDetectionService.checkFraudulentTransactions();
        return "Fraud detection completed.";
    }
}
