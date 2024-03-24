package org.example.controller;

import org.example.dto.TransactionDto;
import org.example.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionDto saveTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.saveTransaction(transactionDto);
    }

    @GetMapping
    public List<TransactionDto> getAll() {
        return transactionService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}
