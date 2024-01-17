package org.example.mapper;

import org.example.dto.TransactionDto;
import org.example.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    private ClientMapper clientMapper;

    public TransactionMapper(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    public List<TransactionDto> mapListToTransactionDto(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public TransactionDto map(Transaction transaction) {

        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setTotalAmount(transaction.getTotalAmount());
        transactionDto.setClientId(transactionDto.getClientId());

        return transactionDto;
    }

    public Transaction map(TransactionDto transactionDto) {

        Transaction transaction = new Transaction();
        transaction.setId(transactionDto.getId());
        transaction.setDate(transactionDto.getDate());
        transaction.setTotalAmount(transactionDto.getTotalAmount());
        transaction.setClient(transactionDto.getClientId());

        return transaction;
    }
}
