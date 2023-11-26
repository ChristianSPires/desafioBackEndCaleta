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

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public void save (Player player) {
        playerRepository.save(player);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void rollbackTransaction(Long playerId, double transactionValue) {
        Player player = playerRepository.findById(playerId).orElse(null);

        if (player != null) {
            player.setBalance(player.getBalance() + transactionValue);
            playerRepository.save(player);
        }
    }

}