package com.challenge.caleta.controller;

import com.challenge.caleta.model.Player;
import com.challenge.caleta.model.Transaction;
import com.challenge.caleta.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<Map<String, Object>> getBalance(@PathVariable Long id) {
        Player player = playerService.findById(id);

        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("balance", player.getBalance());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bet")
    public ResponseEntity<Map<String, Object>> placeBet(@RequestBody TransactionRequest request) {
        Player player = playerService.findById(request.getPlayerId());

        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        double betAmount = request.getAmount();
        double currentBalance = player.getBalance();

        if (currentBalance < betAmount) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        player.setBalance(currentBalance - betAmount);
        playerService.save(player);

        Transaction transaction = new Transaction(request.getPlayerId(), "BET", betAmount);
        playerService.saveTransaction(transaction);

        Map<String, Object> response = new HashMap<>();
        response.put("balance", player.getBalance());
        response.put("transactionId", transaction.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/win")
    public ResponseEntity<Map<String, Object>> win(@RequestBody TransactionRequest request) {
        Player player = playerService.findById(request.getPlayerId());

        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        double winAmount = request.getAmount();

        player.setBalance(player.getBalance() + winAmount);
        playerService.save(player);

        Transaction transaction = new Transaction(request.getPlayerId(), "WIN", winAmount);
        playerService.saveTransaction(transaction);

        Map<String, Object> response = new HashMap<>();
        response.put("balance", player.getBalance());
        response.put("transactionId", transaction.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/rollback")
    public ResponseEntity<Void> rollback(@RequestBody RollbackRequest request) {

        playerService.rollbackTransaction(request.getPlayerId(), request.getTransactionId(), request.getTransactionAmount());

        return ResponseEntity.ok().build();
    }

    private static class TransactionRequest {
        private Long playerId;
        private double amount;


        public Long getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Long playerId) {
            this.playerId = playerId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    private static class RollbackRequest {
        private Long playerId;
        private Long transactionId;
        private double transactionAmount;

        public Long getPlayerId() {
            return playerId;
        }

        public void setPlayerId(Long playerId) {
            this.playerId = playerId;
        }

        public Long getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(Long transactionId) {
            this.transactionId = transactionId;
        }

        public double getTransactionAmount() {
            return transactionAmount;
        }

        public void setTransactionAmount(double transactionAmount) {
            this.transactionAmount = transactionAmount;
        }
    }
}
