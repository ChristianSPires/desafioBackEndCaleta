package com.challenge.caleta.repository;

import com.challenge.caleta.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*  Neste caso não necessitamos de um estereótipo do Spring (@Repository), visto que, ao extender o JpaRepository,
 *   o Spring já reconhece que esta interface será do tipo Repository    */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByPlayerId(Long playerId);
}
