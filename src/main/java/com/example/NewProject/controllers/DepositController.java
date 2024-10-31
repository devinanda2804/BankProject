package com.example.NewProject.controllers;

import com.example.NewProject.Services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/deposit")
public class DepositController {
@Autowired
private DepositService depositService;

   @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @PostMapping("/{accountNo}/{amount}")
    public ResponseEntity<String> Deposit(@PathVariable int accountNo,@PathVariable int amount) {

            boolean message= depositService.deposit(accountNo,amount);
            if (message) {
                return ResponseEntity.ok("Deposit successful.");
            }
            else {
                return ResponseEntity.badRequest().body("Failed to deposit amount or account does not exist.");
            }


    }
}
