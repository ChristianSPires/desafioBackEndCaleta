package com.challenge.caleta.service;

import com.challenge.caleta.model.Player;
import com.challenge.caleta.model.Transaction;
import com.challenge.caleta.repository.PlayerRepository;
import com.challenge.caleta.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final TransactionRepository transactionRepository;

    public PlayerService(PlayerRepository playerRepository, TransactionRepository transactionRepository) {
        this.playerRepository = playerRepository;
        this.transactionRepository = transactionRepository;
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public void save (Player player) {
        playerRepository.save(player);
    }

    public List<Transaction> findByPlayerId(Long playerId) {
        return transactionRepository.findByPlayerId(playerId);
    }

    public void rollback (Transaction transaction){
        transaction.setActive(false);
        transactionRepository.save(transaction);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void rollbackTransaction(Long playerId, Long transactionId, double transactionAmount) {
        Player player = playerRepository.findById(playerId).orElse(null);

        if (player != null) {
            // Rollback logic here, depending on your requirements
            // For example, you might want to add the transaction amount back to the player's balance
            player.setBalance(player.getBalance() + transactionAmount);
            playerRepository.save(player);
        }
    }

}