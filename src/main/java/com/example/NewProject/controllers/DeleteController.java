package com.example.NewProject.controllers;

import com.example.NewProject.Services.DeleteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/accounts")
public class DeleteController {
    private static final Logger logger = LoggerFactory.getLogger(DeleteController.class);
    @Autowired
    private DeleteService deleteService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping("/{accountNo}")
    public ResponseEntity<String> deleteAccount(@PathVariable int accountNo) {

            boolean isDeleted = deleteService.deleteAccnt(accountNo);
            if (isDeleted) {
                return ResponseEntity.ok("Deleted the account successfully");
            } else {
                return ResponseEntity.badRequest().body("Account not found or cannot be deleted");
            }

    }
}
