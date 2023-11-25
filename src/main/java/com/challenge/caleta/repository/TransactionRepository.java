package com.challenge.caleta.repository;

import com.challenge.caleta.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByPlayerId(Long playerId);
}
