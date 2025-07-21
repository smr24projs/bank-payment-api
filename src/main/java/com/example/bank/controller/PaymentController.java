
package com.example.bank.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
    
public class PaymentController {

    private double balance = 1000.0;
    private List<String> transactions = new ArrayList<>();

    @GetMapping("/pay")
    public String pay(@RequestParam("amount") double amount) {
        if (amount > balance) {
            return "Insufficient balance.";
        }
        balance -= amount;
        transactions.add("Paid: " + amount);
        return "Payment of " + amount + " successful.";
    }

    @GetMapping("/balance")
    public String balance() {
        return "Current balance: " + balance;
    }

    @GetMapping("/transactions")
    public List<String> transactions() {
        return transactions;
    }
}
