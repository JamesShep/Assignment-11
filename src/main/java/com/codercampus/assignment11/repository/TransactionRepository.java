package com.codercampus.Assignment11.repository;

import com.codercampus.Assignment11.domain.Transaction;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository () {
        getData();
    }

    public List<Transaction> findTransactions() {
        return transactions;
    }

    @SuppressWarnings("unchecked")
    private void getData() {
        try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            this.transactions = (List<Transaction>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
