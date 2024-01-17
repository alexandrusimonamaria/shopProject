package org.example.service;

import org.example.dto.TransactionDto;
import org.example.mapper.TransactionMapper;
import org.example.model.Transaction;
import org.example.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }


    public TransactionDto saveTransaction(TransactionDto transactionDto) {
        Transaction dbTransaction = transactionRepository.save(transactionMapper.map(transactionDto));
        return transactionMapper.map(dbTransaction);
    }

    public List<TransactionDto> getAll() {
        List<Transaction> allProduct = transactionRepository.findAll();
        return transactionMapper.mapListToTransactionDto(allProduct);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
