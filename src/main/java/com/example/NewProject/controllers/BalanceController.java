package com.example.NewProject.controllers;


import com.example.NewProject.Services.BalanceService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts/balance")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  @GetMapping("/{accountNo}")
  public ResponseEntity<?> balance(@PathVariable int accountNo){

            Integer balance=balanceService.balance(accountNo);
            return ResponseEntity.ok(balance);


  }
}
