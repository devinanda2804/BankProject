
package com.example.NewProject.controllers;

import com.example.NewProject.Domain.TransactionDetails;
import com.example.NewProject.Services.TransactionsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionsService transactionsService;
    @ApiOperation(value = "Find by account number",
                  notes = "Provide an account number to see the transactions")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{accountNo}")
    public List<TransactionDetails> getTransactionsByAccount(@PathVariable Integer accountNo) {
        return transactionsService.getTransactionsByAccount(accountNo);
    }
}