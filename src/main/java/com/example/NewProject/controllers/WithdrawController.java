package com.example.NewProject.controllers;

import com.example.NewProject.Services.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debit")
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;

   /* @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")*/
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{accountNo}/{amount}")
    public ResponseEntity<String> withdraw(@PathVariable int accountNo, @PathVariable int amount) {
        boolean message = withdrawService.withdraw(accountNo, amount);
            if (message) {

                return ResponseEntity.ok("Withdrawal successful.");
            } else {
                return ResponseEntity.badRequest().body("Account not found");
            }


    }
}
