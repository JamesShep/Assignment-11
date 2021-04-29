package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findTransactions() {
        List<Transaction> transactions = transactionRepository.findTransactions();
        transactions.sort(Comparator.comparing(Transaction::getDate));
        return transactions;
    }

    public Transaction findById(Long transactionId) {
        Optional<Transaction> transactionOptional = transactionRepository.findTransactions()
                .stream()
                .filter(transaction -> transaction.getId()
                .equals(transactionId))
                .findAny();
        return transactionOptional.orElse(new Transaction());
    }


}
